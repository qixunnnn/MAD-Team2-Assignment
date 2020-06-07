package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    ArrayList<String> resultslist = new ArrayList<String>();

    private String TAG = "Learning@NP";
    private String FILENAME = "SignUpActivity.java";
    TextView topschool;
    TextView secondschool;
    TextView thirdschool;
    Button retry;
    Button mainmenu;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        resultslist.add(getIntent().getStringExtra("top"));
        resultslist.add(getIntent().getStringExtra("second"));
        resultslist.add(getIntent().getStringExtra("third"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setTitle("Result");

        topschool = findViewById(R.id.school1);
        secondschool = findViewById(R.id.school2);
        thirdschool = findViewById(R.id.school3);
        mainmenu = findViewById(R.id.MainmenuBtn);
        retry = findViewById(R.id.retryBtn);

        topschool.setText(resultslist.get(0));
        secondschool.setText(resultslist.get(1));
        thirdschool.setText(resultslist.get(2));

       retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ResultActivity.this, StartQuiz.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            }


        });
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            }


        });



    }
}