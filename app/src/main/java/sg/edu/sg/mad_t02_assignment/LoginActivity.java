package sg.edu.sg.mad_t02_assignment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "LoginActivity.java";

    private TextView newUser;
    private Button loginButton;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private CheckBox remebermeCheckBox;



    FirebaseAuth auth = FirebaseAuth.getInstance();

    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //To check if saveInstance state is not null, if it is null it means there is a save file and it might be a cause the phone has oriantated
        if(savedInstanceState != null)
        {
            Intent refresh = new Intent(this, LoginActivity.class);
            startActivity(refresh);//Start the same Activity
            finish(); //finish Activity.
        }


        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_login);
        //remove title in login page
        setTitle("");
        final EditText etEmail = findViewById(R.id.editText_username);
        final EditText etPassword = findViewById(R.id.editText_password);

        remebermeCheckBox = (CheckBox)findViewById(R.id.checkBox_RememberMe);

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        newUser = findViewById(R.id.textView_NewUser);
        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            }
        });
        //get boonlean to see if check box have been previously checked

        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_email = etEmail.getText().toString();
                String txt_password = etPassword.getText().toString();


                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password))
                {
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                        Login(txt_email,txt_password);
                    }
                }
        });
        //set hint so that when the et is empty it will show what the user need to type
        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    etEmail.setHint("");
                } else {
                    etEmail.setHint("Username");
                }
            }
        });
        etPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    etPassword.setHint("");
                } else {
                    etPassword.setHint("Password");
                }
            }
        });
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            etEmail.setText(loginPreferences.getString("username", ""));
            etPassword.setText(loginPreferences.getString("password", ""));
            remebermeCheckBox.setChecked(true);
        }
    }

    public void Login(final String email, final String password)
    {

        if (remebermeCheckBox.isChecked()) {
            loginPrefsEditor.putBoolean("saveLogin", true);
            loginPrefsEditor.putString("username", email);
            loginPrefsEditor.putString("password", password);
            loginPrefsEditor.commit();
        } else {
            loginPrefsEditor.putBoolean("saveLogin", false);
            loginPrefsEditor.commit();
        }
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    // there was an error
                    FirebaseUser currentUser = auth.getCurrentUser();
                    String uid = currentUser.getUid();
                    dbRef = FirebaseDatabase.getInstance().getReference("Users").child(uid);
                    dbRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String role = snapshot.child("role").getValue().toString();
                            if(role.equals("admin")){
                                Intent intent = new Intent(LoginActivity.this, AdminMain.class);
                                startActivity(intent);
                                finish();
                            }
                            else if(role.equals("newUser")){
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Login failed. Incorrect credentials", Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                }
                else{
                    Toast.makeText(getApplicationContext(), "Login failed. Incorrect credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }


    protected void onStop(){
        super.onStop();
        finish();
    }
}