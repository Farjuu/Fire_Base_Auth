package com.example.farjana.fire_base_auth;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Farjana on 11/3/2017.
 */

public class Fragment1 extends android.support.v4.app.Fragment {

    View view1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view1 = inflater.inflate(R.layout.fragment_layout1,container,false);

       return view1;
    }


}
