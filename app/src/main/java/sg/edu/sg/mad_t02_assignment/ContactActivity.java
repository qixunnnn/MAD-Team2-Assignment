package sg.edu.sg.mad_t02_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseReference ref;
    FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
    String cUid = fUser.getUid();

    final String TAG = "Contact Activity";

    private static final int[] BUTTON_ID = {
            R.id.contact_general_btn, R.id.contact_academic_btn, R.id.contact_feedback_btn
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        setTitle("Contact");

        for (final int id : BUTTON_ID) {
            //SET ALL BUTTON BUTTON ID TO ONCLICKLISTENER
            findViewById(id).setOnClickListener(this);
        }
        Log.v(TAG, "Finished Pre-Initialization");

    }

    @Override
    public void onClick(View v) {
        Intent i = null;

        //Redirect to their specific activity
        if (v.getId() == BUTTON_ID[0]) {
            i = new Intent(this, GeneralContact.class);
        } else if (v.getId() == BUTTON_ID[1]) {
            i = new Intent(this, AcademicContact.class);
        } else if (v.getId() == BUTTON_ID[2]) {
            getUsername();
            return;
        }
        startActivity(i);
    }

    private void getUsername() {

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(cUid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserData userData =  snapshot.getValue(UserData.class);
                if (userData.getUsername().equals("default"))
                {
                    startActivity(new Intent(ContactActivity.this, UserInfo.class));
                }
                else
                {
                    startActivity(new Intent(ContactActivity.this, UserChat.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}