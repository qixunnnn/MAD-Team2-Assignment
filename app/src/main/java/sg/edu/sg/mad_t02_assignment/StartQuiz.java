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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StartQuiz extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "StartQuiz.java";
    Boolean bool;
    Button submit;
    RadioButton radio;
    RadioGroup radioGroup;


    ArrayList<StartQuizModel> Schoollist = new ArrayList<>();

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
        setTitle("Quiz");
        StartQuizModel BA = new StartQuizModel();
        BA.schoolname = "BA";
        BA.score = 0;
        Schoollist.add(BA); //So the list inside got School Name and Score won't lose track. When sorting u can sort their .Score

        Schoollist.add(new StartQuizModel(0,"Humanities & Social Sciences"));
        Schoollist.add(new StartQuizModel(0,"Infocomm Technology"));
        Schoollist.add(new StartQuizModel(0,"Film & Media Studies"));
        Schoollist.add(new StartQuizModel(0,"Life Sciences & Chemical Techonology"));
        Schoollist.add(new StartQuizModel(0,"Design & Environment"));
        Schoollist.add(new StartQuizModel(0,"Engineering"));
        Schoollist.add(new StartQuizModel(0,"Health Sciences"));



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
                            Schoollist.get(0).score++;
                            Schoollist.get(1).score++;
                        }
                        else if (selectedId == 2131230735) {
                            Log.v(TAG, FILENAME + " 2nd ticked ");
                            Schoollist.get(3).score++;
                            Schoollist.get(5).score++;

                        }
                        else if (selectedId == 2131230736) {
                            Log.v(TAG, FILENAME + " 3rd ticked ");
                            Schoollist.get(7).score++;
                            Schoollist.get(4).score++;

                        }
                        else {
                            Log.v(TAG, FILENAME + " 4th ticked ");
                            Schoollist.get(6).score++;
                            Schoollist.get(2).score++;
                        }
                    }
                    //not checked
                    else {
                        Toast.makeText(StartQuiz.this, "Please select an option in Question 1", Toast.LENGTH_SHORT).show();
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
                        Schoollist.get(2).score++;
                        Schoollist.get(4).score++;
                    }
                    else if (selectedId == 2131230739) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        Schoollist.get(0).score++;
                        Schoollist.get(7).score++;

                    }
                    else if (selectedId == 2131230740) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        Schoollist.get(5).score++;
                        Schoollist.get(3).score++;
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        Schoollist.get(6).score++;
                        Schoollist.get(1).score++;
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
                        Schoollist.get(4).score++;
                        Schoollist.get(7).score++;
                    }
                    else if (selectedId == 2131230743) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        Schoollist.get(0).score++;
                        Schoollist.get(1).score++;
                    }
                    else if (selectedId == 2131230744) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        Schoollist.get(6).score++;
                        Schoollist.get(5).score++;
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        Schoollist.get(2).score++;
                        Schoollist.get(3).score++;
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
                        Schoollist.get(2).score++;
                        Schoollist.get(3).score++;
                    }
                    else if (selectedId == 2131230747) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        Schoollist.get(5).score++;
                        Schoollist.get(7).score++;
                    }
                    else if (selectedId == 2131230748) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        Schoollist.get(4).score++;
                        Schoollist.get(6).score++;
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        Schoollist.get(1).score++;
                        Schoollist.get(0).score++;
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
                        Schoollist.get(2).score++;
                        Schoollist.get(6).score++;
                    }
                    else if (selectedId == 2131230751) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        Schoollist.get(0).score++;
                        Schoollist.get(1).score++;
                    }
                    else if (selectedId == 2131230752) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        Schoollist.get(3).score++;
                        Schoollist.get(5).score++;
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        Schoollist.get(7).score++;
                        Schoollist.get(4).score++;
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
                        Schoollist.get(0).score++;
                        Schoollist.get(1).score++;
                    }
                    else if (selectedId == 2131230755) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        Schoollist.get(2).score++;
                        Schoollist.get(6).score++;
                    }
                    else if (selectedId == 2131230756) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        Schoollist.get(4).score++;
                        Schoollist.get(7).score++;
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        Schoollist.get(5).score++;
                        Schoollist.get(4).score++;
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
                        Schoollist.get(5).score++;
                        Schoollist.get(4).score++;
                    }
                    else if (selectedId == 2131230759) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        Schoollist.get(6).score++;
                        Schoollist.get(7).score++;
                    }
                    else if (selectedId == 2131230760) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        Schoollist.get(0).score++;
                        Schoollist.get(2).score++;
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        Schoollist.get(3).score++;
                        Schoollist.get(1).score++;
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
                        Schoollist.get(2).score++;
                        Schoollist.get(6).score++;
                    }
                    else if (selectedId == 2131230763) {
                        Log.v(TAG, FILENAME + " 2nd ticked ");
                        Schoollist.get(4).score++;
                        Schoollist.get(7).score++;
                    }
                    else if (selectedId == 2131230764) {
                        Log.v(TAG, FILENAME + " 3rd ticked ");
                        Schoollist.get(3).score++;
                        Schoollist.get(5).score++;
                    }
                    else {
                        Log.v(TAG, FILENAME + " 4th ticked ");
                        Schoollist.get(0).score++;
                        Schoollist.get(1).score++;
                    }
                }
                //not checked
                else {
                    bool = false;
                    Toast.makeText(StartQuiz.this, "Please select an option in question 8", Toast.LENGTH_SHORT).show();
                }


               if (bool) {
                   //move
                   Log.v(TAG, FILENAME + " Sorted" );



//                   for (int i = 0; i<Schoollist.size() - 1;i++)
//                   {
//                       for (int j = 0; j<Schoollist.size()-i-1;i++){
//                           if (Schoollist.get(j).score > Schoollist.get(j+1).score)
//                           {
//                               StartQuizModel temp = Schoollist.get(j);
//                               Schoollist.set(j,Schoollist.get(j+1));
//                               Schoollist.set(j+1,temp);
//                           }
//                       }
//                   }
                   Collections.sort(Schoollist);

                   //Check log
                   for (int i = 0; i<Schoollist.size();i++){
                       Log.v(TAG,Schoollist.get(i).schoolname + String.valueOf(Schoollist.get(i).score));
                   }

                   Intent results = new Intent(StartQuiz.this, ResultActivity.class);
                   results.putExtra("top", Schoollist.get(0).getSchoolname());
                   results.putExtra("second", Schoollist.get(1).getSchoolname());
                   results.putExtra("third", Schoollist.get(2).getSchoolname());
                  // results.putExtra("third", SchoolID[])
                   startActivity(results);


               }
            }


        });


    }

}