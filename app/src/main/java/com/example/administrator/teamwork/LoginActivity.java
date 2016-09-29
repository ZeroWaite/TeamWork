package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.PersonSetup.SearchActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.smssdk.EventHandler;
import cn.smssdk.gui.RegisterPage;

/**
 * Created by anzhuo on 2016/9/28.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    ImageView iv_back_login;
    ImageView iv_user_login;
    EditText et_user_login;
    ImageView iv_key_login;
    EditText et_pass_login;
    TextView tv_forget_login;
    Button bt_login_login;
    TextView tv_qq_login;
    TextView tv_weixin_login;
    TextView tv_register_login;
    private static final String TAG = LoginActivity.class.getName();
    public static String mAppid;
    /*public static QQAuth mQQAuth;
    private static Tencent mTencent;*/
    private final String APP_ID = "1105627007";// 测试时使用，真正发布的时候要换成自己的APP_ID
    String name;
    String pass;
    String mobile;
    private int START;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "-->onCreate");
        setContentView(R.layout.login);

        // 固定竖屏
        setContentView(R.layout.login);
        iv_back_login = (ImageView) findViewById(R.id.iv_back_login);
        iv_user_login = (ImageView) findViewById(R.id.iv_user_login);
        et_user_login = (EditText) findViewById(R.id.et_user_login);
        iv_key_login = (ImageView) findViewById(R.id.iv_key_login);
        et_pass_login = (EditText) findViewById(R.id.et_pass_login);
        tv_forget_login = (TextView) findViewById(R.id.tv_forget_login);
        bt_login_login = (Button) findViewById(R.id.bt_login_login);
        tv_qq_login = (TextView) findViewById(R.id.tv_qq_login);
        iv_back_login.setOnClickListener(this);
        iv_user_login.setOnClickListener(this);
        et_user_login.setOnClickListener(this);
        iv_key_login.setOnClickListener(this);
        et_pass_login.setOnClickListener(this);
        tv_forget_login.setOnClickListener(this);
        bt_login_login.setOnClickListener(this);
        tv_qq_login.setOnClickListener(this);
        tv_weixin_login.setOnClickListener(this);
        tv_register_login.setOnClickListener(this);
    /*    initViews();*/
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_login:
                finish();
                break;
            case R.id.bt_login_login:
                   /*
        读取后端云表格信息
         */
                Bmob.initialize(this, "97c2b91c462d4a2b6538a2fe1dbb4281");
                BmobQuery n = new BmobQuery("News");
                n.findObjectsByTable(new QueryListener<JSONArray>() {
                    @Override
                    public void done(JSONArray jsonArray, BmobException e) {
                        if (e == null) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                try {
                                    JSONObject json = (JSONObject) jsonArray.get(i);
                                    name = json.getString("name");
                                    pass = json.getString("password");
                                    mobile = json.getString("mobile");
                                    Log.i("LT", name);
                                } catch (JSONException e1) {
                                    e1.printStackTrace();
                                }

                                if (et_user_login.getText().toString().equals(name) || et_user_login.getText().toString().equals(mobile) && et_pass_login.getText().toString().equals(pass)) {
                                    Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                    START = 2;
                                }
                            }
                        }
                        if (START != 2) {
                            Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
        }
    }

    protected void onStart() {
        Log.d(TAG, "-->onStart");
        final Context context = LoginActivity.this;
        final Context ctxContext = context.getApplicationContext();
        mAppid = APP_ID;
      /*  mQQAuth = QQAuth.createInstance(mAppid, ctxContext);
        mTencent = Tencent.createInstance(mAppid, LoginActivity.this);*/
        super.onStart();
/*
    }*/

  /*  private void updateUserInfo() {
        if (mQQAuth != null && mQQAuth.isSessionValid()) {
            MainApplication.qqToken = mQQAuth.getQQToken();
            Intent intent = new Intent(LoginActivity.this, SearchActivity.class);
            startActivity(intent);
        }
    }

    private void onClickLogin() {
        if (!mQQAuth.isSessionValid()) {
            IUiListener listener = new BaseUiListener();
            mQQAuth.login(this, "all", listener);
            mTencent.login(this, "all", listener);
        } else {
            mQQAuth.logout(this);
            updateUserInfo();
        }
    }

    public static boolean ready(Context context) {
        if (mQQAuth == null) {
            return false;
        }
        boolean ready = mQQAuth.isSessionValid()
                && mQQAuth.getQQToken().getOpenId() != null;
        if (!ready)
            Toast.makeText(context, "login and get openId first, please!",
                    Toast.LENGTH_SHORT).show();
        return ready;
    }

    private class BaseUiListener implements IUiListener {
        @Override
        public void onComplete(Object response) {
            updateUserInfo();
        }

        protected void doComplete(JSONObject values) {
        }

        @Override
        public void onError(UiError e) {
            Util.toastMessage(LoginActivity.this, "onError: " + e.errorDetail);
            Util.dismissDialog();
        }

        @Override
        public void onCancel() {
            Util.toastMessage(LoginActivity.this, "onCancel: ");
            Util.dismissDialog();
        }
    }*/

    /*class NewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Class<?> cls = null;
            switch (v.getId()) {
                case R.id.tv_qq_login:
                    Toast.makeText(LoginActivity.this, "123456", Toast.LENGTH_SHORT).show();
                    onClickLogin();
                    return;
            }*/
          /*  if (cls != null) {
                Intent intent = new Intent(context, cls);
                context.startActivity(intent);
            }*/


            cn.smssdk.SMSSDK.initSDK(LoginActivity.this, "17830f8345bdc", "05ddeed9c6288798d342b960719ba8e2");
            RegisterPage registerPage = new RegisterPage();
            registerPage.setRegisterCallback(new EventHandler() {
                @Override
                public void afterEvent(int i, int i1, Object o) {
                    if (i1 == cn.smssdk.SMSSDK.RESULT_COMPLETE) {
                        HashMap<String, Object> phoneMap = (HashMap<String, Object>) o;
                        String country = (String) phoneMap.get("country");
                        String phone = (String) phoneMap.get("phone");

// 提交用户信息（此方法可以不调用）
                        registerUser(country, phone);
                    }

                }
            });
            registerPage.show(LoginActivity.this);
        }


        private void registerUser(String country, String phone) {
            Random rnd = new Random();
            int id = Math.abs(rnd.nextInt());
            String uid = String.valueOf(id);
            String nickName = "zhilinghiH" + uid;
            cn.smssdk.SMSSDK.submitUserInfo(uid, nickName, null, country, phone);
        }
    }
/*}*/


