package com.example.administrator.teamwork.Login_Regist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/29.
 */
public class CompleteRegistActivity extends Activity {
    TextView present_num;
    EditText auchCoad;
    Button resend;
    EditText psw;
    EditText username;
    Button sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completeregist_layout);
        present_num= (TextView) findViewById(R.id.present_number);
        auchCoad= (EditText) findViewById(R.id.et_authcoad);
        resend= (Button) findViewById(R.id.bt_resend);
        psw= (EditText) findViewById(R.id.et_regist_password);
        username= (EditText) findViewById(R.id.et_regist_name);
        sure= (Button) findViewById(R.id.bt_regist_sure);
        final Intent intent=getIntent();
        String username=intent.getStringExtra("username");
        String userNum=username;
        this.present_num.setText(userNum);

        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(CompleteRegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                 Intent intent1=new Intent(CompleteRegistActivity.this,LoginAcitivity.class);
                 startActivity(intent1);
            }
        });
    }
}
