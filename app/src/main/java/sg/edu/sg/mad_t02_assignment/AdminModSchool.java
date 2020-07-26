package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdminModSchool extends AppCompatActivity {

    private final String TAG = "Course Activity";
    String schoolname = "Nil";
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Schools");
    RecyclerView recyclerView;
    private Spinner spinner;
    private ArrayList<CourseModel> courseList = new ArrayList<>();
    private CourseAdapter cAdapter;
    private Button addNewCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_mod_school);

        setTitle("Modify School");

        recyclerView = findViewById(R.id.modSchoolRecycler);
        spinner = findViewById(R.id.modSchoolSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.np_school,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        Log.v(TAG, "Finished Pre-Initialization");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v(TAG, "Current Position: " + String.valueOf(parent.getSelectedItemPosition()));

                int cPosValue = parent.getSelectedItemPosition();
                getAllSchool(cPosValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        addNewCourse = findViewById(R.id.addNewCourseBtn);
        addNewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminModSchool.this, Admin_AddSchool.class);
                startActivity(i);
            }
        });

    }
    private void getAllSchool(int position) {

        if (position == 0) {
            schoolname = "BA";
        } else if (position == 1) {
            schoolname = "DE";
        } else if (position == 2) {
            schoolname = "Engineering";
        } else if (position == 3) {
            schoolname = "HMS";
        } else if (position == 4) {
            schoolname = "HS";
        } else if (position == 5) {
            schoolname = "FMS";
        } else if (position == 6) {
            schoolname = "ICT";
        } else if (position == 7) {
            schoolname = "LSCT";
        }

        Log.v(TAG, "Returning: " + schoolname + "list");
        DisplayRecyclerView(schoolname);
    }

    private void DisplayRecyclerView(String school)
    {
        schoolname = school;
        reference.child(school).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                onResume();
                courseList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    CourseModel courseModel = snapshot.getValue(CourseModel.class);
                    courseList.add(courseModel);

                }
                cAdapter = new CourseAdapter(AdminModSchool.this, courseList,schoolname); //Use the position value to return the Arraylist accordingly
                LinearLayoutManager sLayoutManager = new LinearLayoutManager(AdminModSchool.this);
                recyclerView.setLayoutManager(sLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
                recyclerView.setAdapter(cAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
/*            deleteCourse(courseList.get(viewHolder.getAdapterPosition()).getCourseID());
            Log.v(TAG, String.valueOf(courseList.size()));
            Log.v(TAG, String.valueOf(viewHolder.getAdapterPosition()));
            courseList.remove(viewHolder.getAdapterPosition());

            cAdapter.notifyDataSetChanged();*/
            showUpdateDialog(courseList.get(viewHolder.getAdapterPosition()));
        }
    };
    private void deleteCourse(String courseID){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Schools").child(schoolname).child(courseID);

        mDatabase.removeValue();
    }

    private void showUpdateDialog(final CourseModel course){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        final View dialogView = inflater.inflate(R.layout.update_dialog,null);

        dialogBuilder.setView(dialogView);

        final EditText et_name = dialogView.findViewById(R.id.updateName);
        final EditText et_motto = dialogView.findViewById(R.id.updateMotto);
        final EditText et_url = dialogView.findViewById(R.id.updateURL);

        final Button buttonDelete = dialogView.findViewById(R.id.updateDelete);
        final Button buttonUpdate = dialogView.findViewById(R.id.updateUpdate);
        final Button buttonCancel = dialogView.findViewById(R.id.updateCancel);

        dialogBuilder.setTitle("Update course");

        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCourse(course.getCourseID());
                Log.v(TAG,"Deleted + " + course.getCourseName() + "course");
                Toast.makeText(AdminModSchool.this, course.getCourseName() + "has been removed", Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Cancelled for updating course");
                alertDialog.cancel();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Updating course...");
                 String CourseName = et_name.getText().toString();
                 String CourseMotto = et_motto.getText().toString();
                 String CourseURL = et_url.getText().toString();

                if(ValidateUpdate(CourseName,CourseMotto,CourseURL))
                {
                    updateCourse(course.getCourseID(), CourseName, CourseMotto, CourseURL);
                    Toast.makeText(AdminModSchool.this, "Course has been successfully updated", Toast.LENGTH_SHORT).show();
                    alertDialog.cancel();
                }
            }
        });
    }
    private boolean ValidateUpdate(String cName, String cMotto, String cURL){

        if (TextUtils.isEmpty(cName) || TextUtils.isEmpty(cMotto) || TextUtils.isEmpty(cURL))
        {
            //Check if ET is/are empty
            Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else if (!Patterns.WEB_URL.matcher(cURL).matches())
        {
            //Check URL validation
            Toast.makeText(getApplicationContext(), "Please enter an appropriate URL address", Toast.LENGTH_SHORT).show();
        }
        else {
            //Adding into database
            //Intent to admin
            return true;

        }
        return false;
    }

    private void updateCourse(String cID, String cName, String cMotto, String cURL) {

        CourseModel course = new CourseModel(cName,cMotto,cURL,cID);
        reference.child(schoolname).child(cID).setValue(course);
        Log.v(TAG,"Updated course");
    }
}