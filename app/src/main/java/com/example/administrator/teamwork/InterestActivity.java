package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.MyAdapter.ImgListAdapter;
import com.example.administrator.teamwork.MyInfo.InterExploreInfo;
import com.example.administrator.teamwork.MyInfo.LocalShareInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by anzhuo on 2016/10/8.
 */
public class InterestActivity extends Activity {
    TextView title;
    TextView intro;
    ImageView back;

    String key;
    String total;

    private static final int MSG = 1;


    InterExploreInfo interPrettyGirlInfo;
    ImgListAdapter prettyGirlAdapter;
    ImgListAdapter prettyGirlAdapter2;
    List<LocalShareInfo> mList = new ArrayList<>();
    List<LocalShareInfo> mList1 = new ArrayList<>();
    LocalShareInfo localPrettyGirlInfo;
    public static final String HTTP = "http://img.hb.aicdn.com/";
    SwipeRefreshLayout demo_swiperefreshlayout;


    RecyclerView mRecyclerViewH;
    RecyclerView mRecyclerViewV;
    OkHttpClient okHttpClient;
    String str;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            switch (msg.what) {
                case MSG:
                    mList1.clear();
                    mList.clear();

                    getList1(str);
                    getJsonData(str);
                    if (prettyGirlAdapter == null) {
                        prettyGirlAdapter = new ImgListAdapter(mList, InterestActivity.this, 1);
                    } else {
                        prettyGirlAdapter.onDataChange(mList);
                    }
                    prettyGirlAdapter.setClickListener(new ImgListAdapter.MyClickListener() {
                        @Override
                        public void onThisItemClick(int position) {

                        }

                        @Override
                        public void onImageContentClick(int position) {
                            Intent intent = new Intent(InterestActivity.this, ContentActivity.class);
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
                            intent.putExtra("userID",mList.get(position).getUserID());
                            intent.putExtra("userurlname",mList.get(position).getUserUrlName());


                            startActivity(intent);

                            Toast.makeText(InterestActivity.this, "这是图片内容" + mList.get(position).getUsername(), Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onUserMsgClick(int position) {
                            Intent intent = new Intent();
                            intent.putExtra("username", mList.get(position).getUsername());
                            intent.putExtra("userHead", mList.get(position).getUserHead());
                            intent.putExtra("title", mList.get(position).getTitle());
                            Toast.makeText(InterestActivity.this, "这是用户信息" + position, Toast.LENGTH_SHORT).show();
                        }
                    });

                    prettyGirlAdapter2 = new ImgListAdapter(mList1,InterestActivity.this,2);
                    prettyGirlAdapter2.setClickListener(new ImgListAdapter.MyClickListener() {
                        @Override
                        public void onThisItemClick(int position) {
                            Intent intent = new Intent(InterestActivity.this, InterestActivity.class);
                            intent.putExtra("title",mList1.get(position).getCoverTitle());
                            intent.putExtra("urlName",mList1.get(position).getCoverUrlName());
                            intent.putExtra("intro",mList1.get(position).getCoverIntro());
                            Toast.makeText(InterestActivity.this, "横向列表之"+position, Toast.LENGTH_SHORT).show();
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


                    mRecyclerViewV.setAdapter(prettyGirlAdapter);
                    mRecyclerViewV.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                    demo_swiperefreshlayout.setRefreshing(false);
                    intro.setText(mList1.get(0).getBoardIntro());
                    break;
            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_layout);
        title = (TextView) findViewById(R.id.tv_title_interest);
        intro = (TextView) findViewById(R.id.tv_intro_interest);
        back = (ImageView) findViewById(R.id.ib_back_interest);
        Intent intent = getIntent();

        key = intent.getExtras().getString("urlName");
        total = "http://api.huaban.com/explore/" + key;
        title.setText(intent.getExtras().getString("title"));



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mRecyclerViewH = (RecyclerView) findViewById(R.id.rv_horizon_interest);
        mRecyclerViewV = (RecyclerView) findViewById(R.id.rv_vertical_interest);


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
        demo_swiperefreshlayout = (SwipeRefreshLayout) InterestActivity.this.findViewById(R.id.demo_title_interest);
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
        interPrettyGirlInfo = gson.fromJson(str, InterExploreInfo.class);

        for (int i = 0; i < interPrettyGirlInfo.getExplores().toArray().length; i++) {
            localPrettyGirlInfo = new LocalShareInfo();
            localPrettyGirlInfo.setCoverUrlName(interPrettyGirlInfo.getExplores().get(i).getUrlname());
            localPrettyGirlInfo.setBoardIntro(interPrettyGirlInfo.getDescription());
            localPrettyGirlInfo.setCoverTitle(interPrettyGirlInfo.getExplores().get(i).getName());
            localPrettyGirlInfo.setCoverImg(HTTP+interPrettyGirlInfo.getExplores().get(i).getCover().getKey());
            localPrettyGirlInfo.setCoverIntro(interPrettyGirlInfo.getExplores().get(i).getDescription());
            mList1.add(localPrettyGirlInfo);
        }

        return mList1;


    }

    private List<LocalShareInfo> getJsonData(String str) {


        Gson gson = new Gson();
        interPrettyGirlInfo = gson.fromJson(str, InterExploreInfo.class);
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
            localPrettyGirlInfo.setImgWidth(String.valueOf(interPrettyGirlInfo.getPins().get(i).getFile().getWidth()));
            localPrettyGirlInfo.setImgHeight(String.valueOf(interPrettyGirlInfo.getPins().get(i).getFile().getHeight()));
            localPrettyGirlInfo.setUserUrlName(interPrettyGirlInfo.getPins().get(i).getUser().getUrlname());
            localPrettyGirlInfo.setUserID(String.valueOf(interPrettyGirlInfo.getPins().get(i).getUser_id()));
            mList.add(0, localPrettyGirlInfo);

        }
        return mList;
    }

    public void goThread() {
        new Thread() {
            @Override
            public void run() {
                requstUrl(total);
                handler.sendEmptyMessage(MSG);
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
}
