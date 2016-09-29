package com.example.administrator.teamwork.Board;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/27.
 */
public class BoardNewFinishi extends Activity {
    ImageView back,edit,share;

  PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawboard_list_item);
        back= (ImageView) findViewById(R.id.tv_drawBoardName_drawBoard_item);
        edit= (ImageView) findViewById(R.id.board_edit);
        share=  (ImageView) findViewById(R.id.iv_board_share);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BoardNewFinishi.this,EditBoardActivity.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow=new PopupWindow();
                View view= LayoutInflater.from(BoardNewFinishi.this).inflate(R.layout.share_board_layout,null);
                popupWindow.setContentView(view);
                popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.setAnimationStyle(R.style.Popwindow2);
                popupWindow.setOnDismissListener(new PoponDismissListener());
                popupWindow.showAtLocation(share, Gravity.BOTTOM,0,0);
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
        this.getWindow().setAttributes(lp);
    }

}
