package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by anzhuo on 2016/10/11.
 */
public class LoginActitivity extends Activity {
    private Button bt_login_login;
    private Button bt_login_register;
    private EditText et_user_login;
    private EditText et_pass_login;
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        bt_login_login = (Button) findViewById(R.id.bt_login_login);
        bt_login_register = (Button) findViewById(R.id.bt_login_register);
        et_user_login = (EditText) findViewById(R.id.et_user_login);
        et_pass_login = (EditText) findViewById(R.id.et_pass_login);
        bt_login_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_user_login.getText().toString().trim();
                String pass = et_pass_login.getText().toString().trim();

                User user = new User();
                user.setUsername(name);
                user.setUserpwd(pass);

                int result = SqliteDB.getInstance(getApplicationContext()).saveUser(user);
                if (result == 1) {
                    Toast.makeText(LoginActitivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                } else if (result == -1) {
                    Toast.makeText(LoginActitivity.this, "用户名已经存在！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActitivity.this, "！", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_user_login.getText().toString().trim();
                String pass = et_pass_login.getText().toString().trim();
                int result = SqliteDB.getInstance(getApplicationContext()).Quer(pass, name);
                if (result == 1) {
                    Toast.makeText(LoginActitivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActitivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else if (result == 0) {
                    Toast.makeText(LoginActitivity.this, "用户名不存在！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActitivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
