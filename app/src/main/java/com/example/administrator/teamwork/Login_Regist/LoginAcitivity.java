package com.example.administrator.teamwork.Login_Regist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/29.
 */
public class LoginAcitivity extends Activity {
    EditText user;
    EditText password;
    private String USER;
    private String PSW;
    Button loading;
    TextView forget_psw;
    TextView phone_regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);
        user= (EditText) findViewById(R.id.et_mailbox_phone);
        forget_psw= (TextView) findViewById(R.id.bt_forgetPsw);
        password= (EditText) findViewById(R.id.et_loading_password);
        phone_regist= (TextView) findViewById(R.id.bt_phone_regist);
    }
}
