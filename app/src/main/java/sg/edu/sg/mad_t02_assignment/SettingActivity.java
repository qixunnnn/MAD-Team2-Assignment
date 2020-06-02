package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.Set;


public class SettingActivity extends AppCompatActivity {

    private Button signOutButton;
    private SharedPreferences settingsPreferences;
    private SharedPreferences.Editor settingsPrefsEditor;
    AlertDialog.Builder builder;
    private String TAG = "Learning@NP";
    private String FILENAME = "SettingActivity.java";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        signOutButton = findViewById(R.id.signOutBtn);
        settingsPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        settingsPrefsEditor = settingsPreferences.edit();
        builder = new AlertDialog.Builder(this);

        signOutButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                builder.setMessage("By clicking Yes, you will be brought to the login page and Stay logged in checkbox for you")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                startActivity(intent);
                                settingsPrefsEditor.putBoolean("stayloggedin", false);
                                settingsPrefsEditor.commit();
                                Log.v(TAG, "User accept!");
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
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


                return false;
            }


        });



    }


}
