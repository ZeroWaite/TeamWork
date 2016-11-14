package com.example.administrator.teamwork.Search;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.MyAdapter.ImgListAdapter;
import com.example.administrator.teamwork.MyFragment.FragmentHome;
import com.example.administrator.teamwork.MyInfo.InterSearchInfo;
import com.example.administrator.teamwork.MyInfo.LocalShareInfo;
import com.example.administrator.teamwork.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by anzhuo on 2016/11/10.
 */

public class SearchResultActivity extends AppCompatActivity{
    FrameLayout frameLayout;
    FragmentHome fragment;
    FragmentHome oldFragment;

    FragmentTransaction transaction;
    FragmentManager manager;

    ImageView back;
    TextView title;
    ImageView menu;
    RecyclerView rv_hor;
    String str;
    String keyWord;
    String send;
    InterSearchInfo interSearchInfo;
    ImgListAdapter imgListAdapter;

    List<LocalShareInfo> mList = new ArrayList<>();

    OkHttpClient okHttpClient;
    private static final int MSG_H = 1;
    private static final int MSG_V = 2;
   private static final  String SEARCH_HTTP="http://api.huaban.com/search/?q=";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_H:
                    mList.clear();
                    getJsonData(str);
                    Log.i("got",mList.get(3).getSearchTitle()+"");
                        imgListAdapter = new ImgListAdapter(mList, SearchResultActivity.this,5);
                    imgListAdapter.setClickListener(new ImgListAdapter.MyClickListener() {
                        @Override
                        public void onThisItemClick(int position) {
                            showFragment(position);
                            Toast.makeText(SearchResultActivity.this, "横向列表之"+position, Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onImageContentClick(int position) {
                        }
                        @Override
                        public void onUserMsgClick(int position) {
                        }
                    });
                    rv_hor.setAdapter(imgListAdapter);
                   rv_hor.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
                    break;
                case MSG_V:

                break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result_layout);
        frameLayout = (FrameLayout) findViewById(R.id.fl_result);
        back = (ImageView) findViewById(R.id.iv_back_result);
        title = (TextView) findViewById(R.id.tv_title_result);
        menu = (ImageView) findViewById(R.id.ib_menu_result);
        rv_hor = (RecyclerView) findViewById(R.id.rv_horizon_result);
        Intent intent = getIntent();
         keyWord =intent.getExtras().getString("keyWord");
        goThread();
        showFragment(0);
    }
    private void showFragment(int i) {

        manager = SearchResultActivity.this.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        hideAll(transaction);
        oldFragment = (FragmentHome) manager.findFragmentById(R.id.fl_result);
        if (oldFragment!=null){
            transaction.remove(oldFragment);
        }
            fragment = new FragmentHome();
        Bundle args = new Bundle();
        if (i!=0){
            send = "search/?q="+keyWord+"&category="+mList.get(i).getSearchKey();
        }else {
            send ="search/?q="+keyWord;
        }
        args.putString("keyWord", send);
        fragment.setArguments(args);
        transaction.add(R.id.fl_result, fragment);
        transaction.commit();
    }
    private void hideAll(FragmentTransaction transaction) {
        if (fragment != null) {
            transaction.hide(fragment);
        }

    }

    private List<LocalShareInfo> getJsonData(String str) {


        Gson gson = new Gson();
       interSearchInfo  = gson.fromJson(str, InterSearchInfo.class);

        LocalShareInfo total = new LocalShareInfo();
        total.setSearchCount(String.valueOf(interSearchInfo.getFacets().getTotal()));
        total.setSearchTitle("全部");
        total.setSearchKey("");
        mList.add(total);

        LocalShareInfo web_app_icon= new LocalShareInfo();
       web_app_icon.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getWeb_app_icon()));
web_app_icon.setSearchTitle("UI/UX");
        web_app_icon.setSearchKey("web_app_icon");
        mList.add(web_app_icon);

        LocalShareInfo illustration = new LocalShareInfo();
        illustration.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getIllustration()));
        illustration.setSearchTitle("插画/漫画");
        illustration.setSearchKey("illustration");
        mList.add(illustration);


        LocalShareInfo food_drink = new LocalShareInfo();
        food_drink.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getFood_drink()));
        food_drink.setSearchTitle("美食");
        food_drink.setSearchKey("food_drink");
        mList.add(food_drink);


        LocalShareInfo travel_places = new LocalShareInfo();
        travel_places.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getTravel_places()));
        travel_places.setSearchTitle("旅行");
        travel_places.setSearchKey("travel_places");
        mList.add(travel_places);

        LocalShareInfo design = new LocalShareInfo();
        design.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getDesign()));
        design.setSearchTitle("平面");
        design.setSearchKey("design");
        mList.add(design);

        LocalShareInfo photography = new LocalShareInfo();
        photography.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getPhotography()));
        photography.setSearchTitle("摄影");
        photography.setSearchKey("photography");
        mList.add(photography);

        LocalShareInfo other= new LocalShareInfo();
        other.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getOther()));
        other.setSearchTitle("其他");
        other.setSearchKey("other");
        mList.add(other);

        LocalShareInfo home = new LocalShareInfo();
        home.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getHome()));
        home.setSearchTitle("家居/家装");
        home.setSearchKey("home");
        mList.add(home);

        LocalShareInfo apparel = new LocalShareInfo();
        apparel.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getApparel()));
       apparel.setSearchTitle("女装/搭配");
        apparel.setSearchKey("apparel");
        mList.add(apparel);

        LocalShareInfo diy_crafts = new LocalShareInfo();
        diy_crafts.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getDiy_crafts()));
        diy_crafts.setSearchTitle("手工/布艺");
        diy_crafts.setSearchKey("diy_crafts");
        mList.add(diy_crafts);

        LocalShareInfo tips = new LocalShareInfo();
        tips.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getTips()));
       tips.setSearchTitle("生活百科");
        tips.setSearchKey("tips");
        mList.add(tips);

        LocalShareInfo quotes = new LocalShareInfo();
        quotes.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getQuotes()));
        quotes.setSearchTitle("美图");
        quotes.setSearchKey("quotes");
        mList.add(quotes);

        LocalShareInfo architecture= new LocalShareInfo();
       architecture.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getArchitecture()));
       architecture.setSearchTitle("建筑设计");
        architecture.setSearchKey("architecture");
        mList.add(architecture);

        LocalShareInfo beauty = new LocalShareInfo();
        beauty.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getBeauty()));
        beauty.setSearchTitle("美女");
        mList.add(beauty);

        LocalShareInfo funny = new LocalShareInfo();
        funny.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getFunny()));
        funny.setSearchTitle("搞笑");
        funny.setSearchKey("funny");
        mList.add(funny);

        LocalShareInfo desire= new LocalShareInfo();
        desire.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getDesire()));
       desire.setSearchTitle("礼物");
        desire.setSearchKey("desire");
        mList.add(desire);

        LocalShareInfo wedding_events= new LocalShareInfo();
        wedding_events.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getWedding_events()));
        wedding_events.setSearchTitle("婚礼");
        wedding_events.setSearchKey("wedding_events");
        mList.add(wedding_events);

        LocalShareInfo industrial_design = new LocalShareInfo();
       industrial_design.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getIndustrial_design()));
        industrial_design.setSearchTitle("工业设计");
        industrial_design.setSearchKey("industrial_design");
        mList.add(industrial_design);

        LocalShareInfo anime = new LocalShareInfo();
       anime.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getAnime()));
      anime.setSearchTitle("动漫");
        anime.setSearchKey("anime");
        mList.add(anime);

        LocalShareInfo modeling_hair = new LocalShareInfo();
        modeling_hair.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getModeling_hair()));
        modeling_hair.setSearchTitle("造型/美妆");
        modeling_hair.setSearchKey("modeling_hair");
        mList.add(modeling_hair);

        LocalShareInfo film_music_books = new LocalShareInfo();
        film_music_books.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getFilm_music_books()));
        film_music_books.setSearchTitle("电影/图书");
        film_music_books.setSearchKey("film_music_books ");
        mList.add(film_music_books);

        LocalShareInfo art = new LocalShareInfo();
       art.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getArt()));
        art.setSearchTitle("人文艺术");
        art.setSearchKey("art");
        mList.add(art);

        LocalShareInfo people = new LocalShareInfo();
       people.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getPeople()));
        people.setSearchTitle("明星");
        people.setSearchKey("people");
        mList.add(people);

        LocalShareInfo games= new LocalShareInfo();
        games.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getGames()));
        games.setSearchTitle("游戏");
        games.setSearchKey("games");
        mList.add(games);

        LocalShareInfo pets = new LocalShareInfo();
        pets.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getPets()));
        pets.setSearchTitle("宠物");
        pets.setSearchKey("pets ");
        mList.add(pets);

        LocalShareInfo data_presentation = new LocalShareInfo();
        data_presentation.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getData_presentation()));
        data_presentation.setSearchTitle("数据图");
        data_presentation.setSearchKey("data_presentation");
        mList.add(data_presentation);

        LocalShareInfo cars_motorcycles = new LocalShareInfo();
        cars_motorcycles.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getCars_motorcycles()));
        cars_motorcycles.setSearchTitle("汽车/摩托");
        cars_motorcycles.setSearchKey("cars_motorcycles ");
        mList.add(cars_motorcycles);

        LocalShareInfo fitness = new LocalShareInfo();
        fitness.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getFitness()));
        fitness.setSearchTitle("健身/舞蹈");
        fitness.setSearchKey("fitness");
        mList.add(fitness);

        LocalShareInfo men = new LocalShareInfo();
        men.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getMen()));
        men.setSearchTitle("男士/风尚");
        mList.add(men);

        LocalShareInfo kids = new LocalShareInfo();
        kids.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getKids()));
        kids.setSearchTitle("儿童");
        kids.setSearchKey("kids");
        mList.add(kids);

        LocalShareInfo education = new LocalShareInfo();
        education.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getEducation()));
        education.setSearchTitle("教育");
        education.setSearchKey("education");
        mList.add(education);

        LocalShareInfo sports = new LocalShareInfo();
        sports.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getSports()));
        sports.setSearchTitle("运动");
        sports.setSearchKey("sports");
        mList.add(sports);

        LocalShareInfo geek= new LocalShareInfo();
        geek.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getGeek()));
        geek.setSearchTitle("极客");
        geek.setSearchKey("geek");
        mList.add(geek);

        LocalShareInfo digital = new LocalShareInfo();
        digital.setSearchCount(String.valueOf(interSearchInfo.getFacets().getResults().getDigital()));
        digital.setSearchTitle("3C数码");
        digital.setSearchKey("digital");
        mList.add(digital);
        //此处以条目总数大小排列集合
        Collections.sort(mList, new Comparator<LocalShareInfo >() {
            @Override
            public int compare(LocalShareInfo  user1, LocalShareInfo  user2) {
                Integer id1 = Integer.valueOf(user1.getSearchCount());
                Integer id2 = Integer.valueOf(user2.getSearchCount());
                //可以按User对象的其他属性排序，只要属性支持compareTo方法
                return id2.compareTo(id1);
            }
        });

        return mList;
    }

    public void goThread() {
        new Thread() {
            @Override
            public void run() {
                requstUrl(SEARCH_HTTP+keyWord);
                handler.sendEmptyMessage(MSG_H);
            }
        }.start();
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
}
