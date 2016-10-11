package com.example.administrator.teamwork.MyAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by anzhuo on 2016/9/30.
 */
public class MyViewAdapter extends FragmentPagerAdapter {
    List<Fragment> mList;


    public MyViewAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        this.mList=list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }
}
