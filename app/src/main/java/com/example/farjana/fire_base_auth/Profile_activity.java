package com.example.farjana.fire_base_auth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_activity extends AppCompatActivity implements View.OnClickListener{

    private TextView welcomeTxt;
    private Button path_to_profile_btn;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activity);
        initializeAll();

    }

    private void initializeAll() {
        welcomeTxt = (TextView) findViewById(R.id.welcome_txt);
        path_to_profile_btn = (Button) findViewById(R.id.path_profile);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LogIn.class));
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        welcomeTxt .setText("WELCOME\n"+user.getEmail());
        path_to_profile_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == path_to_profile_btn){
            progressDialog.setMessage("Loading....");
            progressDialog.show();
            Toast.makeText(this,"Your Profile is starting...",Toast.LENGTH_SHORT).show();

            startActivity(new Intent(this,Profile_info_activity.class));
        }
        progressDialog.dismiss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.nav_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"LOG_OUT",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(getApplicationContext(),LogIn.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
