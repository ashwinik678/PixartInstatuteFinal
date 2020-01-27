package com.example.pixartinstatutefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void backToLoginPage(View view) {
        startActivity(new Intent(this, SignInActivity.class));
    }

    public void getLinkMethod(View view) {
        Toast.makeText(getApplicationContext(),"This function will be available soon, Ask Admin for your Password for Now",Toast.LENGTH_LONG).show();
    }
}
