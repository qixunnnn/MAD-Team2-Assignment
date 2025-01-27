package sg.edu.sg.mad_t02_assignment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;


public class SettingActivity extends AppCompatActivity {


    private Button signOutButton;
    private String username;
    private Button ChangePassButton;
    //private SharedPreferences settingsPreferences;
    //private SharedPreferences.Editor settingsPrefsEditor;
    AlertDialog.Builder builder;
    private String TAG = "Learning@NP";
    private String FILENAME = "SettingActivity.java";
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setTitle("Settings");
        signOutButton = findViewById(R.id.signOutBtn);
        ChangePassButton = findViewById(R.id.ChangePassBtn);
        //settingsPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        //settingsPrefsEditor = settingsPreferences.edit();
        //username = settingsPreferences.getString("username", "");

        builder = new AlertDialog.Builder(this);
        ChangePassButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(SettingActivity.this,ChangePassActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return false;
            }
        });

        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //alert for user to confirm sign out
                builder.setMessage("Are you sure you want to Sign Out?")
                        .setCancelable(false)
                        //when user press yes
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //settingsPrefsEditor.putBoolean("stayloggedin", false);
                                //settingsPrefsEditor.commit();
                                auth.getInstance().signOut();
                                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                finish();
                                startActivity(intent);


                                Log.v(TAG, "User accept!");

                            }
                        })
                        //when user press no
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();
                                Log.v(TAG, "User declined!");
                            }
                        });

                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Are you sure you want to Sign Out?");
                alert.show();


            }


        });



    }


}
