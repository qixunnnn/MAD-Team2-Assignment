package sg.edu.sg.mad_t02_assignment;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences MainPreferences;
    private SharedPreferences.Editor MainPrefsEditor;
    private String username;
    private TextView title;
    final String TAG = "Home Page";
    private VideoView npVideo;
    private FloatingActionButton gps;
    private final static int LOCATION_REQUEST_CODE = 23;

    //Put all card view ID where
    private static final int[] CARDVIEW_ID = {
            R.id.cardviewCalendar, R.id.cardviewSchool, R.id.cardviewSettings,
            R.id.cardviewBook, R.id.cardviewContact, R.id.cardviewSuit
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);

        username = MainPreferences.getString("username", "");
        gps = findViewById(R.id.gpsBtn);
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GpsActivity.class);
                startActivity(intent);
            }
        });
        npVideo = findViewById(R.id.video_mainmenu);
        npVideo.setVideoURI(
                Uri.parse("android.resource://" + getPackageName() +  "/" +R.raw.npvideo)
        );
        npVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0,0);
            }
        });
        npVideo.start();
        title = findViewById(R.id.loginUser);
        setTitle("Home");
       // GpsActivity permission = new GpsActivity();
       // permission.requestPermision();
        requestPermision();

        //Assigning local variable to ID

        for (final int id: CARDVIEW_ID)
        {
            findViewById(id).setOnClickListener(this);
        }
        Log.v(TAG, "Finished Pre-Initialization");
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
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
           // locationPermission = true;
            MainPrefsEditor = getSharedPreferences("location", MODE_PRIVATE).edit();
            MainPrefsEditor.putBoolean("locationpermission", true);
            MainPrefsEditor.apply();

        }
    }

    @Override
    public void onClick(View v) {
        Intent i = null;

        Log.v(TAG,v.getId() + " Is clicked");
        //Redirect to their specific activity
        if (v.getId() == CARDVIEW_ID[0])
        {
            i = new Intent(this,AcadCalendar.class);
        }
        else if (v.getId() == CARDVIEW_ID[1])
        {
            i = new Intent(this,schoolactivity.class);
        }
        else if (v.getId() == CARDVIEW_ID[2])
        {
            i = new Intent(this,SettingActivity.class);
        }
        else if (v.getId() == CARDVIEW_ID[3])
        {
            i = new Intent(this, BookActivity.class);
        }
        else if (v.getId() == CARDVIEW_ID[4])
        {
            i = new Intent(this, ContactActivity.class);
        }
        else if (v.getId() == CARDVIEW_ID[5])
        {
            i = new Intent(this, CourseSuit.class);
        }
        startActivity(i);
    }

    @Override
    protected void onStop() {
        super.onStop();
        npVideo.stopPlayback();
    }
}
