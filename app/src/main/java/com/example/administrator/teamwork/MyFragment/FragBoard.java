package com.example.administrator.teamwork.MyFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.teamwork.MyAdapter.ImgListAdapter;
import com.example.administrator.teamwork.MyInfo.InterBoardInfo;
import com.example.administrator.teamwork.MyInfo.LocalShareInfo;
import com.example.administrator.teamwork.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by anzhuo on 2016/9/30.
 */
public class FragBoard extends Fragment {
    private static final int MSG = 1;
    String getUrl;

    InterBoardInfo interBoardInfo;
    ImgListAdapter prettyGirlAdapter;
    List<LocalShareInfo> mList = new ArrayList<>();
    LocalShareInfo localPrettyGirlInfo;

    public static final String HTTP = "http://img.hb.aicdn.com/";
    SwipeRefreshLayout demo_swiperefreshlayout;

    RecyclerView recyclerView;
    OkHttpClient okHttpClient;
    String str;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            switch (msg.what) {
                case MSG:
                    mList.clear();
                    getJsonData(str);
                    if (prettyGirlAdapter == null) {
                        prettyGirlAdapter = new ImgListAdapter(mList, FragBoard.this.getActivity(),3);
                    } else {
                        prettyGirlAdapter.onDataChange(mList);
                    }
                 /*   prettyGirlAdapter.setClickListener(new ImgListAdapter.MyClickListener() {
                        @Override
                        public void onThisItemClick(int position) {

                        }
                        @Override
                        public void onImageContentClick(int position) {
                            Intent intent = new Intent(FragBoard.this.getActivity(), ContentActivity.class);
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
                           *//* intent.putExtra("follow_count", "关注:" + mList.get(position).getFollow_count());*//*
                            intent.putExtra("boardImg", mList.get(position).getBoardImg());
                            intent.putExtra("imgWidth", mList.get(position).getImgWidth());
                            intent.putExtra("imgHeight", mList.get(position).getImgHeight());

                            startActivity(intent);

                            Toast.makeText(FragBoard.this.getActivity(), "这是图片内容" + mList.get(position).getUsername(), Toast.LENGTH_SHORT).show();


                        }

                        @Override
                        public void onUserMsgClick(int position) {
                            Intent intent = new Intent();
                            intent.putExtra("username", mList.get(position).getUsername());
                            intent.putExtra("userHead", mList.get(position).getUserHead());
                            intent.putExtra("title", mList.get(position).getTitle());
                            Toast.makeText(FragBoard.this.getActivity(), "这是用户信息" + position, Toast.LENGTH_SHORT).show();
                        }
                    });*/
                    recyclerView.setAdapter(prettyGirlAdapter);
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                    demo_swiperefreshlayout.setRefreshing(false);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_board_list, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        recyclerView = (RecyclerView) view.findViewById(R.id.rv_board_search);


        Intent intent = getActivity().getIntent();
        getUrl = "http://api.huaban.com/search/boards/?q="+intent.getExtras().getString("title");
        goThread();
        inteData();
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
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
        demo_swiperefreshlayout = (SwipeRefreshLayout)FragBoard.this.getActivity().findViewById(R.id.demo_board_search);
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




    private List<LocalShareInfo> getJsonData(String str) {


        Gson gson = new Gson();
        interBoardInfo = gson.fromJson(str, InterBoardInfo.class);
        for (int i = 0; i < interBoardInfo.getBoards().toArray().length; i++) {
            localPrettyGirlInfo = new LocalShareInfo();
            localPrettyGirlInfo.setUsername(interBoardInfo.getBoards().get(i).getUser().getUsername());
            localPrettyGirlInfo.setTitle(interBoardInfo.getBoards().get(i).getTitle());
            localPrettyGirlInfo.setPin_count(interBoardInfo.getBoards().get(i).getPin_count() == 0 ? "0" : String.valueOf(interBoardInfo.getBoards().get(i).getPin_count()));
            localPrettyGirlInfo.setUserHead(HTTP + interBoardInfo.getBoards().get(i).getUser().getAvatar().getKey());
            localPrettyGirlInfo.setFollow_count(interBoardInfo.getBoards().get(i).getFollow_count() == 0 ? "0" : String.valueOf(interBoardInfo.getBoards().get(i).getFollow_count()));
            localPrettyGirlInfo.setBoardImg(HTTP+interBoardInfo.getBoards().get(i).getPins().get(0).getFile().getKey());
            mList.add(0, localPrettyGirlInfo);

        }
        return mList;
    }

    public void goThread() {
        new Thread() {
            @Override
            public void run() {
                requstUrl(getUrl);
                handler.sendEmptyMessage(MSG);
            }
        }.start();
    }

   /* public static String getDiffTime(long date) {
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
    }*/
}
