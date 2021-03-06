package com.example.administrator.teamwork.PersonSetup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.DataCleanManager;
import com.example.administrator.teamwork.R;

import java.io.File;

/**
 * Created by Administrator on 2016/9/13.
 */
public class SetUpActivity extends Activity {
    TextView exit;
    TextView personSet;
    TextView accountSet;
    static TextView clean;
    ImageButton setupBack;
    PopupWindow popupWindow;
    TextView cancels;
    TextView sure;
     File cache;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_layout);
        exit= (TextView) findViewById(R.id.tv_logout_setup);
        clean= (TextView) findViewById(R.id.tv_clearCache_setup);
        accountSet= (TextView) findViewById(R.id.tv_idSet_setup);
        personSet= (TextView) findViewById(R.id.tv_personSet_setup);
        setupBack= (ImageButton) findViewById(R.id.ib_back_setup);

        popupWindow=new PopupWindow();
        View v= LayoutInflater.from(SetUpActivity.this).inflate(R.layout.user_exit_layout,null);
        popupWindow.setContentView(v);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setAnimationStyle(R.style.Popwindow2);
        popupWindow.setOnDismissListener(new PoponDismissListener());
        cancels= (TextView) v.findViewById(R.id.bt_cancal);
        cancels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setupBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        personSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SetUpActivity.this,PersonalSetActivity.class);
                startActivity(intent);
            }
        });
        accountSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SetUpActivity.this,IdSetupActivity.class);
                startActivity(intent);
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataCleanManager.cleanInternalCache(SetUpActivity.this);
               try {
                    //查看缓存的大小
                    Log.e("STR", DataCleanManager.getTotalCacheSize(SetUpActivity.this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            /*    //清除操作

                DataCleanManager.clearAllCache(SetUpActivity.this);
                try {
                    //清除后的操作
                    Log.e("STR", DataCleanManager.getTotalCacheSize(SetUpActivity.this));
                } catch (Exception e) {
                    e.printStackTrace();
                }  */

                Toast.makeText(SetUpActivity.this, "清除缓存成功", Toast.LENGTH_SHORT).show();
            }
        });



        exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(exit, Gravity.CENTER,0,0);
                backgroundAlpha(0.3f);

            }

        });


    }

    private class PoponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }
    }

    private void backgroundAlpha(float v) {
        WindowManager.LayoutParams lp=this.getWindow().getAttributes();
        lp.alpha=v;
        this .getWindow().setAttributes(lp);
    }



}
