package com.example.waterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.annotation.NonNullApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.NotNull;


public class SignUpActivity extends AppCompatActivity {

    EditText editTextUserName;
    EditText editTextPassword;
    EditText editTextPhoneNo;
    EditText editTextEmail;
    ProgressBar progressbar;



    private FirebaseAuth mAuth;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextPhoneNo = (EditText) findViewById(R.id.editTextMobileNo);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        progressbar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();




    }

    public void signUpButtonClicked(View v) {
        String txtUserName = editTextUserName.getText().toString().trim();
        String txtPassword = editTextPassword.getText().toString().trim();
        String txtPhoneNo = editTextPhoneNo.getText().toString().trim();
        String txtEmail = editTextEmail.getText().toString().trim();

        if (txtUserName.isEmpty()){
            editTextUserName.setError("Please Enter User Name");
            editTextUserName.requestFocus();
        }

        if (txtPassword.isEmpty() || txtPassword.length() < 6 ){
            editTextPassword.setError("Please Enter Password Containing atleast six characters");
            editTextPassword.requestFocus();
        }

        if (txtPhoneNo.isEmpty()){
            editTextPhoneNo.setError("Please Enter Mobile No");
            editTextPhoneNo.requestFocus();
        }

        if (txtEmail.isEmpty()){
            editTextEmail.setError("Please Enter Valid Email ");
            editTextEmail.requestFocus();
        }

        progressbar.setVisibility(View.VISIBLE);



    }
}