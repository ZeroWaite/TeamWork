package com.example.administrator.teamwork.MyFragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import com.example.administrator.teamwork.PersonSetup.SearchActivity;
import com.example.administrator.teamwork.PersonSetup.SetUpActivity;
import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/12.
 */
public class FragmentMine extends Fragment {
    PopupWindow popupWindow;
  ImageButton search;
    ImageButton setup;
    ImageButton add;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.mine_frag,null);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search= (ImageButton) view.findViewById(R.id.ib_search_person);
        setup= (ImageButton) view.findViewById(R.id.ib_setup_person);
        add= (ImageButton) view.findViewById(R.id.iv_add_person);
        popupWindow=new PopupWindow();
        View v= LayoutInflater.from(FragmentMine.this.getActivity()).inflate(R.layout.add_layout,null);
        popupWindow.setContentView(v);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setAnimationStyle(R.style.Popwindow2);
        popupWindow.setOnDismissListener(new PoponDismissListener());

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FragmentMine.this.getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FragmentMine.this.getActivity(), SetUpActivity.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.showAtLocation(add, Gravity.BOTTOM,0,0);
                backgroundAlpha(0.3f);
            }
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
            backgroundAlpha(1f);
        }
    }
/*  @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }*/
}
