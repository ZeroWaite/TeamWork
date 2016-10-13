package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
        if (!isNetworkAvailable(MainActivity.this)) {
            Toast.makeText(getApplicationContext(), "当前没有可用网络！", Toast.LENGTH_LONG).show();
        }


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
    public boolean isNetworkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    System.out.println(i + "===状态===" + networkInfo[i].getState());
                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
