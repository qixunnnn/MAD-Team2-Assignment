package sg.edu.sg.mad_t02_assignment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassActivity extends AppCompatActivity {
    EditText CurrentPass;
    EditText NewPass;
    EditText ConfirmPass;
    Button CancelBtn;
    Button OkBtn;
    EditText et;
    TextView tv;
    TextView em;
    private String TAG = "Learning@NP";
    private String FILENAME = "SettingActivity.java";


    //MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
    FirebaseAuth auth = FirebaseAuth.getInstance();

    private static final int[] TV_IDS = {
            //stores the id of textview here to reduce repeated codes
            R.id.tvCurrentPass,
            R.id.tvNewPass,
            R.id.tvConfirmPass,
    };
    private static final int[] et_IDS = {
            //stores the id of textview here to reduce repeated codes
            R.id.etCurrentPass,
            R.id.editnewPass,
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


        final EditText CurrentPass = findViewById(R.id.etCurrentPass);
        final EditText NewPass = findViewById(R.id.editnewPass);
        final EditText ConfirmPass = findViewById(R.id.etConfirmPass);

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
        /*OkBtn.setOnTouchListener(new View.OnTouchListener() {
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
*/
        OkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_currentpass = CurrentPass.getText().toString();
                String txt_password = NewPass.getText().toString();
                String txt_password2 = ConfirmPass.getText().toString();

                if (TextUtils.isEmpty(txt_currentpass) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_password2))
                {
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (txt_password.equals(txt_password2)) {
                        ChangePass(txt_password);
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and confirmed password does not match. Please try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
    public void ChangePass(final String nPass){
        FirebaseUser user = auth.getCurrentUser();

            if (user != null ) {
                user.updatePassword(nPass)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ChangePassActivity.this, "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();


                                } else {
                                    Toast.makeText(ChangePassActivity.this, "Failed to update password!", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        }
    }




