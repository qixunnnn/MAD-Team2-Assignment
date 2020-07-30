package sg.edu.sg.mad_t02_assignment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.directions.route.AbstractRouting;
import com.directions.route.Route;
import com.directions.route.RouteException;
import com.directions.route.Routing;
import com.directions.route.RoutingListener;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class GpsActivity extends FragmentActivity implements OnMapReadyCallback, RoutingListener {

    //google map object
    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    protected LocationManager locationManager;


    protected LocationListener locationListener;

    LocationRequest mLocationRequest;
    LocationCallback mLocationCallback;
    private LocationSettingsRequest.Builder builder;
    //current and destination location objects
    protected LatLng start = null;
    protected LatLng end = null;
    protected Location endlocation = new Location("");
    boolean firstOrnot = true;

    //to get location permissions.
    private final static int LOCATION_REQUEST_CODE = 23;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    boolean locationPermission = false;

    //polyline object
    private List<Polyline> polylines = null;
    private SharedPreferences MainPreferences;
    TextView distance;
    TextView eta;
    TextView arrvial;
    FloatingActionButton walk;
    FloatingActionButton drive;
    FloatingActionButton walkindicater;
    FloatingActionButton driveindicater;
    Integer speed = 6;
    AbstractRouting.TravelMode ModeOfTransport = AbstractRouting.TravelMode.WALKING;
    Boolean Location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        Spinner dropdown = findViewById(R.id.dropdown);
        walk = findViewById(R.id.walkingbtn);
        arrvial = findViewById(R.id.arrivalTV);
        walkindicater = findViewById(R.id.walkindicater);
        driveindicater = findViewById(R.id.driveindicater);
        distance = findViewById(R.id.distanceTV);
        eta = findViewById(R.id.etaTV);
        final View parentLayout = findViewById(android.R.id.content);
        MainPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);

        Location = MainPreferences.getBoolean("locationpermission", false);
        walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeOfTransport = AbstractRouting.TravelMode.WALKING;
                speed = 6;
                if (end != null) {
                    requestLocationUpdates(locationManager);
                }

                Snackbar snackbar = Snackbar.make(parentLayout, "Mode of Transport changed to Walking", Snackbar.LENGTH_LONG);
                snackbar.show();

                walkindicater.show();
                driveindicater.hide();

            }
        });
        drive = findViewById(R.id.drivingbtn);
        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModeOfTransport = AbstractRouting.TravelMode.DRIVING;
                speed = 40;
                if (end != null) {
                    requestLocationUpdates(locationManager);
                }
                Snackbar snackbar = Snackbar.make(parentLayout, "Mode of Transport changed to Driving", Snackbar.LENGTH_LONG);
                snackbar.show();
                driveindicater.show();
                walkindicater.hide();
            }
        });


        final String[] blocks = new String[]{"Choose your destination here", "Blk 31(School ICT)", "Blk 23(Electrical Engineering)", "Blk 34(DE)", "Blk 52(FMS)", "Blk 72(BA)", "Blk 83(LSCT)"};
        final LatLng[] coordinates = new LatLng[]{null, new LatLng(1.3336, 103.7750), new LatLng(1.3339, 103.775454), new LatLng(1.333599, 103.774022), new LatLng(1.3320, 103.7753), new LatLng(1.331770, 103.776039), new LatLng(1.3301, 103.7744)};
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                // TODO Auto-generated method stub
                String msg = "Updated Location: " +
                        Double.toString(location.getLatitude()) + "," +
                        Double.toString(location.getLongitude());
                Log.d("location", msg);
                start = new LatLng(location.getLatitude(), location.getLongitude());

                if (endlocation != null) {
                    float distanceInKM = location.distanceTo(endlocation) / 1000; //to KM

                    distance.setText(String.format("%.2f", distanceInKM) + "Km");
                    //average walking speed is 6km/h
                    //average driving speed in school zone is 40km/h
                    float estimatedTimeOfArrival = 60 * (distanceInKM / speed); //to mins

                    eta.setText(String.format("%.2f", estimatedTimeOfArrival) + "mins");
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.MINUTE, (int) estimatedTimeOfArrival);
                    SimpleDateFormat df = new SimpleDateFormat("hh:mm aaa");
                    String formattedDate = df.format(c.getTime());
                    arrvial.setText("ETA: " + formattedDate);
                }
                if (firstOrnot) {

                    CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                            start, 16f);
                    mMap.animateCamera(cameraUpdate);
                    firstOrnot = false;
                }

                getMyLocation();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        //for drop down menu
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, blocks) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                try {
                    if (position == 0) {

                        stopLocationUpdates();
                    } else requestLocationUpdates(locationManager);
                    switch (position) {
                        case 0:
                            //empty destination selected
                            end = null;
                            distance.setText("");
                            eta.setText("");
                            arrvial.setText("");

                            break;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            if (locationPermission == true) {
                                end = coordinates[position];
                                endlocation.setLatitude(end.latitude);
                                endlocation.setLongitude(end.longitude);
                                Snackbar snackbar = Snackbar.make(parentLayout, "Navigating to "+ blocks[position], Snackbar.LENGTH_LONG);
                                snackbar.show();
                                break;
                            } else {
                                Snackbar snackbar = Snackbar.make(parentLayout, "Location permission not given, please enable it in the settings", Snackbar.LENGTH_LONG);
                                snackbar.show();
                            }


                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + position);
                    }
                }
                catch (SecurityException e)
                {
                    Snackbar snackbar = Snackbar.make(parentLayout, "Location permission not given, please enable it in the settings", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        //request location permission.
        requestPermision();
        getLastLocation();
        //init google map fragment to show map.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        requestLocationUpdates(locationManager);

    }

    public void requestLocationUpdates(LocationManager lm) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListener);
    }

    public void getLastLocation() {
        // Get last known recent location
        FusedLocationProviderClient locationClient = getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            start = new LatLng(location.getLatitude(), location.getLongitude());
                            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
                                    start, 16f);
                            mMap.animateCamera(cameraUpdate);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("MapDemoActivity", "Error trying to get last GPS location");
                        e.printStackTrace();
                    }
                });
    }


    //ask for location permission
    public void requestPermision() {

            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        LOCATION_REQUEST_CODE);
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            7);
                }

            } else if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        7);
            } else {
                locationPermission = true;

            }

        }




    //get user location
    private void getMyLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.clear();
        //start route finding
        Findroutes(start,end,ModeOfTransport);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
    }


    // to start finding route
    public void Findroutes(LatLng Start, LatLng End, AbstractRouting.TravelMode MOT) {
        if (Start == null || End == null) {
           // Toast.makeText(GpsActivity.this, "Unable to get location", Toast.LENGTH_SHORT).show();
        } else {

            Routing routing = new Routing.Builder()

                    .travelMode(MOT)
                    .withListener((RoutingListener) this)
                    .alternativeRoutes(true)
                    .waypoints(Start, End)
                    .key("AIzaSyAPUkVAyyKkDhAs2mdcK94edrxlclPX430")
                    .build();
            routing.execute();


        }


    }


    //Routing call back functions.
    @Override
    public void onRoutingFailure(RouteException e) {
        View parentLayout = findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(parentLayout, e.toString(), Snackbar.LENGTH_LONG);
        snackbar.show();
        //Findroutes(start,end);
    }


    @Override
    public void onRoutingStart() {
        //Toast.makeText(MainActivity.this, "Finding Route...", Toast.LENGTH_LONG).show();
    }

    //If Route finding success..
    @Override
    public void onRoutingSuccess(ArrayList<Route> route, int shortestRouteIndex) {

        if (polylines != null) {
            polylines.clear();
        }
        PolylineOptions polyOptions = new PolylineOptions();
        LatLng polylineEndLatLng = null;


        polylines = new ArrayList<>();
        //add route(s) to the map using polyline
        for (int i = 0; i < route.size(); i++) {

            if (i == shortestRouteIndex) {
                polyOptions.color(getResources().getColor(R.color.Green));
                polyOptions.width(7);
                polyOptions.addAll(route.get(shortestRouteIndex).getPoints());
                Polyline polyline = mMap.addPolyline(polyOptions);
                int k = polyline.getPoints().size();
                polylineEndLatLng = polyline.getPoints().get(k - 1);
                polylines.add(polyline);

            } else {

            }

        }

        //Add Marker on route destination
        MarkerOptions endMarker = new MarkerOptions();
        endMarker.position(polylineEndLatLng);
        endMarker.title("Destination");
        mMap.addMarker(endMarker);
    }

    @Override
    public void onRoutingCancelled() {
        Findroutes(start, end,ModeOfTransport);
    }


    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    protected void onStop() {
        super.onStop();
        stopLocationUpdates();

    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocationUpdates();
    }
    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();

    }




    protected void stopLocationUpdates() {
        locationManager.removeUpdates(locationListener);

    }
    protected void startLocationUpdates() {

        // Create the location request to start receiving updates

        mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(10 * 5000);
        mLocationRequest.setFastestInterval(5000);




        // Create LocationSettingsRequest object using location request
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(mLocationRequest);
        LocationSettingsRequest locationSettingsRequest = builder.build();

        // Check whether location settings are satisfied
        SettingsClient settingsClient = LocationServices.getSettingsClient(this);
        settingsClient.checkLocationSettings(locationSettingsRequest);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }


        getFusedLocationProviderClient(this).requestLocationUpdates(mLocationRequest, new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                    }
                },
                Looper.myLooper());


    }
}