package com.example.asish.cloudchurch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;


public class loginIntent extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intent);
    }

    public void loginto(final View view) {
        EditText email_edit = findViewById(R.id.emailId);
        EditText password_edit = findViewById(R.id.password);
        Button loginto = findViewById(R.id.loginButton);
        final Intent intent = new Intent(this,mainpage.class);

        final String email = email_edit.getText().toString();
        final String password = password_edit.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(intent);
                            Toast.makeText(loginIntent.this, "Authentication Successful",
                                    Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(loginIntent.this, "Authentication failed." ,
                            Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        }




}
