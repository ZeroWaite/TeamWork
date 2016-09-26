package com.example.administrator.teamwork.MyFragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.GridView;

import com.example.administrator.teamwork.MyAdapter.MyImageAdapter;
import com.example.administrator.teamwork.MyInfo.InterHomePageInfo;
import com.example.administrator.teamwork.MyInfo.LocalHomePageInfo;
import com.example.administrator.teamwork.R;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by anzhuo on 2016/9/12.
 */
public class MyHomeFrag extends Activity {
    private static final int MSG = 1;
    InterHomePageInfo interHomePageInfo;
    MyImageAdapter myImageAdapter;
    List<LocalHomePageInfo> mList = new ArrayList<>();
    LocalHomePageInfo localHomePageInfo;

    GridView gridView;
    OkHttpClient okHttpClient;
    String str;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG:
                    Log.i("str", str);
                    Gson gson = new Gson();
                    interHomePageInfo = gson.fromJson(str, InterHomePageInfo.class);
                    for (int i = 0; i < interHomePageInfo.getWeeklies().toArray().length; i++) {
                        localHomePageInfo = new LocalHomePageInfo();
                        localHomePageInfo.setContent(interHomePageInfo.getWeeklies().get(i).getDescription());
                        localHomePageInfo.setUsername(interHomePageInfo.getWeeklies().get(i).getTitle());
                        localHomePageInfo.setImageContent("http://" + interHomePageInfo.getImgHost() + interHomePageInfo.getWeeklies().get(i).getCover());
                        mList.add(localHomePageInfo);
                    }
                    myImageAdapter = new MyImageAdapter(mList, MyHomeFrag.this);
                    gridView.setAdapter(myImageAdapter);


                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_frag);
        gridView = (GridView) findViewById(R.id.gv_imageList_home);
        okHttpClient = new OkHttpClient();
        new Thread() {
            @Override
            public void run() {
                requstUrl("http://api.huaban.com/weekly/");
                handler.sendEmptyMessage(MSG);
            }
        }.start();
    }

    private String requstUrl(String s) {
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
