package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.MyFragment.FragmentFind;
import com.example.administrator.teamwork.MyFragment.FragmentHome;
import com.example.administrator.teamwork.MyFragment.FragmentMine;
import com.example.administrator.teamwork.MyFragment.FragmentNews;
import com.example.administrator.teamwork.PersonSetup.IdSetupActivity;
import com.example.administrator.teamwork.Search.SearchActivity;

import java.io.File;

import static com.example.administrator.teamwork.R.id.tv_humanityart;
import static com.example.administrator.teamwork.R.id.tv_movie_book;
import static com.example.administrator.teamwork.R.id.tv_pet;
import static com.example.administrator.teamwork.R.id.tv_present;
import static com.example.administrator.teamwork.R.id.tv_travel;
import static com.example.administrator.teamwork.R.id.tv_wedding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rg_home;
    RadioButton rb_home;
    FragmentManager manager;
    FragmentTransaction transaction;
    FragmentHome fragmentHome;
    FragmentFind fragmentFind;
    FragmentNews fragmentNews;
    FragmentMine fragmentMine;
    File cache;

    FrameLayout frameLayout;

    SearchView searchView;
    LinearLayout linearLayout;
    ImageButton findmenu;
    PopupWindow popupWindow;
    TextView hot, plane, modeling, manfashion, inset, home, wedding, food, travel, pet, beauty,
            present, constructiondesign, humanityart, movie_book, Encyclopedias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cache = new File(Environment.getExternalStorageDirectory(), "cache");
        if (!cache.exists()) {
            cache.mkdirs();
        }

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
      /*  BmobConfig config =new BmobConfig.Builder(this)
        //设置appkey
        .setApplicationId("63f8317df1241bffc4987fc27b58c13b")
       //请求超时时间（单位为秒）：默认15s
       .setConnectTimeout(30)
        //文件分片上传时每片的大小（单位字节），默认512*1024
       .setUploadBlockSize(1024*1024)
        //文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
        Bmob.initialize(config);*/

        if (!isNetworkAvailable(MainActivity.this)) {
            Toast.makeText(getApplicationContext(), "当前网络不可用" + "\n" + "请检查设置", Toast.LENGTH_LONG).show();
        }

        inteData();

        showFragment(0);
        intePop();


        rg_home.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_homePage:
                        showFragment(0);
                        searchView.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.GONE);
                        break;
                    case R.id.rb_foundPage:
                        showFragment(1);
                        searchView.setVisibility(View.GONE);
                        linearLayout.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_messagePage:
                        showFragment(2);
                        break;
                    case R.id.rb_minePage:
                        showFragment(3);
                        break;
                }
            }
        });
    }

    private void showFragment(int i) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        hideAllFragment(transaction);
        switch (i) {
            case 0:
                if (fragmentHome == null) {
                    fragmentHome = new FragmentHome();
                    transaction.add(R.id.fg_homePage, fragmentHome);
                } else {
                    transaction.show(fragmentHome);
                }
                break;
            case 1:
                if (fragmentFind == null) {
                    fragmentFind = new FragmentFind();
                    transaction.add(R.id.fg_homePage, fragmentFind);
                } else {
                    transaction.show(fragmentFind);
                }
                break;
            case 2:

                if (fragmentNews == null) {
                    fragmentNews = new FragmentNews();
                    transaction.add(R.id.fg_homePage, fragmentNews);
                } else {
                    transaction.show(fragmentNews);
                }

                break;
            case 3:
                if (fragmentMine == null) {
                    fragmentMine = new FragmentMine();
                    transaction.add(R.id.fg_homePage, fragmentMine);
                } else {
                    transaction.show(fragmentMine);
                }
                break;
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (fragmentHome != null) {
            transaction.hide(fragmentHome);
        }
        if (fragmentFind != null) {
            transaction.hide(fragmentFind);
        }
        if (fragmentNews != null) {
            transaction.hide(fragmentNews);
        }
        if (fragmentMine != null) {
            transaction.hide(fragmentMine);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public boolean isNetworkAvailable(Activity activity) {
        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 获取NetworkInfo对象
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0) {
                for (int i = 0; i < networkInfo.length; i++) {
                    System.out.println(i + "===状态===" + networkInfo[i].getState());
                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /*   @Override
       protected void onDestroy() {
           super.onDestroy();
           //清空缓存
           File[] files = cache.listFiles();
           for(File file :files){
               file.delete();
           }
           cache.delete();
       }*/
    public void inteData() {
        linearLayout = (LinearLayout) findViewById(R.id.ll_title_find);
        findmenu = (ImageButton) findViewById(R.id.ib_find_menu);
        searchView = (SearchView) findViewById(R.id.sv_search_main);
        rg_home = (RadioGroup) findViewById(R.id.rg_all);
        rb_home = (RadioButton) findViewById(R.id.rb_homePage);




        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    public void intePop() {
        LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      /*  View view=inflater.inflate(R.layout.find_frag,null);*/
        popupWindow = new PopupWindow();
        View v = inflater.inflate(R.layout.findmenu_layout, null);
        popupWindow.setContentView(v);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
  /*      view.setFocusableInTouchMode(true);
        view.setFocusable(true);*/
        popupWindow.setAnimationStyle(R.style.Popwindow);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOnDismissListener(new PoponDismissListener());


        hot = (TextView) v.findViewById(R.id.tv_latest);
        plane = (TextView) v.findViewById(R.id.tv_plane);
        modeling = (TextView) v.findViewById(R.id.tv_modelling);
        manfashion = (TextView) v.findViewById(R.id.tv_manfashion);
        inset = (TextView) v.findViewById(R.id.tv_inset);
        home = (TextView) v.findViewById(R.id.tv_home);
        wedding = (TextView) v.findViewById(tv_wedding);
        food = (TextView) v.findViewById(R.id.tv_food);
        travel = (TextView) v.findViewById(tv_travel);
        pet = (TextView) v.findViewById(tv_pet);
        beauty = (TextView) v.findViewById(R.id.tv_beauty);
        present = (TextView) v.findViewById(tv_present);
        constructiondesign = (TextView) v.findViewById(R.id.tv_constructiondesign);
        humanityart = (TextView) v.findViewById(tv_humanityart);
        movie_book = (TextView) v.findViewById(tv_movie_book);
        Encyclopedias = (TextView) v.findViewById(R.id.tv_Encyclopedias);


        hot.setOnClickListener(this);
        plane.setOnClickListener(this);
        modeling.setOnClickListener(this);
        manfashion.setOnClickListener(this);
        inset.setOnClickListener(this);
        home.setOnClickListener(this);
        wedding.setOnClickListener(this);
        food.setOnClickListener(this);
        travel.setOnClickListener(this);
        pet.setOnClickListener(this);
        beauty.setOnClickListener(this);
        present.setOnClickListener(this);
        constructiondesign.setOnClickListener(this);
        humanityart.setOnClickListener(this);
        movie_book.setOnClickListener(this);
        Encyclopedias.setOnClickListener(this);

        findmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundAlpha(0.3f);

                popupWindow.showAtLocation(findmenu, Gravity.CENTER, 0, 0);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_latest:
                Toast.makeText(MainActivity.this, "SS", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, IdSetupActivity.class);
                startActivity(intent);
                popupWindow.dismiss();
                break;
            case R.id.tv_plane:
                sendKey("design", plane.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_modelling:
                sendKey("modeling_hair", modeling.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_manfashion:
                sendKey("men", manfashion.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_inset:
                sendKey("illustration", inset.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_home:
                sendKey("home", home.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_wedding:
                sendKey("wedding_events", wedding.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_food:
                sendKey("food_drink", food.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_travel:
                sendKey("travel_places", travel.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_pet:
                sendKey("pets", pet.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_beauty:
                sendKey("beauty", beauty.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_present:
                sendKey("desire", present.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_constructiondesign:
                sendKey("architecture", constructiondesign.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_humanityart:
                sendKey("art", humanityart.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_movie_book:
                sendKey("film_music_books", movie_book.getText().toString());
                popupWindow.dismiss();
                break;
            case R.id.tv_Encyclopedias:
                sendKey("tips", Encyclopedias.getText().toString());
                popupWindow.dismiss();
                break;
        }
    }

    protected void sendKey(String url, String title) {

        Intent intent = new Intent(MainActivity.this, TitleListActivity.class);
        intent.putExtra("choice", url);
        intent.putExtra("title", title);
        startActivity(intent);

    }


    private class PoponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
        }
    }

    private void backgroundAlpha(float v) {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = v;
        this.getWindow().setAttributes(lp);
    }

}
