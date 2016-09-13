package com.example.administrator.teamwork;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg_home;
    RadioButton rb_homePage;
    android.app.FragmentManager manager;
    FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_home = (RadioGroup) findViewById(R.id.rg_all);
        rb_homePage = (RadioButton) findViewById(R.id.rb_homePage);
        rb_homePage.setChecked(true);
        rg_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_homePage:
                        break;
                    case R.id.rb_foundPage:
                        break;
                    case R.id.rb_messagePage:
                        break;
                    case R.id.rb_minePage:
                        break;
                }
            }
        });
    }
     private void showFragment(int i) {
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        hideAllFragment(transaction);
        switch (i) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.my_fragment, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                if (secretFragment == null) {
                    secretFragment = new SecretFragment();
                    transaction.add(R.id.my_fragment, secretFragment);
                } else {
                    transaction.show(secretFragment);
                }
                break;
            case 2:
                if (searchFragment == null) {
                    searchFragment = new SearchFragment();
                    transaction.add(R.id.my_fragment, searchFragment);
                } else {
                    transaction.show(searchFragment);
                }

                break;
            case 3:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.my_fragment, mineFragment);
                } else {
                    transaction.show(mineFragment);
                }
                break;
        }
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (secretFragment != null) {
            transaction.hide(secretFragment);
        }
        if (searchFragment != null) {
            transaction.hide(searchFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }

    }
}
