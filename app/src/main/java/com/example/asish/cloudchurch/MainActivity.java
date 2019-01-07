package com.example.asish.cloudchurch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    public FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);

    }


    public void login(View view) {
        Intent intent = new Intent(this,loginIntent.class);
        startActivity(intent);
    }

    public void signup(View view) {
        Intent intent = new Intent(this,signupIntent.class);
        startActivity(intent);


    }
}
