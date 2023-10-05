package com.example.waterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    EditText editTextUserName, editTextPassword;
    TextView textViewForgotPassword, textViewRegister;

    ProgressBar progressBar2;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editTextUserName = (EditText) findViewById(R.id.editTextSignInUderNAme);
        editTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        textViewForgotPassword = (TextView) findViewById(R.id.tstSignInForgotPassword);
        textViewRegister = (TextView) findViewById(R.id.tstSignInRegister);

        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);

        mAuth = FirebaseAuth.getInstance();
    }

    public void tstSignInForgotPasswordClicked(View v) {
        Intent intent = new Intent(this,ForgotPasswordActivity.class );
        startActivity(intent);
    }
    public void tstSignInRegisterClicked(View v) {

        Intent intent = new Intent(this,SignUpActivity.class );
        startActivity(intent);

    }
    public void buttonSignInScrSignInClicked(View v) {

        String userName = editTextUserName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (Patterns.EMAIL_ADDRESS.matcher (userName) .matches ()) {
            editTextUserName.setError("Please Enter a Valid Email");
            editTextUserName.requestFocus();
        }
            if (editTextPassword.length() < 6) {
                editTextPassword. setError ("Please Enter Password containing atleast 6 characters");
                editTextPassword.requestFocus();

        }

        progressBar2.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressBar2.setVisibility(View.GONE);
                        Toast.makeText(SignInActivity.this, "User Has Successfully Signed In", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(SignInActivity.this, DashboardActivity.class));
                    }
                    else {
                        progressBar2.setVisibility(View.GONE);
                        Toast.makeText(SignInActivity.this, "User is failed Signed In", Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}
