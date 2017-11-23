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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView register_txt ,go_Log_in;
    private EditText editEmail, editPassword;
    private Button btnSignIn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            firebaseAuth= FirebaseAuth.getInstance();
            if (firebaseAuth.getCurrentUser() != null){
                finish();
                startActivity(new Intent(getApplicationContext(),Profile_activity.class));
            }

        progressDialog = new ProgressDialog(this);
        register_txt = findViewById(R.id.Register_txt);
        go_Log_in = findViewById(R.id.go_log_in);
        editEmail =  findViewById(R.id.email);
        editPassword =  findViewById(R.id.password);
        btnSignIn =  findViewById(R.id.reg_btn);

        btnSignIn.setOnClickListener(this);
        go_Log_in.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view == btnSignIn){
            register_user();
        }
        if(view == go_Log_in){
            finish();
            //  Toast.makeText(this,"go to logIn ",Toast.LENGTH_SHORT).show();
            Intent newIntent = new Intent(MainActivity.this,nav_activity.class);
            startActivity(newIntent);
        }
    }


    private void register_user() {
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Enter Your Email....",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){

            Toast.makeText(this,"Enter Your Password....",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Registering User......");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            Toast.makeText(MainActivity.this,"Registered successfully...",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(),Profile_activity.class));

                        }else {
                            Toast.makeText(MainActivity.this,"Could not registered....",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();


                    }
                });

    }
}
