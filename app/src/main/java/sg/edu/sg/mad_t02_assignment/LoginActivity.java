package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private String TAG = "Learning@NP";
    private String FILENAME = "LoginActivity.java";

    private TextView newUser;
    private Button loginButton;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private CheckBox remebermeCheckBox;
    private CheckBox stayloggedinCheckBox;
    private Boolean saveLogin;
    private Boolean Stayloggedin;
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);

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

        setContentView(R.layout.activity_login);
        //remove title in login page
        setTitle("");
        final EditText etUsername = findViewById(R.id.editText_username);
        final EditText etPassword = findViewById(R.id.editText_password);

        remebermeCheckBox = (CheckBox)findViewById(R.id.checkBox_RememberMe);
        stayloggedinCheckBox = (CheckBox)findViewById(R.id.checkBox_RememberMe);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        newUser = findViewById(R.id.textView_NewUser);

        //get boonlean to see if check box have been previously checked
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        Stayloggedin = loginPreferences.getBoolean("stayloggedin", false);
        // if checkedbox have been checked previously it will execute what ever it is suppose to do
        if (saveLogin == true) {
            etUsername.setText(loginPreferences.getString("username", ""));
            etPassword.setText(loginPreferences.getString("password", ""));
            remebermeCheckBox.setChecked(true);
        }
        if(Stayloggedin == true){
            Log.v(TAG, FILENAME + ": Auto logged in " + etUsername.getText().toString());
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            stayloggedinCheckBox.setChecked(true);
        }

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginPrefsEditor.putBoolean("stayloggedin", false);
                loginPrefsEditor.commit();
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);

            }


        });
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Log.v(TAG, FILENAME + ": Login with info: " + etUsername.getText().toString());
                Log.v(TAG, FILENAME + ": Login with info: " + etPassword.getText().toString());

                if(isValidCredential(etUsername.getText().toString(), etPassword.getText().toString())){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    if (remebermeCheckBox.isChecked()) {
                        loginPrefsEditor.putBoolean("saveLogin", true);
                        loginPrefsEditor.putString("username", etUsername.getText().toString());
                        loginPrefsEditor.putString("password", etPassword.getText().toString());
                        loginPrefsEditor.commit();
                    } else {
                        loginPrefsEditor.putBoolean("saveLogin", false);
                        loginPrefsEditor.commit();
                    }
                    if (stayloggedinCheckBox.isChecked()) {
                        loginPrefsEditor.putBoolean("stayloggedin", true);
                        loginPrefsEditor.commit();
                    } else {
                        loginPrefsEditor.putBoolean("stayloggedin", false);
                        loginPrefsEditor.commit();
                    }

                    Toast.makeText(LoginActivity.this,"Logged in successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid Username / Password", Toast.LENGTH_SHORT).show();
                }


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


    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }



    protected void onStop(){
        super.onStop();
        finish();
    }
}