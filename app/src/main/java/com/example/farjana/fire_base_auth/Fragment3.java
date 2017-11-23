package com.example.farjana.fire_base_auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Farjana on 11/3/2017.
 */

public class Fragment3 extends android.support.v4.app.Fragment {
    View view3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view3 = inflater.inflate(R.layout.fragment_layout3,container,false);

        return view3;
    }
}