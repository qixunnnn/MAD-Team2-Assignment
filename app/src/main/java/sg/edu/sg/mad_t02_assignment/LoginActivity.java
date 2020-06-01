package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "LoginActivity.java";

    private TextView newUser;
    private Button loginButton;
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText etUsername = findViewById(R.id.editText_username);
        final EditText etPassword = findViewById(R.id.editText_password);
        newUser = findViewById(R.id.textView_NewUser);
        newUser.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return false;
            }


        });
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                Log.v(TAG, FILENAME + ": Login with info: " + etUsername.getText().toString());
                Log.v(TAG, FILENAME + ": Login with info: " + etPassword.getText().toString());

                if(isValidCredential(etUsername.getText().toString(), etPassword.getText().toString())){
                    Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this,"Valid", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid Username / Password", Toast.LENGTH_SHORT).show();
                }
                return false;

            }
        });
        //set hint so that when the et is empty it will show what the user need to type
        etUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    etUsername.setHint("");
                } else {
                    etUsername.setHint("Username");
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


    }
    public boolean isValidCredential(String username, String password){
        UserData dbData = dbHandler.findUser(username);
        if(dbData != null)
        {

            Log.v(TAG, FILENAME + ": Running checks..." + dbData.getUsername() + "| " + dbData.getPassword());

            if(dbData.getUsername().equals(username) && dbData.getPassword().equals(password)){
                return true;
            }
            return false;



        }
        else {
            return false;
        }
    }


    protected void onStop(){
        super.onStop();
        finish();
    }
}