package com.example.administrator.teamwork.MyFragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.GridView;

import com.example.administrator.teamwork.MyInfo.MyHomeInfo;
import com.example.administrator.teamwork.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by anzhuo on 2016/9/12.
 */
public class MyHomeFrag extends Activity {
    private static final int MSG = 1;
    MyHomeInfo myHomeInfo;
    MyHomeInfo.WeekliesBean weekliesBean;
    List<MyHomeInfo> mList;
    List<MyHomeInfo.WeekliesBean> wList;
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

                    mList = gson.fromJson(str, new TypeToken<List<MyHomeInfo>>() {
                    }.getType());

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
