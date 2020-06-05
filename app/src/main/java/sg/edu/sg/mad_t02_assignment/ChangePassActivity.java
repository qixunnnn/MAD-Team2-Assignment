package sg.edu.sg.mad_t02_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class ChangePassActivity extends AppCompatActivity {
    EditText CurrentPass;
    EditText NewPass;
    EditText ConfirmPass;
    Button CancelBtn;
    Button OkBtn;
    EditText et;
    TextView tv;
    private String TAG = "Learning@NP";
    private String FILENAME = "SettingActivity.java";
    private SharedPreferences changePassPreferences;
    private SharedPreferences.Editor changePassPrefsEditor;
    String password;
    String username;
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);


    private static final int[] TV_IDS = {
            //stores the id of textview here to reduce repeated codes
            R.id.tvCurrentPass,
            R.id.tvNewPass,
            R.id.tvConfirmPass,
    };
    private static final int[] et_IDS = {
            //stores the id of textview here to reduce repeated codes
            R.id.etCurrentPass,
            R.id.etNewPass,
            R.id.etConfirmPass,
    };
    private static final int[] btn_IDS = {
            //stores the id of textview here to reduce repeated codes
            R.id.CurrentPassBtn,
            R.id.NewPassBtn,
            R.id.ConfirmPassBtn,
    };
    private static final int[] em_IDS = {
            //stores the id of textview here to reduce repeated codes
            R.id.EMCurrentPass,
            R.id.EMNewPass,
            R.id.EMConfirmPass,
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
    //Change the color on the text field when focuses on a edit text
    private View.OnFocusChangeListener focus = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            for (int id = 0; id < et_IDS.length; id++) {
                if (v.getId() == et_IDS[id]) {
                    tv = findViewById(TV_IDS[id]);

                }
            }
            if (!hasFocus) {
                tv.setTextColor(Color.parseColor("#606060"));
                Log.v(TAG, "no focus");
            }else{
                //tv.setTextColor(Color.parseColor("09175b"));
                tv.setTextColor(Color.parseColor("#03DAC5"));
                Log.v(TAG, "Got focus");
            }

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        setTitle("Change Password");
        changePassPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        changePassPrefsEditor = changePassPreferences.edit();
        password = changePassPreferences.getString("password", "");
        username = changePassPreferences.getString("username", "");
        CurrentPass = findViewById(et_IDS[0]);
        NewPass = findViewById(et_IDS[1]);
        ConfirmPass = findViewById(et_IDS[2]);

        OkBtn = findViewById(R.id.OkBtn);
        CancelBtn = findViewById(R.id.CancelBtn);
        CancelBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               //intent back to settings activity
                Intent intent = new Intent(ChangePassActivity.this, SettingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                return false;
            }
        });
        OkBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(submit(CurrentPass,NewPass,ConfirmPass))
                {
                    //update data base
                    //intent back to settings activity
                    if(dbHandler.deleteAccount(username))
                    {
                        //delete account successful
                        UserData dbUserData = new UserData();
                        dbUserData.setUsername(username);
                        dbUserData.setPassword(NewPass.getText().toString());
                        dbHandler.addUser(dbUserData);

                        //update share preference
                        changePassPrefsEditor.putString("password", NewPass.getText().toString());
                        changePassPrefsEditor.commit();
                        Log.v(TAG, "password successfully updated");

                    }
                    else
                    {
                        //display error message
                        Log.v(TAG, "delete account fail/ fail to update");
                    }

                    Intent intent = new Intent(ChangePassActivity.this, SettingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);


                }
                else
                {

                }
                return false;
            }
        });

        for(int id = 0; id < em_IDS.length; id++){
            tv = findViewById(em_IDS[id]);
            tv.setVisibility(View.INVISIBLE);
        }


        for(int id = 0; id < btn_IDS.length; id++){

            ImageButton butt = findViewById(btn_IDS[id]);
            butt.setOnTouchListener(touch);
            EditText text = findViewById(et_IDS[id]);
            text.setOnFocusChangeListener(focus);
        }

    }
    private boolean submit(EditText pass, EditText newpass, EditText confirmpass) {
        if (!validatePass(pass)) {
            //a method to make error message visible
            setEMVisible(0);
            return false;
        }

        if (!validateNewPass(newpass)) {
            setEMVisible(1);
            return false;
        }

        if (!validateConfirmPass(confirmpass,newpass)) {
            setEMVisible(2);
            return false;
        }

        return true;


    }

    private boolean validatePass(EditText pass) {
        if (pass.getText().toString().equals(password)){

            return true;
        }
        Log.v(TAG, "password: " + password + "pass text" + pass.getText().toString());
        return false;
    }


    private boolean validateNewPass(EditText newpass){
        if(newpass.getText().toString().length() >= 6)
        {
            setEMInvisible(1);
            return true;

        }
        else
        {
            return false;
        }
    }
    private boolean validateConfirmPass(EditText confirmpass, EditText newpass){
        if(confirmpass.getText().toString().equals(newpass.getText().toString()))
        {
            setEMInvisible(2);
            return true;
        }
        else
        {
            return false;
        }
    }
    private void setEMVisible(int id)
    {
        tv = findViewById(em_IDS[id]);
        tv.setVisibility(View.VISIBLE);

    }
    private void setEMInvisible(int id)
    {
        tv = findViewById(em_IDS[id]);
        tv.setVisibility(View.INVISIBLE);

    }



}
