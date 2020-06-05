package sg.edu.sg.mad_t02_assignment;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseActivity extends AppCompatActivity {

    private final String TAG = "Course Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_activity);

        setTitle("Courses");

        int mPostID = getIntent().getIntExtra("pos",0);
        Log.v(TAG,"Position of recyclerview: " + String.valueOf(mPostID));

        RecyclerView recyclerView = findViewById(R.id.course_recycler);
        CourseAdapter cAdapter = new CourseAdapter(this, getAllSchool(mPostID)); //Use the position value to return the Arraylist accordingly

        LinearLayoutManager sLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(sLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdapter);

        Log.v(TAG, "Finished Pre-Initialization");
    }

    private ArrayList<CourseModel> getAllSchool(int position) {

        ArrayList<CourseModel> courseList = new ArrayList<>();
        CourseModel courseModel;
        String schoolname = "No school";

        if (position == 0){
            //ADD BA SCHOOL INTO LIST
            courseModel = new CourseModel("Accountancy", "Drive Business Value", R.drawable.balogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Banking & Finance", "Master the Financial Industry", R.drawable.balogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Business Studies", "Shape Business", R.drawable.balogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Common Business Programme", "Build a Solid Foundation", R.drawable.balogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("International Trade & Business", "Think Global", R.drawable.balogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Tourism & Resort Management", "Create Unique Experiences", R.drawable.balogo);
            courseList.add(courseModel);
            schoolname = "BA";

        }
        else if (position == 1)
        {
            //ADD DE SCHOOL INTO LIST
            courseModel = new CourseModel("Design", "Design for Better Living", R.drawable.delogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Real Estate Business", "Market and Manage Properties", R.drawable.delogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Hotel & Leisure Facilities Management", "Deliver World-Class Hospitality & Facilities Management", R.drawable.delogo);
            courseList.add(courseModel);

            schoolname = "DE";
        }
        else if (position == 2)
        {
            //ADD ENGINEER SCHOOL INTO LIST
            courseModel = new CourseModel("Aerospace Engineering", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Electrical Engineer", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Automation & Mechatronic System", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Biomedical Engineering", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Common Engineering Programme", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Electrical & Computer Engineering", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Engineering Science", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Marina & Offshore Technology", "", R.drawable.soelogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Mechanical Engineering", "", R.drawable.soelogo);
            courseList.add(courseModel);

            schoolname = "Engineering";
        }
        else if (position == 3)
        {
            //ADD HMS SCHOOL INTO LIST
            courseModel = new CourseModel("Community Development", "Work with Purpose", R.drawable.hmslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Early Childhood Development", "Nurture and care for young children", R.drawable.hmslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Tamil Studies with Early Education", "Delve into Tamil language, history and customs", R.drawable.hmslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Arts Business Management", "Manage creative businesses", R.drawable.hmslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Chinese Media & Communication", "Embark on careers in media and public relations", R.drawable.hmslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Chinese Studies", "Work in business, education or culture and heritage", R.drawable.hmslogo);
            courseList.add(courseModel);

            schoolname = "HMS";
        }
        else if(position == 4)
        {
            //ADD HS SCHOOL INTO LIST
            courseModel = new CourseModel("Nursing", "Transform Lives", R.drawable.hslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Optometry", "Safeguard Sight", R.drawable.hslogo);
            courseList.add(courseModel);

            schoolname = "HS";
        }

        else if(position == 5)
        {
            //ADD FMS SCHOOL INTO LIST
            courseModel = new CourseModel("Media Post-Production", "Behind the Scene", R.drawable.fmslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Film, Sound and Video", "Become an editor", R.drawable.fmslogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Mass Communication", "All-rounder Media", R.drawable.fmslogo);
            courseList.add(courseModel);

            schoolname = "FMS";
        }

        else if(position == 6)
        {
            //ADD ICT SCHOOL INTO LIST
            courseModel = new CourseModel("Data Science", "Transform Data into Value", R.drawable.ictlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Immersive Media", "Create Awesome User Experience", R.drawable.ictlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Common ICT Programme", "Explore Infocomm Frontiers", R.drawable.ictlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Cybersecurity & Digital Forensics", "Fight Cybercrime", R.drawable.ictlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Information Technology", "Be an All-Rounded Tech Pro", R.drawable.ictlogo);
            courseList.add(courseModel);

            schoolname = "ICT";
        }
        else if (position == 7)
        {
            //ADD LSCT SCHOOL INTO LIST
            courseModel = new CourseModel("Biomedical Science", "Discover Medical Breakthroughs", R.drawable.lsctlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Pharmaceutical Science", "Manage Drug Therapy", R.drawable.lsctlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Environmental & Water Technology", "Combat Environmental Challenges", R.drawable.lsctlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Landscape Design & Horticulture", "Innovate Green Landscapes", R.drawable.lsctlogo);
            courseList.add(courseModel);

            courseModel = new CourseModel("Chemical & Biomolecular Engineering", "Combine Expertise for Diverse Industries", R.drawable.lsctlogo);
            courseList.add(courseModel);

            schoolname = "LSCT";
        }

        Log.v(TAG,"Returning: " + schoolname + "list");
        return courseList; //RETURN SCHOOL LIST
    }

}

