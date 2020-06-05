package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private SharedPreferences MainPreferences;
    private SharedPreferences.Editor MainPrefsEditor;
    private String username;
    private TextView title;
    final String TAG = "Home Page";

    //Put all card view ID where
    private static final int[] CARDVIEW_ID = {
            R.id.cardviewCalendar, R.id.cardviewSchool, R.id.cardviewSettings, R.id.cardviewBook, R.id.cardviewContact
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);

        username = MainPreferences.getString("username", "");
        //title = findViewById(R.id.title_textview);
        //title.setText();
        setTitle("Welcome " + username);

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

    @Override
    public void onClick(View v) {
        Intent i = null;

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
        startActivity(i);

    }
}
