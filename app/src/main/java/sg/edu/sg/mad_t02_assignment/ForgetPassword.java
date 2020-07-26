package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    final static String TAG = "ForgetPassowrd";
    private FirebaseAuth mAuth;
    private EditText et_Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        setTitle("Forget Password");

        mAuth = FirebaseAuth.getInstance();

        Button btn_forget = findViewById(R.id.forgetBtn);
        et_Email = findViewById(R.id.et_forgetEmail);
        TextView btn_backtoLogin = findViewById(R.id.forgetToLogin);

        btn_backtoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgetPassword.this, LoginActivity.class));
            }
        });

        btn_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = et_Email.getText().toString();

                if (TextUtils.isEmpty(userEmail))
                {
                    Toast.makeText(ForgetPassword.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(ForgetPassword.this, "Reset email has been send to your email", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(ForgetPassword.this,LoginActivity.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(ForgetPassword.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}