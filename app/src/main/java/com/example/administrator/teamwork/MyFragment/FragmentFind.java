package com.example.administrator.teamwork.MyFragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.ContentActivity;
import com.example.administrator.teamwork.InterestActivity;
import com.example.administrator.teamwork.MyAdapter.ImgListAdapter;
import com.example.administrator.teamwork.MyInfo.InterShareInfo;
import com.example.administrator.teamwork.MyInfo.LocalShareInfo;
import com.example.administrator.teamwork.PersonSetup.IdSetupActivity;
import com.example.administrator.teamwork.R;
import com.example.administrator.teamwork.TitleListActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.administrator.teamwork.R.id.tv_humanityart;
import static com.example.administrator.teamwork.R.id.tv_movie_book;
import static com.example.administrator.teamwork.R.id.tv_pet;
import static com.example.administrator.teamwork.R.id.tv_present;
import static com.example.administrator.teamwork.R.id.tv_travel;
import static com.example.administrator.teamwork.R.id.tv_wedding;

/**
 * Created by Administrator on 2016/9/12.
 */
public class FragmentFind extends Fragment implements View.OnClickListener{
    ImageButton findmenu;
    PopupWindow popupWindow;
    TextView hot,plane,modeling,manfashion, inset,home;
    TextView  wedding, food,travel, pet ,beauty;
    TextView present,  constructiondesign,humanityart,movie_book,Encyclopedias;




    private static final int MSG_V = 1;
    private static final int MSG_H=2;
    String getUrl_v = "http://api.huaban.com/all/?limit=20";
    String getUrl_h = "http://api.huaban.com/";

    InterShareInfo interPrettyGirlInfo;
    ImgListAdapter prettyGirlAdapter;
    ImgListAdapter prettyGirlAdapter2;
    List<LocalShareInfo> mList = new ArrayList<>();
    List<LocalShareInfo> mList1 = new ArrayList<>();
    LocalShareInfo localPrettyGirlInfo;
    public static final String HTTP = "http://img.hb.aicdn.com/";
    StaggeredGridLayoutManager staggeredGridLayoutManager;
    SwipeRefreshLayout demo_swiperefreshlayout;


    RecyclerView mRecyclerViewH;
    RecyclerView mRecyclerViewV;
    OkHttpClient okHttpClient;
    String str;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            switch (msg.what) {
                case MSG_V:

                    mList.clear();

                    getJsonData(str);
                    if (prettyGirlAdapter == null) {
                        prettyGirlAdapter = new ImgListAdapter(mList, FragmentFind.this.getActivity(),1);
                    } else {
                        prettyGirlAdapter.onDataChange(mList);
                    }
                    prettyGirlAdapter.setClickListener(new ImgListAdapter.MyClickListener() {
                        @Override
                        public void onThisItemClick(int position) {

                        }
                        @Override
                        public void onImageContentClick(int position) {
                            Intent intent = new Intent(FragmentFind.this.getActivity(), ContentActivity.class);
                            intent.putExtra("contentImg", mList.get(position).getContentImg());
                            intent.putExtra("username", mList.get(position).getUsername());
                            intent.putExtra("title", mList.get(position).getTitle());
                            intent.putExtra("raw_text", mList.get(position).getRaw_text());
                            intent.putExtra("userHead", mList.get(position).getUserHead());
                            intent.putExtra("created_at", mList.get(position).getCreated_at());
                            intent.putExtra("from", mList.get(position).getSource());
                            intent.putExtra("comment_count", mList.get(position).getComment_count());
                            intent.putExtra("like_count", mList.get(position).getLike_count());
                            intent.putExtra("repin_count", mList.get(position).getRepin_count());
                           /* intent.putExtra("follow_count", "关注:" + mList.get(position).getFollow_count());*/
                            intent.putExtra("boardImg", mList.get(position).getBoardImg());
                            intent.putExtra("imgWidth", mList.get(position).getImgWidth());
                            intent.putExtra("imgHeight", mList.get(position).getImgHeight());

                            startActivity(intent);

                            Toast.makeText(FragmentFind.this.getActivity(), "这是图片内容" + mList.get(position).getUsername(), Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onUserMsgClick(int position) {
                            Intent intent = new Intent();
                            intent.putExtra("username", mList.get(position).getUsername());
                            intent.putExtra("userHead", mList.get(position).getUserHead());
                            intent.putExtra("title", mList.get(position).getTitle());
                            Toast.makeText(FragmentFind.this.getActivity(), "这是用户信息" + position, Toast.LENGTH_SHORT).show();
                        }
                    });




                    mRecyclerViewV.setAdapter(prettyGirlAdapter);
                    mRecyclerViewV.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                    demo_swiperefreshlayout.setRefreshing(false);

                    break;
                case MSG_H:
                    mList1.clear();
                    getList1(str);
                    prettyGirlAdapter2 = new ImgListAdapter(mList1,FragmentFind.this.getActivity(),2);
                    prettyGirlAdapter2.setClickListener(new ImgListAdapter.MyClickListener() {
                        @Override
                        public void onThisItemClick(int position) {
                            Intent intent = new Intent(FragmentFind.this.getActivity(), InterestActivity.class);
                            intent.putExtra("title",mList1.get(position).getCoverTitle());
                            intent.putExtra("intro",mList1.get(position).getCoverIntro());
                            Toast.makeText(FragmentFind.this.getActivity(), "横向列表之"+position, Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }

                        @Override
                        public void onImageContentClick(int position) {

                        }

                        @Override
                        public void onUserMsgClick(int position) {

                        }
                    });
                    mRecyclerViewH.setAdapter(prettyGirlAdapter2);
                    mRecyclerViewH.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
                    break;
            }
            super.handleMessage(msg);
        }
    };










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
        View v= LayoutInflater.from(FragmentFind.this.getActivity()).inflate(R.layout.findmenu_layout,null);
        popupWindow.setContentView(v);
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.Popwindow);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.setOnDismissListener(new PoponDismissListener());

        hot= (TextView) v.findViewById(R.id.tv_latest);
        plane= (TextView) v.findViewById(R.id.tv_plane);
        modeling = (TextView)v. findViewById(R.id.tv_modelling);
        manfashion= (TextView) v.findViewById(R.id.tv_manfashion);
        inset = (TextView)v. findViewById(R.id.tv_inset);
        home= (TextView) v.findViewById(R.id.tv_home);
        wedding= (TextView) v.findViewById(tv_wedding);
        food= (TextView) v.findViewById(R.id.tv_food);
        travel= (TextView) v.findViewById(tv_travel);
        pet= (TextView) v.findViewById(tv_pet);
        beauty= (TextView) v.findViewById(R.id.tv_beauty);
        present= (TextView) v.findViewById(tv_present);
        constructiondesign= (TextView) v.findViewById(R.id.tv_constructiondesign);
        humanityart= (TextView) v.findViewById(tv_humanityart);
        movie_book= (TextView) v.findViewById(tv_movie_book);
        Encyclopedias= (TextView) v.findViewById(R.id.tv_Encyclopedias);






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
            public void onClick( View v) {
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

        mRecyclerViewH = (RecyclerView) view.findViewById(R.id.rv_horizon_onFind);
        mRecyclerViewV= (RecyclerView) view.findViewById(R.id.rv_vertical_onFind);



        goThread();
        inteData();
        mRecyclerViewV.setOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int[] lastVisiblePositions = manager.findLastVisibleItemPositions(new int[manager.getSpanCount()]);
                    int lastVisiblePosition = getMaxElem(lastVisiblePositions);
                    int totalItemCount = manager.getItemCount();
                    if (lastVisiblePosition == (totalItemCount - 1) && isSlidingToLast) {

                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    isSlidingToLast = true;
                } else {
                    isSlidingToLast = false;
                }

            }
        });
    }

    private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    private String requstUrl(String s) {
        okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(s).build();

        try {
            Response response = okHttpClient.newCall(request).execute();
            str = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public void inteData() {
        demo_swiperefreshlayout = (SwipeRefreshLayout)FragmentFind.this.getActivity().findViewById(R.id.demo_title_onFind);
        //设置刷新时动画的颜色，可以设置4个
        demo_swiperefreshlayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        demo_swiperefreshlayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        demo_swiperefreshlayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        //SRL 下拉刷新
        demo_swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                demo_swiperefreshlayout.setRefreshing(true);
                goThread();
            }
        });
    }


    private List<LocalShareInfo> getList1(String str) {

        Log.i("str", "一大波数据已经更新");
        Gson gson = new Gson();
        interPrettyGirlInfo = gson.fromJson(str, InterShareInfo.class);

        for (int i = 0; i < interPrettyGirlInfo.getExplores().toArray().length; i++) {
            localPrettyGirlInfo = new LocalShareInfo();
            localPrettyGirlInfo.setCoverTitle(interPrettyGirlInfo.getExplores().get(i).getName());
            localPrettyGirlInfo.setCoverImg(HTTP+interPrettyGirlInfo.getExplores().get(i).getCover().getKey());
            localPrettyGirlInfo.setCoverIntro(interPrettyGirlInfo.getExplores().get(i).getDescription());
            mList1.add(localPrettyGirlInfo);


        }

        return mList1;


    }

    private List<LocalShareInfo> getJsonData(String str) {


        Gson gson = new Gson();
        interPrettyGirlInfo = gson.fromJson(str, InterShareInfo.class);
        for (int i = 0; i < interPrettyGirlInfo.getPins().toArray().length; i++) {
            localPrettyGirlInfo = new LocalShareInfo();
            localPrettyGirlInfo.setUsername(interPrettyGirlInfo.getPins().get(i).getUser().getUsername());
            localPrettyGirlInfo.setTitle(interPrettyGirlInfo.getPins().get(i).getBoard().getTitle());
            localPrettyGirlInfo.setRaw_text(interPrettyGirlInfo.getPins().get(i).getRaw_text() == null ? "" : interPrettyGirlInfo.getPins().get(i).getRaw_text());

            localPrettyGirlInfo.setUserHead(HTTP + interPrettyGirlInfo.getPins().get(i).getUser().getAvatar().getKey());
            localPrettyGirlInfo.setContentImg(HTTP + interPrettyGirlInfo.getPins().get(i).getFile().getKey());
            localPrettyGirlInfo.setCreated_at(getDiffTime(interPrettyGirlInfo.getPins().get(i).getCreated_at()));
            localPrettyGirlInfo.setSource(interPrettyGirlInfo.getPins().get(i).getSource() == null ? "" : interPrettyGirlInfo.getPins().get(i).getSource().toString());
            localPrettyGirlInfo.setComment_count(interPrettyGirlInfo.getPins().get(i).getComment_count() == 0 ? "0" : String.valueOf(interPrettyGirlInfo.getPins().get(i).getComment_count()));
            localPrettyGirlInfo.setLike_count(interPrettyGirlInfo.getPins().get(i).getLike_count() == 0 ? "0" : String.valueOf(interPrettyGirlInfo.getPins().get(i).getLike_count()));
            localPrettyGirlInfo.setRepin_count(interPrettyGirlInfo.getPins().get(i).getRepin_count() == 0 ? "0" : String.valueOf(interPrettyGirlInfo.getPins().get(i).getRepin_count()));
            localPrettyGirlInfo.setFollow_count(interPrettyGirlInfo.getPins().get(i).getBoard().getFollow_count() == 0 ? "0" : String.valueOf(interPrettyGirlInfo.getPins().get(i).getBoard().getFollow_count()));
            localPrettyGirlInfo.setBoardImg(HTTP + interPrettyGirlInfo.getPins().get(i).getFile().getKey());
            localPrettyGirlInfo.setImgWidth(interPrettyGirlInfo.getPins().get(i).getFile().getWidth());
            localPrettyGirlInfo.setImgHeight(interPrettyGirlInfo.getPins().get(i).getFile().getHeight());
            mList.add(0, localPrettyGirlInfo);

        }
        return mList;
    }

    public void goThread() {
        new Thread() {
            @Override
            public void run() {
                requstUrl(getUrl_v);
                handler.sendEmptyMessage(MSG_V);
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                requstUrl(getUrl_h);
                handler.sendEmptyMessage(MSG_H);
            }
        }.start();

    }

    public static String getDiffTime(long date) {
        String strTime = "很久很久以前";
        long time = Math.abs((new Date().getTime()) - date * 1000);
        // 一分钟以内
        if (time < 60 * 1000) {
            int s = (int) (time / 1000);
            strTime = s + "秒前";
        } else {
            int min = (int) (time / (60 * 1000));
            if (min < 60) {
                strTime = min + "分钟前";
            } else {
                int hh = min / 60;
                if (hh < 24) {
                    strTime = hh + "小时前";
                } else {
                    int days = hh / 24;
                    if (days <= 30) {
                        strTime = days + "天前";
                    } else {
                        int months = days / 30;
                        if (months < 12) {
                            strTime = months + "个月前";
                        } else {
                            int years = months / 12;
                            strTime = years + "年前";
                        }
                    }
                }
            }
        }
        return strTime;
    }


    private void backgroundAlpha(float v) {
        WindowManager.LayoutParams lp=this.getActivity().getWindow().getAttributes();
        lp.alpha=v;
        this .getActivity().getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.tv_latest:
                   Toast.makeText(FragmentFind.this.getActivity(), "SS", Toast.LENGTH_SHORT).show();
                   Intent intent=new Intent(FragmentFind.this.getActivity(), IdSetupActivity.class);
                   startActivity(intent);
                   popupWindow.dismiss();
                   break;
               case R.id.tv_plane:
                   sendUrl("http://api.huaban.com/favorite/design?limit=20",plane.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_modelling:
                   sendUrl("http://api.huaban.com/favorite/modeling_hair?limit=20",modeling.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_manfashion:
                   sendUrl("http://api.huaban.com/favorite/men?limit=20",manfashion.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_inset:
                   sendUrl("http://api.huaban.com/favorite/illustration?limit=20",inset.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_home:
                   sendUrl("http://api.huaban.com/favorite/home?limit=20",home.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_wedding:
                   sendUrl("http://api.huaban.com/favorite/wedding_events?limit=20",wedding.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_food:
                   sendUrl("http://api.huaban.com/favorite/food_drink?limit=20",food.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_travel:
                   sendUrl("http://api.huaban.com/favorite/travel_places?limit=20",travel.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_pet:
                   sendUrl("http://api.huaban.com/favorite/pets?limit=20",pet.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_beauty:
                   sendUrl("http://api.huaban.com/favorite/beauty?limit=20",beauty.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_present:
                   sendUrl("http://api.huaban.com/favorite/desire?limit=20",present.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_constructiondesign:
                   sendUrl("http://api.huaban.com/favorite/architecture?limit=20",constructiondesign.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_humanityart:
                   sendUrl("http://api.huaban.com/favorite/art?limit=20",humanityart.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_movie_book:
                   sendUrl("http://api.huaban.com/favorite/film_music_books?limit=20",movie_book.getText().toString());
                   popupWindow.dismiss();
                   break;
               case R.id.tv_Encyclopedias:
                   sendUrl("http://api.huaban.com/favorite/tips?limit=20",Encyclopedias.getText().toString());
                   popupWindow.dismiss();
                   break;
           }
    }

    protected void sendUrl(String url,String title){

        Intent intent = new Intent(FragmentFind.this.getActivity(), TitleListActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("title",title);
        startActivity(intent);

    }


    private class PoponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
        }
    }


}
