package com.example.administrator.teamwork;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/12.
 */
public class FindMenuList_Activity extends Activity {
    ImageButton findmenu;
    PopupWindow popupWindow;



    View v ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find2_layout);

        findmenu= (ImageButton) findViewById(R.id.ib_find_menu);
        popupWindow=new PopupWindow();
        final View view= LayoutInflater.from(this).inflate(R.layout.findmenu_layout,null);
        final View view1=LayoutInflater.from(this).inflate(R.layout.find2_layout,null);
        popupWindow.setContentView(view);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        findmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*popupWindow.showAsDropDown(findmenu);*/
                popupWindow.showAtLocation(findmenu, Gravity.CENTER,0,0);
                Animation animation=AnimationUtils.loadAnimation(FindMenuList_Activity.this,R.anim.findmenu_layout);
                view1.startAnimation(animation);


             }
          /*  private void showpop(final Context context){
                View view1=View.inflate(context,R.layout.find2_layout,null);
                popupWindow1=new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT,false){
                    @Override
                    public void dismiss() {
                        animation.startAnimation(AnimationUtils.loadAnimation(context,R.anim.findmenu_layout));
                        animation.setVisibility(View.GONE);
                        super.dismiss();
                    }
                };
                animation.setVisibility(View.VISIBLE);
                animation.startAnimation(AnimationUtils.loadAnimation(context,R.anim.findmenu_layout));
                popupWindow1.showAtLocation(animation,Gravity.BOTTOM,0,0);
            }*/
        });



    }
}
