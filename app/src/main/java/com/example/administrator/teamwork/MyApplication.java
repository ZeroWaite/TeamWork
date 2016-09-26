package com.example.administrator.teamwork;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by anzhuo on 2016/9/20.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
