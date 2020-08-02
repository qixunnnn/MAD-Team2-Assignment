package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminMain extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "Admin Page";
    private static final int[] CARDVIEW_ID = {
            R.id.cardviewSchoolModi, R.id.cardviewBookModi, R.id.cardviewSettings, R.id.cardviewChatAdmin
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        setTitle("Admin Home");

        for (final int id: CARDVIEW_ID)
        {
            findViewById(id).setOnClickListener(this);
        }
        Log.v(TAG, "Finished Pre-Initialization");


    }

    @Override
    public void onClick(View v) {
        FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
        String cUid = fUser.getUid();

        Intent i = null;

        Log.v(TAG,v.getId() + " Is clicked");

        if (v.getId() == CARDVIEW_ID[0])
        {
            i = new Intent(this,AdminModSchool.class);
        }
        else if (v.getId() == CARDVIEW_ID[1])
        {
            i = new Intent(this, AdminAddBookActivity.class);
        }
        else if (v.getId() == CARDVIEW_ID[2])
        {
            i = new Intent(this,SettingActivity.class);
        }
        else if (v.getId() == CARDVIEW_ID[3])
        {
            i = new Intent(this, UserChat.class);

        }
        startActivity(i);

    }
}