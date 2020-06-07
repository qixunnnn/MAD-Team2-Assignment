package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

public class StartQuiz extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "StartQuiz.java";
    Boolean bool;
    Button submit;
    RadioButton radio;
    RadioGroup radioGroup;

    private static final int[] SchoolID = {
            //stores the id of textview here to reduce repeated codes
            //0 BA,1 HMS,2 IT,3 FMS,4 LS,5 DE,6 E,7 HS
            0,0,0,0,0,0,0,0
    };
    private static final int[] RadioGroup = {
            R.id.radioQ1,
            R.id.radioQ2,
            R.id.radioQ3,
            R.id.radioQ4,
            R.id.radioQ5,
            R.id.radioQ6,
            R.id.radioQ7,
            R.id.radioQ8,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        addListenerOnButton();


    }
    public void addListenerOnButton() {

        radioGroup = (RadioGroup) findViewById(RadioGroup[0]);
        submit = (Button) findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    bool = true;
                    // get selected radio button from radioGroup
                    int selectedId = radioGroup.getCheckedRadioButtonId();
                    radio = (RadioButton) findViewById(selectedId);
                    // find the radiobutton by returned id
                    //Q1
                Log.v(TAG, FILENAME + " /nQuestion 1");
                    if(selectedId != -1) {

                        if (selectedId == 2131230734) {
                            Log.v(TAG, FILENAME + " 1st ticked ");
                            addScoreIntoSchool(0);
                            addScoreIntoSchool(1);
                        }
                        else if (selectedId == 2131230735) {
                            Log.v(TAG, FILENAME + " 2nd ticked ");
                            addScoreIntoSchool(3);
                            addScoreIntoSchool(5);

                        }
                        else if (selectedId == 2131230736) {
                            Log.v(TAG, FILENAME + " 3rd ticked ");
                            addScoreIntoSchool(7);
                            addScoreIntoSchool(4);
                        }
                        else {
                            Log.v(TAG, FILENAME + " 4th ticked ");
                            addScoreIntoSchool(6);
                            addScoreIntoSchool(2);
                        }
                    }
                    //not checked
                    else {
                        Toast.makeText(StartQuiz.this, "Please select an option in question 1", Toast.LENGTH_SHORT).show();
                        bool = false;
                    }

                //Q2
                Log.v(TAG, FILENAME + " /nQuestion 2");
                radioGroup = (RadioGroup) findViewById(RadioGroup[1]);
                    selectedId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                if(selectedId != -1) {

                    if (selectedId == 2131230738) {
                        Log.v(TAG, FILENAME + " 1st ticked ");
                        addScoreIntoSchool(2);
                        addScoreIntoSchool(4);
                    }
                    else if (selectedId == 2131230739) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        addScoreIntoSchool(0);
                        addScoreIntoSchool(7);

                    }
                    else if (selectedId == 2131230740) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        addScoreIntoSchool(5);
                        addScoreIntoSchool(3);
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        addScoreIntoSchool(6);
                        addScoreIntoSchool(1);
                    }
                }
                //not checked
                else {
                    Toast.makeText(StartQuiz.this, "Please select an option in question 2", Toast.LENGTH_SHORT).show();
                    bool = false;
                }

                //Q3
                Log.v(TAG, FILENAME + " /nQuestion 3");
                radioGroup = (RadioGroup) findViewById(RadioGroup[2]);
                selectedId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                if(selectedId != -1) {

                    if (selectedId == 2131230742) {
                        Log.v(TAG, FILENAME + " 1st ticked ");
                        addScoreIntoSchool(4);
                        addScoreIntoSchool(7);
                    }
                    else if (selectedId == 2131230743) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        addScoreIntoSchool(0);
                        addScoreIntoSchool(1);
                    }
                    else if (selectedId == 2131230744) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        addScoreIntoSchool(6);
                        addScoreIntoSchool(5);
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        addScoreIntoSchool(2);
                        addScoreIntoSchool(3);
                    }
                }
                //not checked
                else {
                    Toast.makeText(StartQuiz.this, "Please select an option in question 3", Toast.LENGTH_SHORT).show();
                    bool = false;
                }

                //Q4
                Log.v(TAG, FILENAME + " /nQuestion 4");
                radioGroup = (RadioGroup) findViewById(RadioGroup[3]);
                selectedId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                if(selectedId != -1) {

                    if (selectedId == 2131230746) {
                        Log.v(TAG, FILENAME + " 1st ticked ");
                        addScoreIntoSchool(2);
                        addScoreIntoSchool(3);
                    }
                    else if (selectedId == 2131230747) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        addScoreIntoSchool(5);
                        addScoreIntoSchool(7);
                    }
                    else if (selectedId == 2131230748) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        addScoreIntoSchool(4);
                        addScoreIntoSchool(6);
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        addScoreIntoSchool(1);
                        addScoreIntoSchool(0);
                    }
                }
                //not checked
                else {
                    Toast.makeText(StartQuiz.this, "Please select an option in question 4", Toast.LENGTH_SHORT).show();
                    bool = false;
                }


                //Q5
                Log.v(TAG, FILENAME + " /nQuestion 5");
                radioGroup = (RadioGroup) findViewById(RadioGroup[4]);
                selectedId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                if(selectedId != -1) {

                    if (selectedId == 2131230750) {
                        Log.v(TAG, FILENAME + " 1st ticked ");
                        addScoreIntoSchool(2);
                        addScoreIntoSchool(6);
                    }
                    else if (selectedId == 2131230751) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        addScoreIntoSchool(0);
                        addScoreIntoSchool(1);
                    }
                    else if (selectedId == 2131230752) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        addScoreIntoSchool(3);
                        addScoreIntoSchool(5);
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        addScoreIntoSchool(7);
                        addScoreIntoSchool(4);
                    }
                }
                //not checked
                else {
                    Toast.makeText(StartQuiz.this, "Please select an option in question 5", Toast.LENGTH_SHORT).show();
                    bool = false;
                }

                //Q6
                Log.v(TAG, FILENAME + " /nQuestion 6");
                radioGroup = (RadioGroup) findViewById(RadioGroup[5]);
                selectedId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                if(selectedId != -1) {

                    if (selectedId == 2131230754) {
                        Log.v(TAG, FILENAME + " 1st ticked ");
                        addScoreIntoSchool(0);
                        addScoreIntoSchool(1);
                    }
                    else if (selectedId == 2131230755) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        addScoreIntoSchool(2);
                        addScoreIntoSchool(6);
                    }
                    else if (selectedId == 2131230756) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        addScoreIntoSchool(4);
                        addScoreIntoSchool(7);
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        addScoreIntoSchool(5);
                        addScoreIntoSchool(4);
                    }
                }
                //not checked
                else {
                    Toast.makeText(StartQuiz.this, "Please select an option in question 6", Toast.LENGTH_SHORT).show();
                    bool = false;
                }

                //Q7
                Log.v(TAG, FILENAME + " /nQuestion 7");
                radioGroup = (RadioGroup) findViewById(RadioGroup[6]);
                selectedId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                if(selectedId != -1) {

                    if (selectedId == 2131230758) {
                        Log.v(TAG, FILENAME + " 1st ticked ");
                        addScoreIntoSchool(5);
                        addScoreIntoSchool(4);
                    }
                    else if (selectedId == 2131230759) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        addScoreIntoSchool(6);
                        addScoreIntoSchool(7);
                    }
                    else if (selectedId == 2131230760) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        addScoreIntoSchool(0);
                        addScoreIntoSchool(2);
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        addScoreIntoSchool(3);
                        addScoreIntoSchool(1);
                    }
                }
                //not checked
                else {
                    Toast.makeText(StartQuiz.this, "Please select an option in question 7", Toast.LENGTH_SHORT).show();
                    bool = false;
                }

                //Q8
                Log.v(TAG, FILENAME + " /nQuestion 8");
                radioGroup = (RadioGroup) findViewById(RadioGroup[7]);
                selectedId = radioGroup.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selectedId);
                if(selectedId != -1) {

                    if (selectedId == 2131230762) {
                        Log.v(TAG, FILENAME + " 1st ticked ");
                        addScoreIntoSchool(2);
                        addScoreIntoSchool(6);
                    }
                    else if (selectedId == 2131230763) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        addScoreIntoSchool(4);
                        addScoreIntoSchool(7);
                    }
                    else if (selectedId == 2131230764) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        addScoreIntoSchool(3);
                        addScoreIntoSchool(5);
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        addScoreIntoSchool(0);
                        addScoreIntoSchool(1);
                    }
                }
                //not checked
                else {
                    bool = false;
                    Toast.makeText(StartQuiz.this, "Please select an option in question 8", Toast.LENGTH_SHORT).show();
                }


               if (bool) {
                   //move
                   Arrays.sort(SchoolID);
                   Log.v(TAG, FILENAME + " Sorted" + SchoolID[7]);

                   Intent results = new Intent(StartQuiz.this, ResultActivity.class);
                   results.putExtra("top", SchoolID[7]);
                   results.putExtra("second", SchoolID[6]);
                   results.putExtra("third", SchoolID[])
                   startActivity(results);


               }



            }


        });


    }
    private void addScoreIntoSchool(int schoolid)
    {
        SchoolID[schoolid] = SchoolID[schoolid]+=1;
    }
}