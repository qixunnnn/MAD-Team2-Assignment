package sg.edu.sg.mad_t02_assignment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private final String TAG = "Course Activity";
    String schoolname = "Nil";
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Schools");
    RecyclerView recyclerView;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_activity);

        setTitle("Courses");

        int mPostID = getIntent().getIntExtra("pos",0);
        Log.v(TAG,"Position of recyclerview: " + String.valueOf(mPostID));

        recyclerView = findViewById(R.id.course_recycler);
        getAllSchool(mPostID);

        Log.v(TAG, "Finished Pre-Initialization");
    }

    private void getAllSchool(int position) {

        if (position == 0) {
            schoolname = "BA";
        } else if (position == 1)
        {
            schoolname = "DE";
        } else if (position == 2)
        {
            schoolname = "Engineering";
        } else if (position == 3)
        {
            schoolname = "HMS";
        }
        else if(position == 4)
        {
            schoolname = "HS";
        }

        else if(position == 5)
        {
            schoolname = "FMS";
        }

        else if(position == 6)
        {
            schoolname = "ICT";
        }
        else if (position == 7)
        {
            schoolname = "LSCT";
        }

        Log.v(TAG,"Returning: " + schoolname + "list");
        DisplayRecyclerView(schoolname);
    }

    private void DisplayRecyclerView(String school)
    {
        final ArrayList<CourseModel> courseList = new ArrayList<>();
        schoolname = school;
        reference.child(school).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                onResume();
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    CourseModel courseModel = snapshot.getValue(CourseModel.class);
                    courseList.add(courseModel);

                }
                CourseAdapter cAdapter = new CourseAdapter(getApplicationContext(), courseList,schoolname); //Use the position value to return the Arraylist accordingly
                LinearLayoutManager sLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(sLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(cAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

