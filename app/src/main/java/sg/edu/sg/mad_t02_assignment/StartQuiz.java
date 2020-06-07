package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StartQuiz extends AppCompatActivity {

    private static final int[] SchoolID = {
            //stores the id of textview here to reduce repeated codes
            0,0,0,0,0,0,0,0
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);



    }
    private void addScoreIntoSchool(int schoolid)
    {
        SchoolID[schoolid] = SchoolID[schoolid]+=1;
    }
}