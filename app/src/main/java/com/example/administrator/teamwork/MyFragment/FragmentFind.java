package com.example.administrator.teamwork.MyFragment;

import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.PersonSetup.IdSetupActivity;
import com.example.administrator.teamwork.R;
import com.example.administrator.teamwork.TitleListActivity;

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
