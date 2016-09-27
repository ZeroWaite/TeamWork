package com.example.administrator.teamwork.MyFragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.teamwork.PersonSetup.NewDrawboardActivity;
import com.example.administrator.teamwork.PersonSetup.SearchActivity;
import com.example.administrator.teamwork.PersonSetup.SetUpActivity;
import com.example.administrator.teamwork.R;

/**
 * Created by Administrator on 2016/9/12.
 */
public class FragmentMine extends Fragment {
    RadioGroup rg;
    FragmentTransaction transaction;
    FragmentManager manager;
    ConcernFragment concernFragment;
    DrawBoardFragment drawBoardFragment;
    LikeFragment likeFragment;
    GatherFragment gatherFragment;
    View fragment;
    PopupWindow popupWindow;
    PopupWindow popupWindow2;
  ImageButton search;
    ImageButton setup;
    ImageButton add;
    TextView newDrawBoard;
    TextView urlCollect;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_frag, container, false);
        fragment = view.findViewById(R.id.fg_minePage2);
        rg = (RadioGroup) view.findViewById(R.id.rg_1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_plate:
                        showFragment(0);
                        break;
                    case R.id.rb_gather:
                        showFragment(1);
                        break;
                    case R.id.rb_like:
                        showFragment(2);
                        break;
                    case R.id.rb_concern:
                        showFragment(3);
                        break;
                }
            }
        });
        return view;
    }

    private void showFragment(int i) {
        manager = FragmentMine.this.getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        hideAll(transaction);
        switch (i) {
            case 0:
                if (drawBoardFragment == null) {
                    drawBoardFragment = new DrawBoardFragment();
                    transaction.add(R.id.fg_minePage2, drawBoardFragment);
                } else {
                    transaction.show(drawBoardFragment);
                }
                break;
            case 1:
                if (gatherFragment == null) {
                    gatherFragment = new GatherFragment();
                    transaction.add(R.id.fg_minePage2, gatherFragment);
                } else {
                    transaction.show(gatherFragment);
                }
                break;
            case 2:
                if (likeFragment == null) {
                    likeFragment = new LikeFragment();
                    transaction.add(R.id.fg_minePage2, likeFragment);
                } else {
                    transaction.show(likeFragment);
                }

                break;
            case 3:
                if (concernFragment == null) {
                    concernFragment = new ConcernFragment();
                    transaction.add(R.id.fg_minePage2, concernFragment);
                } else {
                    transaction.show(concernFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (drawBoardFragment != null) {
            transaction.hide(drawBoardFragment);
        }
        if (gatherFragment != null) {
            transaction.hide(gatherFragment);
        }
        if (likeFragment != null) {
            transaction.hide(likeFragment);
        }
        if (concernFragment != null) {
            transaction.hide(concernFragment);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        search= (ImageButton) view.findViewById(R.id.ib_search_person);
        setup= (ImageButton) view.findViewById(R.id.ib_setup_person);
        add= (ImageButton) view.findViewById(R.id.iv_add_person);
        popupWindow=new PopupWindow();
        View v = LayoutInflater.from(FragmentMine.this.getActivity()).inflate(R.layout.add_layout, null);
        popupWindow.setContentView(v);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setAnimationStyle(R.style.Popwindow);
        popupWindow.setOnDismissListener(new PoponDismissListener());

        popupWindow2 = new PopupWindow();
        View v2 = LayoutInflater.from(FragmentMine.this.getActivity()).inflate(R.layout.url_collect_layout, null);
        popupWindow2.setContentView(v2);
        popupWindow2.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow2.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        popupWindow2.setFocusable(true);
        popupWindow2.setTouchable(true);
        popupWindow2.setOutsideTouchable(true);
        popupWindow2.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow2.setAnimationStyle(R.style.Popwindow2);
        popupWindow2.setOnDismissListener(new PoponDismissListener());


        urlCollect = (TextView) v.findViewById(R.id.tv_urlGather_add);
        urlCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow2.showAtLocation(urlCollect, Gravity.CENTER, 0, 0);
                backgroundAlpha(0.4f);
            }
        });
        newDrawBoard = (TextView) v.findViewById(R.id.tv_foundPalette_add);
        newDrawBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentMine.this.getActivity(), NewDrawboardActivity.class);
                startActivity(intent);
            }
        });
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater(R.layout.son_fragment, null);
    }

    private void getLayoutInflater(int son_fragment, Object o) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }
}
