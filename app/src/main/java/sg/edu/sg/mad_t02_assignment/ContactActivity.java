package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    Button generalBtn;
    Button acadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        setTitle("Contact");
        generalBtn = (Button) findViewById(R.id.contact_general_btn);
        acadBtn = (Button) findViewById(R.id.contact_academic_btn);

        generalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),GeneralContact.class);
                startActivity(i);
            }
        });

        acadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AcademicContact.class);
                startActivity(i);
            }
        });
    }
}
