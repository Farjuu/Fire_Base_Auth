package com.example.farjana.fire_base_auth;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farjana on 11/3/2017.
 */

 class ViewPagerAdapter extends FragmentPagerAdapter{

    private final List<Fragment> list = new ArrayList<Fragment>();
    private final List<String> titles = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    void addMyFragment(Fragment f,String title){
        list.add(f);
        titles.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position){
       return titles.get(position);
    }
}
