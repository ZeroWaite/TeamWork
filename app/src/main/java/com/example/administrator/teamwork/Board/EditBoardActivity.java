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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/27.
 */
public class EditBoardActivity extends Activity {
    PopupWindow pop;
    ImageView save;
    ImageView back;
    Button delete_board;
    TextView cancel;
    TextView delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawboard_edit_layout);
        back= (ImageView) findViewById(R.id.ib_back_transPonds);
        save= (ImageView) findViewById(R.id.iv_save_edit);
        delete_board= (Button) findViewById(R.id.bt_delete_board);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
          save.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Toast.makeText(EditBoardActivity.this,"创建成功",Toast.LENGTH_SHORT).show();
                  Intent intent=new Intent(EditBoardActivity.this,BoardNewFinishi.class);
                  startActivity(intent);
              }
          });
        delete_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop=new PopupWindow();
                View view= LayoutInflater.from(EditBoardActivity.this).inflate(R.layout.delete_board_layout,null);
                pop.setContentView(view);
                pop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                pop.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                pop.setFocusable(true);
                pop.setTouchable(true);
                pop.setOutsideTouchable(true);
                pop.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                pop.setAnimationStyle(R.style.Popwindow2);
                pop.setOnDismissListener(new PoponDismissListener());
                pop.showAtLocation(delete_board, Gravity.CENTER,0,0);
                backgroundAlpha(0.3f);

                cancel= (TextView) view.findViewById(R.id.delete_cancel);
                delete= (TextView) view.findViewById(R.id.delete);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(EditBoardActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(EditBoardActivity.this,BoardNewFinishi.class);
                        startActivity(i);
                        Toast.makeText(EditBoardActivity.this,"画板不存在",Toast.LENGTH_SHORT).show();
                    }
                });
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
