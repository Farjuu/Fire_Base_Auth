package com.example.farjana.fire_base_auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SetTimingAct extends AppCompatActivity implements View.OnClickListener {

    TextView txt1, txt2;
    Button btn_done;
    private Spinner spinDay, spinMonth, spinYear, spinTime;
    private int flag = 0;
    String date = "";
    private static String Time = "", day = "", month = "", year = "";

    //DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timing);
        // someThing();
        initialize();

        btn_done.setOnClickListener(this);



      spinTime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
                date ="";
                String selected_val = "";
                selected_val = spinTime.getSelectedItem().toString();

                Toast.makeText(getApplicationContext(), selected_val,
                        Toast.LENGTH_SHORT).show();
                Time = selected_val;

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

     // date += day + "/" + month +"/" + year;




    }

    private void initialize() {
        txt2 = findViewById(R.id.txt1);
        btn_done = findViewById(R.id.btn_done);

        spinTime = findViewById(R.id.spinnerTime);
    }


    @Override
    public void onClick(View view) {
        if(view == btn_done){
            Intent intent = new Intent(this,attendence.class);

            intent.putExtra("Time",Time);
            startActivity(intent);
        }

    }
}
