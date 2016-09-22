package com.example.administrator.teamwork.PersonSetup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/13.
 */
public class SearchActivity extends Activity {
    ImageButton backSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_my);
        backSearch= (ImageButton) findViewById(R.id.iv_return_search);
        backSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
