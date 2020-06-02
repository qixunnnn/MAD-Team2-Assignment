package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String TAG = "Home Page";

    //Put all card view ID where
    private static final int[] CARDVIEW_ID = {
            R.id.cardviewCalendar, R.id.cardviewSchool, R.id.cardviewSettings
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Home");

        //Assigning local variable to ID

        for (final int id: CARDVIEW_ID)
        {
            findViewById(id).setOnClickListener(this);
        }
        Log.v(TAG, "Finished Pre-Initialization");
    }

    @Override
    public void onClick(View v) {
        Intent i;
        //Redirect to their specific activity
        if (v.getId() == CARDVIEW_ID[0])
        {
            i = new Intent(this,AcadCalendar.class);
            startActivity(i);
        }
        else if (v.getId() == CARDVIEW_ID[1])
        {
            i = new Intent(this,schoolactivity.class);
            startActivity(i);
        }
        else if (v.getId() == CARDVIEW_ID[2])
        {
            i = new Intent(this,SettingActivity.class);
            startActivity(i);
        }
    }
}
