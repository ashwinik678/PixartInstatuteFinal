package com.example.pixartinstatutefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.pixartinstatutefinal.Model.ModelSignUp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private RelativeLayout rlayout;
    private Animation animation;

    private EditText name, email, mobile, password;
    private Button buttonSignup;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private ProgressBar progressBar;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        rlayout.setAnimation(animation);

        spinner = findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("user").child("student");

        name = findViewById(R.id.signup_etName);
        email = findViewById(R.id.signin_etEmail);
        mobile = findViewById(R.id.signin_etPassword);
        password = findViewById(R.id.signup_etPassword);

        progressBar = findViewById(R.id.signup_progressbar);

        buttonSignup = findViewById(R.id.signup_buttonSignUp);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                final String NAME = name.getText().toString().trim();
                final String EMAIL = email.getText().toString().trim();
                final String MOBILE = mobile.getText().toString().trim();
                final String PASSWORD = password.getText().toString().trim();
//                final String phoneNumber = "+" + code + MOBILE;
                final String phoneNumber = "+" + 91 + MOBILE;

                if (NAME.isEmpty()) {
                    name.setError("Name required");
                    name.requestFocus();
                    return;
                }

                if (EMAIL.isEmpty()) {
                    email.setError("Email required");
                    email.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(EMAIL).matches()) {
                    email.setError("Please enter valid email address");
                    email.requestFocus();
                    return;
                }

                if (MOBILE.isEmpty()) {
                    mobile.setError("Mobile required");
                    mobile.requestFocus();
                    return;
                }

                if (PASSWORD.isEmpty()) {
                    password.setError("Password required");
                    password.requestFocus();
                    return;
                }

                if (PASSWORD.length() < 6) {
                    password.setError("Minimum length of password is 6");
                    password.requestFocus();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                buttonSignup.setVisibility(View.GONE);

                firebaseAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        String ID = databaseReference.push().getKey();

                        ModelSignUp modelSignUp = new ModelSignUp(ID, NAME, EMAIL, MOBILE, PASSWORD);

                        databaseReference.child(ID).setValue(modelSignUp).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Sign up successful", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                                    Intent intent = new Intent(SignUpActivity.this, VerifyPhoneActivity.class);
                                    intent.putExtra("phonenumber", phoneNumber);
                                    startActivity(intent);
                                    name.setText("");
                                    email.setText("");
                                    mobile.setText("");
                                    password.setText("");
                                    progressBar.setVisibility(View.GONE);
                                    buttonSignup.setVisibility(View.VISIBLE);
                                }

                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                                        progressBar.setVisibility(View.GONE);
                                        buttonSignup.setVisibility(View.VISIBLE);
                                    }
                                });
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                progressBar.setVisibility(View.GONE);
                                buttonSignup.setVisibility(View.VISIBLE);
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getUid() != null) {
            Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    public void openSignInActivityfromThis(View view) {
        startActivity(new Intent(this, SignInActivity.class));
    }
}
