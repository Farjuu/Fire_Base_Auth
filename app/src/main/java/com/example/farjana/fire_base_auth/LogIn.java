package com.example.farjana.fire_base_auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity implements View.OnClickListener{

    private TextView log_txt,go_sign_in ;
    private EditText logEmail, logPassword;
    private Button btnlogIn;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Toast.makeText(this,"LogIn acticity",Toast.LENGTH_SHORT).show();

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(),Profile_activity.class));
        }
        log_txt = findViewById(R.id.log_txt);
        go_sign_in =  findViewById(R.id.go_sign_in);
        logEmail =  findViewById(R.id.email_log);
        logPassword =  findViewById(R.id.password_log);
        btnlogIn =  findViewById(R.id.log_btn);
        progressDialog = new ProgressDialog(this);

        btnlogIn.setOnClickListener(this);
        go_sign_in.setOnClickListener(this);

    }



    @Override
    public void onClick(View view) {
        if(view == btnlogIn){
            logIn_user();
        }
        if(view == go_sign_in){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    private void logIn_user() {
        String email = logEmail.getText().toString().trim();
        String password = logPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Enter Your Email....",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){

            Toast.makeText(this,"Enter Your Password....",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Loading please wait......");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(),Profile_activity.class));
                        }else {
                            Toast.makeText(LogIn.this,"Error Occured....",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
