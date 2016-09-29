package com.example.administrator.teamwork.Login_Regist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/29.
 */
public class RegistActivity extends Activity {
    TextView next;
    ImageView back;
    EditText phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registpage_layout);
        back= (ImageView) findViewById(R.id.iv_regist_back);
        next= (TextView) findViewById(R.id.tv_regist_next);
        phone_number= (EditText) findViewById(R.id.et_regist_boxPhone);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistActivity.this,CompleteRegistActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
