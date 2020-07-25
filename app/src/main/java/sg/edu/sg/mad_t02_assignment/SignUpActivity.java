package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "SignUpActivity.java";
    private EditText et;
    private TextView backtoMain;
    private CircleImageView profile_pic;
    private Uri imageUri;
    private StorageTask uploadTask;


    FirebaseAuth auth = FirebaseAuth.getInstance();
    DatabaseReference dbRef;
    StorageReference storageReference;

    private static final int[] btn_IDS = {
            //stores the id of textview here to reduce repeated codes

            R.id.passwordBtn,
            R.id.confirmpassBtn,
    };
    private static final int[] et_IDS = {
            //stores the id of textview here to reduce repeated codes

            R.id.editText_PasswordNew,
            R.id.editText_PasswordNew2,
    };
    private View.OnTouchListener touch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            for (int id = 0; id < btn_IDS.length; id++) {
                if (v.getId() == btn_IDS[id]) {
                    et = findViewById(et_IDS[id]);

                }
            }
            if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                et.setTransformationMethod(null);
            } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {

                et.setTransformationMethod(new PasswordTransformationMethod());
            }

            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText etEmail = findViewById(R.id.editText_UsernameNew);
        final EditText etPassword = findViewById(R.id.editText_PasswordNew);
        final EditText etCfmPassword = findViewById(R.id.editText_PasswordNew2);
        profile_pic = findViewById(R.id.profile_image);
        Button createButton = findViewById(R.id.buttonCreate);

        setTitle("Create Account");

        for(int id = 0; id < btn_IDS.length; id++){

            ImageButton btn = findViewById(btn_IDS[id]);
            btn.setOnTouchListener(touch);

        }
        profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openImage();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = etEmail.getText().toString();
                String txt_password = etPassword.getText().toString();
                String txt_password2 = etCfmPassword.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_password2))
                {
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt_password.equals(txt_password2)) {
                        Register(txt_email,txt_password);
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and confirmed password does not match. Please try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        backtoMain = findViewById(R.id.backtomain);
        backtoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });


    }

    public void Register(final String email, String password)
    {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Log.v(TAG,"User: " + email + " created successfully");
                    FirebaseUser user = auth.getCurrentUser();
                    assert user != null;
                    String uid = user.getUid();

                    dbRef = FirebaseDatabase.getInstance().getReference("Users").child(uid);

                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id", uid);
                    hashMap.put("role", "newUser");
                    hashMap.put("profile_pic","default");
                    hashMap.put("username","nil");

                    dbRef.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.v(TAG,"User ID and role added into database");
                                //Intent user to other page
                                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(i);
                                Toast.makeText(SignUpActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(),"Register failed. Email already existed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //so that user wont be allowed to go back into the main menu when logged out
}

