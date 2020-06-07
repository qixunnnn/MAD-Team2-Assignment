package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {
    int results;
    private String TAG = "Learning@NP";
    private String FILENAME = "SignUpActivity.java";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setTitle("Result");

        results = getIntent().getIntExtra("result",0);
        Log.v(TAG, FILENAME + " Sorted " + results);




    }
}