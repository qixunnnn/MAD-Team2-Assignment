package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.URI;
import java.util.HashMap;

public class Admin_AddSchool extends AppCompatActivity{

    private final String TAG = "Admin Add Course";
    private DatabaseReference mDatabase;
    private Button addBtn;
    private EditText etName;
    private EditText etMotto;
    private EditText etURL;
    private Spinner spinner;
    private String school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__add_school);

        setTitle("Add Course");

        mDatabase = FirebaseDatabase.getInstance().getReference("Schools");

        addBtn = findViewById(R.id.buttonAddCourse);
        etName = findViewById(R.id.et_CourseName);
        etMotto = findViewById(R.id.et_CourseMotto);
        etURL = findViewById(R.id.et_CourseURL);

        spinner = findViewById(R.id.spinner1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.np_school,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        Log.v(TAG, "Finished Pre-Initialization");

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v(TAG, "Current Position: " + String.valueOf(parent.getSelectedItemPosition()));

                int cPosValue = parent.getSelectedItemPosition();
                school = getSchoolShortForm(cPosValue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String CourseName = etName.getText().toString();
                String CourseMotto = etMotto.getText().toString();
                String CourseURL = etURL.getText().toString();

                if (TextUtils.isEmpty(CourseName) || TextUtils.isEmpty(CourseMotto) || TextUtils.isEmpty(CourseURL))
                {
                    //Check if ET is/are empty
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else if (!Patterns.WEB_URL.matcher(CourseURL).matches())
                {
                    //Check URL validation
                    Toast.makeText(getApplicationContext(), "Please enter an appropriate URL address", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Adding into database
                    createCourse(CourseName, CourseMotto, CourseURL, school);
                    //Intent to admin

                }

            }
        });
    }


    private String getSchoolShortForm(int position)
    {
        String school = "No school";
        switch (position) {
            case 0:
                school = "BA";
                break;
            case 1:
                school = "DE";
                break;
            case 2:
                school = "Engineering";
                break;
            case 3:
                school = "HMS";
                break;
            case 4:
                school = "HS";
                break;
            case 5:
                school = "FMS";
                break;
            case 6:
                school = "ICT";
                break;
            case 7:
                school = "LSCT";
                break;
        }
        return school;
    }

    private void createCourse(final String CourseName, final String CourseMotto, final String CourseURL, final String School)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(Admin_AddSchool.this);
        builder.setTitle("Confirmation");
        builder.setMessage("Are you sure the following information are correct?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String CourseID = mDatabase.push().getKey();
                CourseModel newCourse = new CourseModel(CourseName,CourseMotto,CourseURL, CourseID);
                mDatabase.child(School).child(CourseID).setValue(newCourse);

                Log.v(TAG,"Adding into database: School Name: " + School);
                Log.v(TAG,"Adding into database: Course Name: " + CourseName);
                Log.v(TAG,"Adding into database: Course URL: " + CourseURL);
                Log.v(TAG,"Adding into database: Course Motto: " + CourseMotto);

                Toast.makeText(Admin_AddSchool.this, "Course has been added successfully", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Admin_AddSchool.this, AdminModSchool.class));
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}