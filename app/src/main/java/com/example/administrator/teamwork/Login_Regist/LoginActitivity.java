package com.example.administrator.teamwork.Login_Regist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.teamwork.R;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * Created by anzhuo on 2016/10/11.
 */
public class LoginActitivity extends Activity {
    private Button bt_login_login;
    ImageView back;
    private TextView tv_login_register;
    private EditText et_user_login;
    private EditText et_pass_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        back = (ImageView) findViewById(R.id.iv_back_login);
        bt_login_login = (Button) findViewById(R.id.bt_login_login);
        tv_login_register = (TextView) findViewById(R.id.tv_login_register);
        et_user_login = (EditText) findViewById(R.id.et_user_login);
        et_pass_login = (EditText) findViewById(R.id.et_pass_login);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tv_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActitivity.this,RegiseterActivity.class);
                startActivity(intent);

            }
        });
        bt_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BmobUser.loginByAccount( et_user_login.getText().toString(), et_pass_login.getText().toString(), new LogInListener<MyUser>() {

                    @Override
                    public void done(MyUser user, BmobException e) {
                        if(user!=null){
                            Log.i("smile","用户登陆成功");
                        }
                    }
                });


            }
        });
    }


}
