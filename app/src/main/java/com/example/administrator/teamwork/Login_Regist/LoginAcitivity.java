package com.example.administrator.teamwork.Login_Regist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.teamwork.MyFragment.FragmentMine;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);
        String name=user.getText().toString();
        String psw=password.getText().toString();
        SharedPreferences sp = this.getSharedPreferences("data", Context.MODE_PRIVATE);
        USER=sp.getString("userName","");
        PSW=sp.getString("password","");

        if (name!=null&&name.length()>0||psw!=null&&psw.length()>0){

            user= (EditText) findViewById(R.id.et_mailbox_phone);
            password= (EditText) findViewById(R.id.et_loading_password);
            loading= (Button) findViewById(R.id.bt_loadingButton);

            if (name.equals(USER)&&psw.equals(PSW)){
                loading.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(LoginAcitivity.this, FragmentMine.class);
                        startActivity(intent);
                        Toast.makeText(LoginAcitivity. this , "登录成功", Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                Toast.makeText(LoginAcitivity. this, "用户名或密码错误，请重新登录", Toast.LENGTH_SHORT).show();

            }

        }
    }
}
