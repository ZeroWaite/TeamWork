package com.example.administrator.teamwork;

/**
 * Created by Administrator on 2016/11/3.
 */

public class Application extends android.app.Application {
    private static Application mApplication;
    public static int mNetWorkStates;

    public static synchronized Application getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        initData();
    }



    public void initData() {
        mNetWorkStates = NetUtil.getNetworkState(this);
    }
}
