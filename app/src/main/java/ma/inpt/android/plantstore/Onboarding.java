package ma.inpt.android.plantstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class Onboarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        View log_in_button = (View) findViewById(R.id.log_in_button);
        View sign_up_button = (View) findViewById(R.id.sign_up_button);

        log_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Onboarding.this, Login.class));
                //startActivity(new Intent(Onboarding.this, Home.class));
                startActivity(new Intent(Onboarding.this, Product.class));
            }
        });

        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signup = new Intent(Onboarding.this, Signup.class);
                startActivity(signup);
            }
        });
    }
}