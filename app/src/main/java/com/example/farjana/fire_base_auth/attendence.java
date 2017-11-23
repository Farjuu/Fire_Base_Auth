package com.example.farjana.fire_base_auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class attendence extends AppCompatActivity {

    private TextView txt , txt1;
    private String time="",Date="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_attendence);
        initializeAll();

        setTimeDate();

    }

    private void initializeAll() {
        txt = findViewById(R.id.textView2);
        txt1 = findViewById(R.id.textView3);
    }

    private void setTimeDate() {
        time = getIntent().getStringExtra("Time");

        txt1.setText(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        String cur_date = dateFormat.format(now);
        txt.setText(cur_date);
    }
}
