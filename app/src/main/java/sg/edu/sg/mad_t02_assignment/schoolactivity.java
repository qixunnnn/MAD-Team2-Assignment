package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class schoolactivity extends AppCompatActivity {

    String schools[];
    String s_description[];

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

        schools = getResources().getStringArray(R.array.np_school);
        s_description = getResources().getStringArray(R.array.school_description);



    }
}