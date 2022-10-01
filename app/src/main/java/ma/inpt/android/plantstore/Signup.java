package ma.inpt.android.plantstore;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText emailInput;
    EditText passwordInput;
    EditText passwordValidation;
    View sign_up_button;
    TextView log_in_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sign_up_button = (View) findViewById(R.id.sign_up_button);
        log_in_text = (TextView) findViewById(R.id.log_in_text);
        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);
        passwordValidation = findViewById(R.id.password_validation);

        mAuth = FirebaseAuth.getInstance();

        sign_up_button.setOnClickListener( view -> {
                    createUser();
                }
        );

        log_in_text.setOnClickListener( view -> {
            startActivity(new Intent(Signup.this, Login.class));
            }
        );
    }

    private void createUser() {
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        String password_validation = passwordValidation.getText().toString();

        if (TextUtils.isEmpty(email)){
            emailInput.setError("Email cannot be empty");
            emailInput.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            passwordInput.setError("Password cannot be empty");
            passwordInput.requestFocus();
        }else if (!password_validation.equals(password)){
            passwordValidation.setError("Password and validation don't match ");
            passwordValidation.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Signup.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Signup.this, Login.class));
                    }else{
                        Toast.makeText(Signup.this, "Registration Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}