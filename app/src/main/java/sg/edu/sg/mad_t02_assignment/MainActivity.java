package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView bmiclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bmiclick = (CardView)findViewById(R.id.cardviewBMI);
        bmiclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bminextpage();
            }
        });
    }
    private void bminextpage(){
        Intent intent = new Intent(MainActivity.this, BMICalculator.class);
        startActivity(intent);
    }
}
