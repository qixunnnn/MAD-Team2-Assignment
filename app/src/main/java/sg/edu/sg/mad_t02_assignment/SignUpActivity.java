package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "SignUpActivity.java";
    private EditText et;
    private TextView newUser;
    private Button loginButton;
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);

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
        final EditText etUsername = findViewById(R.id.editText_UsernameNew);
        final EditText etPassword = findViewById(R.id.editText_PasswordNew);
        final EditText etCfmPassword = findViewById(R.id.editText_PasswordNew2);
        Button createButton = findViewById(R.id.buttonCreate);

        setTitle("Create Account");

        for(int id = 0; id < btn_IDS.length; id++){

            ImageButton btn = findViewById(btn_IDS[id]);
            btn.setOnTouchListener(touch);

        }
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

    }
    //so that user wont be allowed to go back into the main menu when logged out
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}

