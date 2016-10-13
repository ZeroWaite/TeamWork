package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.teamwork.Board.NewDrawboardActivity;
import com.example.administrator.teamwork.MyFragment.ConcernFragment;
import com.example.administrator.teamwork.MyFragment.DrawBoardFragment;
import com.example.administrator.teamwork.MyFragment.GatherFragment;
import com.example.administrator.teamwork.MyFragment.LikeFragment;
import com.example.administrator.teamwork.PersonSetup.SearchActivity;
import com.example.administrator.teamwork.PersonSetup.SetUpActivity;

/**
 * Created by anzhuo on 2016/10/13.
 */
public class UserContentActivity extends AppCompatActivity {
    RadioGroup rg;
    FragmentTransaction transaction;
    FragmentManager manager;
    ConcernFragment concernFragment;
    DrawBoardFragment drawBoardFragment;
    LikeFragment likeFragment;
    GatherFragment gatherFragment;
    FrameLayout fragment;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_content_layout);

        fragment = (FrameLayout) findViewById(R.id.fg_user_content);
        rg = (RadioGroup) findViewById(R.id.rg_user_content);
        showFragment(0);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_board_user_content:
                        showFragment(0);
                        break;
                    case R.id.rb_collect_user_content:
                        showFragment(1);
                        break;
                    case R.id.rb_like_user_content:
                        showFragment(2);
                        break;
                    case R.id.rb_follow_user_content:
                        showFragment(3);
                        break;
                }
            }
        });

    }

    private void showFragment(int i) {
        manager = UserContentActivity.this.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        hideAll(transaction);
        switch (i) {
            case 0:
                if (drawBoardFragment == null) {
                    drawBoardFragment = new DrawBoardFragment();
                    transaction.add(R.id.fg_user_content, drawBoardFragment);
                } else {
                    transaction.show(drawBoardFragment);
                }
                break;
            case 1:
                if (gatherFragment == null) {
                    gatherFragment = new GatherFragment();
                    transaction.add(R.id.fg_user_content, gatherFragment);
                } else {
                    transaction.show(gatherFragment);
                }
                break;
            case 2:
                if (likeFragment == null) {
                    likeFragment = new LikeFragment();
                    transaction.add(R.id.fg_user_content, likeFragment);
                } else {
                    transaction.show(likeFragment);
                }

                break;
            case 3:
                if (concernFragment == null) {
                    concernFragment = new ConcernFragment();
                    transaction.add(R.id.fg_user_content, concernFragment);
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
