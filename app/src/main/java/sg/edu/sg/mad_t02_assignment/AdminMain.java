package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class AdminMain extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "Admin Page";
    private static final int[] CARDVIEW_ID = {
            R.id.cardviewSchoolModi, R.id.cardviewBookModi, R.id.cardviewSettings
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        setTitle("Admin Home");

        for (final int id: CARDVIEW_ID)
        {
            findViewById(id).setOnClickListener(this);
        }
        Log.v(TAG, "Finished Pre-Initialization");

    }

    @Override
    public void onClick(View v) {
        Intent i = null;

        Log.v(TAG,v.getId() + " Is clicked");

        if (v.getId() == CARDVIEW_ID[0])
        {
            i = new Intent(this,AdminModSchool.class);
        }
        else if (v.getId() == CARDVIEW_ID[1])
        {
            i = new Intent(this, AdminAddBookActivity.class);
        }
        else if (v.getId() == CARDVIEW_ID[2])
        {
            i = new Intent(this,SettingActivity.class);
        }
        startActivity(i);
    }
}