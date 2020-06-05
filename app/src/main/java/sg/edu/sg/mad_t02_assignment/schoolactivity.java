package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class schoolactivity extends AppCompatActivity {

    final static String TAG = "School Activity";
    int images[] = {R.drawable.ba,
                    R.drawable.de,
                    R.drawable.soe,
                    R.drawable.hms,
                    R.drawable.hs,
                    R.drawable.fms,
                    R.drawable.ict,
                    R.drawable.lsct};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolactivity);

        RecyclerView recyclerView = findViewById(R.id.schoolRecycle);
        SchoolAdapter sAdapter = new SchoolAdapter(images,this);

        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);

        Log.v(TAG, "Finished Pre-Initialization");


    }
}
