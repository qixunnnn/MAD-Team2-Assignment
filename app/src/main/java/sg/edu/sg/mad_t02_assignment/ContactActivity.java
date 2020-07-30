package sg.edu.sg.mad_t02_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ContactActivity extends AppCompatActivity implements View.OnClickListener{

    final String TAG = "Contact Activity";

    private static final int[] BUTTON_ID = {
            R.id.contact_general_btn, R.id.contact_academic_btn, R.id.contact_feedback_btn
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        setTitle("Contact");

        for (final int id: BUTTON_ID)
        {
            //SET ALL BUTTON BUTTON ID TO ONCLICKLISTENER
            findViewById(id).setOnClickListener(this);
        }
        Log.v(TAG, "Finished Pre-Initialization");

    }

    @Override
    public void onClick(View v) {
        Intent i = null;

        //Redirect to their specific activity
        if (v.getId() == BUTTON_ID[0])
        {
            i = new Intent(this,GeneralContact.class);
        }
        else if (v.getId() == BUTTON_ID[1])
        {
            i = new Intent(this,AcademicContact.class);
        }
        else if (v.getId() == BUTTON_ID[2])
        {
           // i = new Intent(this,UserChat.class);
        }
        startActivity(i);
    }
}
