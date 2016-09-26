package com.example.administrator.teamwork.PersonSetup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/13.
 */
public class IdSetupActivity extends Activity {
    ImageButton accountBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_setup);
        accountBack= (ImageButton) findViewById(R.id.ib_back_account_setup);
        accountBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
