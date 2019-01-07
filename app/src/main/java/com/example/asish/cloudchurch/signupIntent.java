package com.example.asish.cloudchurch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signupIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_intent);
        mAuth = FirebaseAuth.getInstance();
    }
    private FirebaseAuth mAuth;
    public void signupinto(View view) {

        EditText email_edit = findViewById(R.id.emailId_);
        EditText password_edit = findViewById(R.id.password_);

        final Intent intent = new Intent(this,mainpage.class);
        final String email_signup = email_edit.getText().toString();
        final String password_signup = password_edit.getText().toString();

        mAuth.createUserWithEmailAndPassword(email_signup, password_signup)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //  updateUI(user);

                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            //  Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signupIntent.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void googlesignup(View view) {
    }
}
