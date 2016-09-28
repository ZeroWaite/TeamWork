package com.example.administrator.teamwork.MyFragment;

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
import android.widget.TextView;

import com.example.administrator.teamwork.R;

import static com.example.administrator.teamwork.R.id.tv_humanityart;
import static com.example.administrator.teamwork.R.id.tv_latestread;
import static com.example.administrator.teamwork.R.id.tv_movie_book;
import static com.example.administrator.teamwork.R.id.tv_other;
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
    TextView newly,latestlooking,plane,modeling,manfashion,other,uiux,inset,home,ladyclothes;
    TextView  wedding,industrydesign,shoot,food,travel,handwork,dance,children,pet,prettypicture,star,beauty;
    TextView present,geek,anime,constructiondesign,humanityart,databasephoto,game,car,movie_book,Encyclopedias,teaching,athelete,funny;
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

        newly= (TextView) v.findViewById(R.id.tv_latest);
        latestlooking= (TextView) v.findViewById(tv_latestread);
        plane= (TextView) v.findViewById(R.id.tv_plane);
        modeling = (TextView)v. findViewById(R.id.tv_modelling);
        manfashion= (TextView) v.findViewById(R.id.tv_manfashion);
        other= (TextView) v.findViewById(tv_other);
        uiux= (TextView) v.findViewById(R.id.tv_uiux);
        inset = (TextView)v. findViewById(R.id.tv_inset);
        home= (TextView) v.findViewById(R.id.tv_home);
        wedding= (TextView) v.findViewById(tv_wedding);
        industrydesign= (TextView) v.findViewById(R.id.tv_industrydesign);
        shoot = (TextView)v. findViewById(R.id.tv_shoot);
        food= (TextView) v.findViewById(R.id.tv_food);
        travel= (TextView) v.findViewById(tv_travel);
        handwork= (TextView) v.findViewById(R.id.tv_handwork);
        dance = (TextView)v. findViewById(R.id.tv_dance);
        children= (TextView) v.findViewById(R.id.tv_children);
        pet= (TextView) v.findViewById(tv_pet);
        prettypicture= (TextView) v.findViewById(R.id.tv_prettypicture);
        star = (TextView)v. findViewById(R.id.tv_star);
        beauty= (TextView) v.findViewById(R.id.tv_beauty);
        ladyclothes= (TextView) v.findViewById(R.id.tv_ladyclothes);
        present= (TextView) v.findViewById(tv_present);
        geek= (TextView) v.findViewById(R.id.tv_geek);
        anime = (TextView)v. findViewById(R.id.tv_anime);
        constructiondesign= (TextView) v.findViewById(R.id.tv_constructiondesign);
        humanityart= (TextView) v.findViewById(tv_humanityart);
        databasephoto= (TextView) v.findViewById(R.id.tv_databasephoto);
        game = (TextView)v. findViewById(R.id.tv_game);
        car= (TextView) v.findViewById(R.id.tv_car);
        movie_book= (TextView) v.findViewById(tv_movie_book);
        Encyclopedias= (TextView) v.findViewById(R.id.tv_Encyclopedias);
        teaching = (TextView)v. findViewById(R.id.tv_teaching);
        athelete= (TextView) v.findViewById(R.id.tv_athlete);
        funny = (TextView)v. findViewById(R.id.tv_funny);





        newly.setOnClickListener(this);
        latestlooking.setOnClickListener(this);
        plane.setOnClickListener(this);
        modeling.setOnClickListener(this);
        manfashion.setOnClickListener(this);
        other.setOnClickListener(this);
        uiux.setOnClickListener(this);
        inset.setOnClickListener(this);
        home.setOnClickListener(this);
        ladyclothes.setOnClickListener(this);
        wedding.setOnClickListener(this);
        industrydesign.setOnClickListener(this);
        shoot.setOnClickListener(this);
        food.setOnClickListener(this);
        travel.setOnClickListener(this);
        handwork.setOnClickListener(this);
        dance.setOnClickListener(this);
        children.setOnClickListener(this);
        pet.setOnClickListener(this);
        prettypicture.setOnClickListener(this);
        star.setOnClickListener(this);
        beauty.setOnClickListener(this);
        present.setOnClickListener(this);
        geek.setOnClickListener(this);
        anime.setOnClickListener(this);
        constructiondesign.setOnClickListener(this);
        humanityart.setOnClickListener(this);
        databasephoto.setOnClickListener(this);
        game.setOnClickListener(this);
        car.setOnClickListener(this);
        movie_book.setOnClickListener(this);
        Encyclopedias.setOnClickListener(this);
        teaching.setOnClickListener(this);
        athelete.setOnClickListener(this);
        funny.setOnClickListener(this);


        newly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.tv_latest:
                   break;
               case R.id.tv_latestread:

                   break;
               case R.id.tv_plane:

                   break;
               case R.id.tv_modelling:

                   break;
               case R.id.tv_manfashion:
                   break;
               case R.id.tv_other:
                   break;
               case R.id.tv_uiux:
                   break;
               case R.id.tv_inset:
                   break;
               case R.id.tv_wedding:
                   ;
                   break;
               case R.id.tv_industrydesign:

                   break;
               case R.id.tv_shoot:

                   break;
               case R.id.tv_travel:
                   break;
               case R.id.tv_handwork:
                   break;
               case R.id.tv_dance:
                   break;

               case R.id.tv_children:
                   break;
               case R.id.tv_pet:

                   break;
               case R.id.tv_prettypicture:

                   break;
               case R.id.tv_star:

                   break;
               case R.id.tv_beauty:
                   break;
               case R.id.tv_ladyclothes:
                   break;
               case R.id.tv_present:
                   break;
               case R.id.tv_geek:
                   break;
               case R.id.tv_anime:

                   break;
               case R.id.tv_constructiondesign:

                   break;
               case R.id.tv_humanityart:

                   break;
               case R.id.tv_databasephoto:
                   break;
               case R.id.tv_game:
                   break;

               case R.id.tv_car:
                   break;
               case R.id.tv_movie_book:
                   ;
                   break;
               case R.id.tv_Encyclopedias:

                   break;
               case R.id.tv_teaching:

                   break;
               case R.id.tv_athlete:
                   break;
               case R.id.tv_funny:
                   break;


           }
    }


    private class PoponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {

        }
    }
}
