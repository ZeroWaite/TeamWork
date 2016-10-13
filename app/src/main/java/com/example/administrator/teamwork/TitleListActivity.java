package com.example.administrator.teamwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.teamwork.MyAdapter.MyViewAdapter;
import com.example.administrator.teamwork.MyFragment.FragBoard;
import com.example.administrator.teamwork.MyFragment.FragCollect;
import com.example.administrator.teamwork.MyFragment.FragUsers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anzhuo on 2016/9/30.
 */
public class TitleListActivity extends AppCompatActivity{
    TextView title;
    RadioGroup mRadioGroup;
    ViewPager mViewPager;
    MyViewAdapter myViewAdapter;
    ImageView back;
    List<Fragment> mList;
    FragCollect fragCollect;
    FragBoard fragBoard;
    FragUsers fragUsers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_list_layout);
        back= (ImageView) findViewById(R.id.ib_back_onTitle);
        mViewPager = (ViewPager) findViewById(R.id.vp_onTitle);
        title = (TextView) findViewById(R.id.tv_title_onTitle);
        Intent intent = getIntent();
        title.setText(intent.getExtras().getString("title"));
        mList = new ArrayList<>();
        fragCollect = new FragCollect();
        fragBoard = new FragBoard();
        fragUsers = new FragUsers();
        mList.add(fragCollect);
        mList.add(fragBoard);
        mList.add(fragUsers);

        myViewAdapter = new MyViewAdapter(getSupportFragmentManager(),mList);
        mViewPager.setAdapter(myViewAdapter);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_title_onTitle);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_collect_onTitle:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_board_onTitle:
                        mViewPager.setCurrentItem(1);

                        break;
                    case R.id.rb_users_onTitle:
                        mViewPager.setCurrentItem(2);

                        break;

                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //滑动界面切换
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.rb_collect_onTitle);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.rb_board_onTitle);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.rb_users_onTitle);
                        break;
                  default:
                      break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
