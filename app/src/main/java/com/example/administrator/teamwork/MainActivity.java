package com.example.administrator.teamwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.teamwork.MyFragment.FragmentFind;
import com.example.administrator.teamwork.MyFragment.FragmentHome;
import com.example.administrator.teamwork.MyFragment.FragmentMine;
import com.example.administrator.teamwork.MyFragment.FragmentNews;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg_home;
    RadioButton rb_home;
    FragmentManager manager;
    FragmentTransaction transaction;
    FragmentHome fragmentHome;
    FragmentFind fragmentFind;
    FragmentNews fragmentNews;
    FragmentMine fragmentMine;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_home = (RadioGroup) findViewById(R.id.rg_all);
        rb_home = (RadioButton) findViewById(R.id.rb_homePage);
        showFragment(0);

        rg_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_homePage:
                        showFragment(0);
                        break;
                    case R.id.rb_foundPage:
                        showFragment(1);
                        break;
                    case R.id.rb_messagePage:
                        showFragment(2);
                        break;
                    case R.id.rb_minePage:
                        showFragment(3);
                        break;
                }
            }
        });
    }
     private void showFragment(int i) {
         manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        hideAllFragment(transaction);
        switch (i) {
            case 0:
                if (fragmentHome == null) {
                    fragmentHome = new FragmentHome();
                    transaction.add(R.id.fg_homePage, fragmentHome);
                } else {
                    transaction.show(fragmentHome);
                }
                break;
            case 1:
                if (fragmentFind == null) {
                    fragmentFind = new FragmentFind();
                    transaction.add(R.id.fg_homePage, fragmentFind);
                } else {
                    transaction.show(fragmentFind);
                }
                break;
            case 2:

                if (fragmentNews == null) {
                    fragmentNews = new FragmentNews();
                    transaction.add(R.id.fg_homePage, fragmentNews);
                } else {
                    transaction.show(fragmentNews);
                }

                break;
            case 3:
                if (fragmentMine == null) {
                    fragmentMine = new FragmentMine();
                    transaction.add(R.id.fg_homePage, fragmentMine);
                } else {
                    transaction.show(fragmentMine);
                }
                break;
        }
         transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (fragmentHome != null) {
            transaction.hide(fragmentHome);
        }
        if (fragmentFind != null) {
            transaction.hide(fragmentFind);
        }
        if (fragmentNews != null) {
            transaction.hide(fragmentNews);
        }
        if (fragmentMine != null) {
            transaction.hide(fragmentMine);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
