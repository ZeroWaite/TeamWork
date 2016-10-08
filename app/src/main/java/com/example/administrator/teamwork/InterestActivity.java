package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by anzhuo on 2016/10/8.
 */
public class InterestActivity extends Activity {
    TextView title;
    TextView intro;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_layout);
        title = (TextView) findViewById(R.id.tv_title_interest);
        intro = (TextView) findViewById(R.id.tv_intro_interest);
        back = (ImageButton) findViewById(R.id.ib_back_interest);
        Intent intent = getIntent();

        title.setText(intent.getExtras().getString("title"));
        intro.setText(intent.getExtras().getString("intro"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
