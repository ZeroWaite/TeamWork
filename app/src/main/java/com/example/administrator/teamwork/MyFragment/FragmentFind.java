package com.example.administrator.teamwork.MyFragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.print.PrintJobInfo;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/12.
 */
public class FragmentFind extends Fragment {
    ImageButton findmenu;
    PopupWindow popupWindow;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.find2_layout,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findmenu= (ImageButton) view.findViewById(R.id.ib_find_menu);
        popupWindow=new PopupWindow();
        View v= LayoutInflater.from(this.getActivity()).inflate(R.layout.findmenu_layout,null);
        popupWindow.setContentView(v);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.Popwindow);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOnDismissListener(new PoponDismissListener());
        findmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundAlpha(0.3f);
                popupWindow.showAtLocation(findmenu, Gravity.CENTER,0,0);
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        backgroundAlpha(1f);
                    }
                });
            /*    Animation animation;
                animation = AnimationUtils.loadAnimation(null, R.anim.findmenu_layout);
                view1.startAnimation(animation);*/


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

    private void backgroundAlpha(float v) {
        WindowManager.LayoutParams lp=this.getActivity().getWindow().getAttributes();
        lp.alpha=v;
        this .getActivity().getWindow().setAttributes(lp);
    }




    private class PoponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {

        }
    }
}
