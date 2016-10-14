package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.teamwork.Board.NewDrawboardActivity;
import com.example.administrator.teamwork.MyAdapter.ImgListAdapter;
import com.example.administrator.teamwork.MyFragment.ConcernFragment;
import com.example.administrator.teamwork.MyFragment.DrawBoardFragment;
import com.example.administrator.teamwork.MyFragment.GatherFragment;
import com.example.administrator.teamwork.MyFragment.LikeFragment;
import com.example.administrator.teamwork.MyInfo.InterBoardInfo;
import com.example.administrator.teamwork.MyInfo.InterUserContentInfo;
import com.example.administrator.teamwork.MyInfo.LocalShareInfo;
import com.example.administrator.teamwork.PersonSetup.SearchActivity;
import com.example.administrator.teamwork.PersonSetup.SetUpActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by anzhuo on 2016/10/13.
 */
public class UserContentActivity extends AppCompatActivity {

    SimpleDraweeView userHead;
    TextView username;
    TextView fans;
    TextView comeFrom;
    TextView job;
    TextView person;


    RadioGroup rg;
    FragmentTransaction transaction;
    FragmentManager manager;
    ConcernFragment concernFragment;
    DrawBoardFragment drawBoardFragment;
    LikeFragment likeFragment;
    GatherFragment gatherFragment;
    FrameLayout fragment;

    private static final int MSG = 1;
    String getUrl;
    String userID;
    String urlname;



    InterUserContentInfo interUserContentInfo;


    LocalShareInfo localPrettyGirlInfo;

    public static final String HTTP = "http://img.hb.aicdn.com/";


    OkHttpClient okHttpClient;
    String str;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            switch (msg.what) {
                case MSG:
                    getJsonData(str);
                    username.setText(localPrettyGirlInfo.getUsername());
                    userHead.setImageURI(localPrettyGirlInfo.getUserHead());
                    fans.setText(localPrettyGirlInfo.getFollow_count()+"粉丝 >");
                    if (localPrettyGirlInfo.getJob().equals("")) {
                        job.setVisibility(View.GONE);
                    } else {
                        job.setVisibility(View.VISIBLE);
                        job.setText(localPrettyGirlInfo.getJob());
                    }
                    if (localPrettyGirlInfo.getComeFrom().equals("")) {
                        comeFrom.setVisibility(View.GONE);
                    } else {
                        comeFrom.setVisibility(View.VISIBLE);
                        comeFrom.setText(localPrettyGirlInfo.getComeFrom());
                    }

                    if (localPrettyGirlInfo.getPersonSaying().equals("")) {
                        person.setVisibility(View.GONE);
                    } else {
                        person.setVisibility(View.VISIBLE);
                        person.setText(localPrettyGirlInfo.getPersonSaying());
                    }


                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_content_layout);
        username = (TextView) findViewById(R.id.tv_username_user_content);
        userHead = (SimpleDraweeView) findViewById(R.id.iv_userHead_user_content);
        comeFrom = (TextView) findViewById(R.id.tv_from_user_content);
        job = (TextView) findViewById(R.id.tv_job_user_content);
        fans = (TextView) findViewById(R.id.tv_fans_user_content);
        person = (TextView) findViewById(R.id.tv_personSaying_user_content);
        fragment = (FrameLayout) findViewById(R.id.fg_user_content);
        rg = (RadioGroup) findViewById(R.id.rg_user_content);

        Intent intent = getIntent();
        userID = intent.getExtras().getString("userID");
        getUrl = "http://api.huaban.com/users/" + userID;
        goThread();



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


    private LocalShareInfo getJsonData(String str) {
        Gson gson = new Gson();
        interUserContentInfo = gson.fromJson(str, InterUserContentInfo.class);
        localPrettyGirlInfo = new LocalShareInfo();
        localPrettyGirlInfo.setUsername(interUserContentInfo.getUsername());
        localPrettyGirlInfo.setFollow_count(interUserContentInfo.getFollower_count() == 0 ? "0" : String.valueOf(interUserContentInfo.getFollower_count()));
        localPrettyGirlInfo.setPin_count(interUserContentInfo.getPin_count() == 0 ? "0" : String.valueOf(interUserContentInfo.getPin_count()));
        localPrettyGirlInfo.setFollowing_count(interUserContentInfo.getFollowing_count() == 0 ? "0" : String.valueOf(interUserContentInfo.getFollowing_count()));
        localPrettyGirlInfo.setUserHead(HTTP + interUserContentInfo.getAvatar().getKey());
        localPrettyGirlInfo.setUserUrlName(interUserContentInfo.getUrlname());
        localPrettyGirlInfo.setJob(interUserContentInfo.getUser().getProfile().getJob() == null ? "" : interUserContentInfo.getUser().getProfile().getJob());
        localPrettyGirlInfo.setComeFrom(interUserContentInfo.getUser().getProfile().getLocation() == null ? "" : interUserContentInfo.getUser().getProfile().getLocation());
        localPrettyGirlInfo.setPersonSaying(interUserContentInfo.getUser().getProfile().getAbout() == null ? "" : interUserContentInfo.getUser().getProfile().getAbout());

        return localPrettyGirlInfo;

    }

    public void goThread() {

            new Thread() {
                @Override
                public void run() {
                    requstUrl(getUrl);
                    handler.sendEmptyMessage(MSG);
                }
            }.start();

    }

    private String requstUrl(String s) {
        okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(s).build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            str = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }


}
