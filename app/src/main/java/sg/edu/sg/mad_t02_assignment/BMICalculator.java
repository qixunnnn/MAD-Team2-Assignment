package sg.edu.sg.mad_t02_assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculator extends AppCompatActivity {
    private EditText weight,height;
    private TextView result;
    private Button calculate;
    float w,h,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmicalculator);

        weight =(EditText)findViewById(R.id.editTextWeight);
        height = (EditText)findViewById(R.id.editTextHeight);
        result= (TextView)findViewById(R.id.textviewResult);
        calculate = (Button)findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmiCalculate();
            }
        });
    }
    public void bmiCalculate(){
        h = Float.parseFloat(height.getText().toString()) / 100;
        w = Float.parseFloat(weight.getText().toString());

        bmi = w / (h * h);
        result.setText("" + bmi);

        if(bmi < 18.5)
        {
            Toast.makeText(getApplicationContext(), "You are underweight!", Toast.LENGTH_SHORT).show();
        }
        else if((bmi >=18.5) && (bmi <25)){
            Toast.makeText(getApplicationContext(),"You are in healthy weight range", Toast.LENGTH_SHORT).show();
        }
        else if((bmi >=25) && (bmi <30)){
            Toast.makeText(getApplicationContext(), "You are overweight!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"You are obese!", Toast.LENGTH_SHORT).show();
        }
    }


}
