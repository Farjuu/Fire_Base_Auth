package com.example.farjana.fire_base_auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Farjana on 11/3/2017.
 */

public class Fragment2 extends android.support.v4.app.Fragment implements View.OnClickListener{
    Button b1,b2,b3,b4,b5,b6,b7,b8;

    View view2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view2 = inflater.inflate(R.layout.fragment_layout2,container,false);

        initializeAll();

        return view2;
    }

    private void initializeAll() {
        b1 = view2.findViewById(R.id.b1);
        b1.setOnClickListener(this);
        //  b2.setBackgroundResource(R.drawable.btn_army_glossy);

        b2 = view2.findViewById(R.id.b2);
        b2.setOnClickListener(this);
        //b2.setBackgroundResource(R.drawable.btn_army_glossy);
        b3 = view2.findViewById(R.id.b3);
        b3.setOnClickListener(this);
        //b3.setBackgroundResource(R.drawable.btn_army_glossy);
        b4 = view2.findViewById(R.id.b4);
        b4.setOnClickListener(this);
        //b4.setBackgroundResource(R.drawable.btn_green_glossy);
        b5 = view2.findViewById(R.id.b5);
        b5.setOnClickListener(this);
        //b5.setBackgroundResource(R.drawable.btn_green_glossy);
        b6 = view2.findViewById(R.id.b6);
        b6.setOnClickListener(this);
        //b6.setBackgroundResource(R.drawable.btn_army_glossy);
        b7 = view2.findViewById(R.id.b7);
        b7.setOnClickListener(this);
        //b7.setBackgroundResource(R.drawable.btn_army_glossy);
        b8 = view2.findViewById(R.id.b8);
        b8.setOnClickListener(this);
        //b8.setBackgroundResource(R.drawable.btn_green_glossy);
    }


    @Override
    public void onClick(View view) {
        if( view == b1){
            Toast.makeText(getContext(),"Go to 1-1",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }else if( view == b2){
            Toast.makeText(getContext(),"Go to 1-2",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }else if( view == b3){
            Toast.makeText(getContext(),"Go to 2-1",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }else if( view == b4){
            Toast.makeText(getContext(),"Go to 2-2",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }else if( view == b5){
            Toast.makeText(getContext(),"Go to 3-1",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }else if( view == b6){
            Toast.makeText(getContext(),"Go to 3-2",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }else if( view == b7){
            Toast.makeText(getContext(),"Go to 4-1",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }else if( view == b8){
            Toast.makeText(getContext(),"Go to 4-2",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(),SetTimingAct.class));
        }
    }
}