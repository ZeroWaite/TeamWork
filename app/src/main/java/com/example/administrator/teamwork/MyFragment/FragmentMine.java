package com.example.administrator.teamwork.MyFragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.teamwork.Board.NewDrawboardActivity;
import com.example.administrator.teamwork.Search.SearchActivity;
import com.example.administrator.teamwork.PersonSetup.SetUpActivity;
import com.example.administrator.teamwork.R;

import java.io.File;
import java.math.BigDecimal;

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
    FrameLayout fragment;
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
        fragment = (FrameLayout) view.findViewById(R.id.fg_minePage2);
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
    public static String getTotalCacheSize(Context context) throws Exception {
        long cacheSize = getFolderSize(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheSize += getFolderSize(context.getExternalCacheDir());
        }
        return getFormatSize(cacheSize);
    }



    public static void clearAllCache(Context context) {
        deleteDir(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteDir(context.getExternalCacheDir());
        }
    }

    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    // 获取文件
    //Context.getExternalFilesDir() --> SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据
    //Context.getExternalCacheDir() --> SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
    public static long getFolderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    /**
     * 格式化单位
     *
     * @param size
     * @return
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
//            return size + "Byte";
            return "0K";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                + "TB";
    }
}
