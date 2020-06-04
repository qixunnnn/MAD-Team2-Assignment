package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "SignUpActivity.java";

    private TextView newUser;
    private Button loginButton;
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText etUsername = findViewById(R.id.editText_UsernameNew);
        final EditText etPassword = findViewById(R.id.editText_PasswordNew);
        final EditText etCfmPassword = findViewById(R.id.editText_PasswordNew2);
        Button createButton = findViewById(R.id.buttonCreate);
        Button cancelButton = findViewById(R.id.buttonCancel);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPassword.getText().toString().equals(etCfmPassword.getText().toString())) {
                    UserData userData = dbHandler.findUser(etUsername.getText().toString());
                    if (userData == null) {
                        String dbUsername = etUsername.getText().toString();
                        String dbPassword = etPassword.getText().toString();
                        UserData dbUserData = new UserData();
                        dbUserData.setUsername(dbUsername);
                        dbUserData.setPassword(dbPassword);
                        dbHandler.addUser(dbUserData);
                        Toast.makeText(SignUpActivity.this, "New User Created!", Toast.LENGTH_SHORT).show();
                        Log.v(TAG, FILENAME + "Creation with: " + etUsername.getText().toString() + "| " + etPassword.getText().toString());
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUpActivity.this, "User already exist. \nPLease try again.", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignUpActivity.this, "Password does not match \nPLease try again.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}

