package com.example.administrator.teamwork.PersonSetup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/13.
 */
public class PersonalSetActivity extends Activity {
    ImageButton backward;
    ImageView save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_setup);
        save= (ImageView) findViewById(R.id.iv_commit_person_setup);
        backward= (ImageButton) findViewById(R.id.ib_backward_person_setup);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PersonalSetActivity.this,"成功保存了账号设置",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
