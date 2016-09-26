package com.example.administrator.teamwork.MyFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/26.
 */
public class SonMineFragment extends AppCompatActivity {
    RadioGroup radioGroup;
    FragmentManager manager;
    FragmentTransaction transaction;
    ConcernFragment concernFragment;
    DrawBoardFragment drawBoardFragment;
    LikeFragment likeFragment;
    GatherFragment gatherFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.son_fragment);
        radioGroup = (RadioGroup) findViewById(R.id.rg_2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_plate:
                        showFragment(0);
                        break;
                    case R.id.rb_gather:
                        showFragment(1);
                        break;
                    case R.id.rb_like:
                        showFragment(2);
                        break;
                    case R.id.rb_concern:
                        showFragment(3);
                        break;
                }
            }
        });
    }

    private void showFragment(int i) {
        manager=getSupportFragmentManager();
        transaction=manager.beginTransaction();
        hideAll(transaction);
        switch (i) {
            case 0:
                if (drawBoardFragment == null) {
                    drawBoardFragment = new DrawBoardFragment();
                    transaction.add(R.id.fg_minePage2, drawBoardFragment);
                } else {
                    transaction.show(drawBoardFragment);
                }
                break;
            case 1:
                if (gatherFragment == null) {
                    gatherFragment = new GatherFragment();
                    transaction.add(R.id.fg_minePage2, gatherFragment);
                } else {
                    transaction.show(gatherFragment);
                }
                break;
            case 2:
                if (likeFragment == null) {
                    likeFragment = new LikeFragment();
                    transaction.add(R.id.fg_minePage2, likeFragment);
                } else {
                    transaction.show(likeFragment);
                }

                break;
            case 3:
                if (concernFragment == null) {
                    concernFragment = new ConcernFragment();
                    transaction.add(R.id.fg_minePage2, concernFragment);
                } else {
                    transaction.show(concernFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (drawBoardFragment != null) {
            transaction.hide(drawBoardFragment);
        }
        if (gatherFragment != null) {
            transaction.hide(gatherFragment);
        }
        if (likeFragment != null) {
            transaction.hide(likeFragment);
        }
        if (concernFragment != null) {
            transaction.hide(concernFragment);
        }

    }


}
