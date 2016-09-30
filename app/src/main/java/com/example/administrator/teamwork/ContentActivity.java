package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by anzhuo on 2016/9/26.
 */
public class ContentActivity extends Activity implements View.OnClickListener {

    SimpleDraweeView imageLager;
    TextView link;
    TextView username;
    TextView boardName;
    SimpleDraweeView userHead;
    SimpleDraweeView boardImg;
    TextView created_at;
    TextView raw_text;
    TextView collect;
    SimpleDraweeView image_blow;
    TextView transPond;
    TextView comment;
    EditText commenting;

    LinearLayout ll_user;
    LinearLayout ll_drawBarad;



    String contentImg;
    private float imgWidth;
    private float imgHeight;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_page_layout);
        imageLager = (SimpleDraweeView) findViewById(R.id.iv_interImage_larger);
        userHead = (SimpleDraweeView) findViewById(R.id.iv_userHead_onPage);
        boardName = (TextView) findViewById(R.id.tv_drawBoardName_onPage);
        username = (TextView) findViewById(R.id.tv_username_onPage);
        link = (TextView) findViewById(R.id.tv_from_onPage);
        created_at = (TextView) findViewById(R.id.tv_upDataTime_onPage);
        raw_text = (TextView) findViewById(R.id.tv_imageIntroduce_onPage);
        collect = (TextView) findViewById(R.id.tv_collect_onPage);
        transPond = (TextView) findViewById(R.id.tv_transPond_onPage);
        comment = (TextView) findViewById(R.id.tv_comment_onPage);
        commenting = (EditText) findViewById(R.id.et_addNewCommit_onPage);
        boardImg = (SimpleDraweeView) findViewById(R.id.iv_drawBoardHead_onPage);

        ll_user = (LinearLayout) findViewById(R.id.ll_userLayout_onPage);
        ll_drawBarad = (LinearLayout) findViewById(R.id.ll_drawBoardLayout_onPage);

        ll_user.setOnClickListener(this);
        ll_drawBarad.setOnClickListener(this);
        link.setOnClickListener(this);
        collect.setOnClickListener(this);
        comment.setOnClickListener(this);
        transPond.setOnClickListener(this);
        commenting.setOnClickListener(this);
        imageLager.setOnClickListener(this);

  /*  f*/
        Intent intent = getIntent();

         contentImg = intent.getExtras().getString("contentImg");
        String head = intent.getExtras().getString("userHead");
        String boardHead = intent.getExtras().getString("boardImg");
        imgWidth = Float.parseFloat(intent.getExtras().getString("imgWidth"));
        imgHeight = Float.parseFloat(intent.getExtras().getString("imgHeight"));

        imageLager.setImageURI(Uri.parse(contentImg));
        imageLager.setAspectRatio(imgWidth / imgHeight);

        userHead.setImageURI(Uri.parse(head));
        username.setText(intent.getExtras().getString("username"));
        boardName.setText(intent.getExtras().getString("title"));

        created_at.setText(intent.getExtras().getString("created_at"));
        if (intent.getExtras().getString("raw_text").equals("")) {
            raw_text.setVisibility(View.GONE);
        } else {
            raw_text.setVisibility(View.VISIBLE);
            raw_text.setText(intent.getExtras().getString("raw_text"));
        }

        if (intent.getExtras().getString("from").equals("")) {
            link.setVisibility(View.GONE);
        } else {
            link.setVisibility(View.VISIBLE);
            link.setText(intent.getExtras().getString("from"));
        }

        if (intent.getExtras().getString("repin_count").equals("0")) {
            transPond.setVisibility(View.GONE);
        } else {
            transPond.setVisibility(View.VISIBLE);
            transPond.setText("转发:" + intent.getExtras().getString("repin_count"));
        }
        if (intent.getExtras().getString("like_count").equals("0")) {
            collect.setVisibility(View.GONE);
        } else {
            collect.setVisibility(View.VISIBLE);
            collect.setText("收藏:" + intent.getExtras().getString("like_count"));
        }
        if (intent.getExtras().getString("comment_count").equals("0")) {
            comment.setVisibility(View.GONE);
        } else {
            comment.setVisibility(View.VISIBLE);
            comment.setText("评论:" + intent.getExtras().getString("comment_count"));
        }


        boardImg.setImageURI(Uri.parse(boardHead));


           /* intent.putExtra("follow_count",mList.get(position).getFollow_count());*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_interImage_larger:
                PopupWindow pop = new PopupWindow();
                View v = LayoutInflater.from(ContentActivity.this).inflate(R.layout.image_click_load, null);
                image_blow = (SimpleDraweeView) v.findViewById(R.id.iv_image_load);
                image_blow.setImageURI(contentImg);
                image_blow.setAspectRatio(imgWidth / imgHeight);


                pop.setContentView(v);
                pop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                pop.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                pop.setFocusable(true);
                pop.setTouchable(true);
                pop.setOutsideTouchable(true);

                pop.setAnimationStyle(R.style.Popwindow2);
                pop.setOnDismissListener(new PoponDismissListener());
                pop.showAtLocation(imageLager, Gravity.CENTER, 0, 0);
                backgroundAlpha(0.3f);
                break;
            case R.id.tv_from_onPage:
                break;
            case R.id.tv_transPond_onPage:
                Intent intent0 = new Intent(ContentActivity.this, TransPondActivity.class);
                startActivity(intent0);
                break;
            case R.id.tv_collect_onPage:
                Intent intent1 = new Intent(ContentActivity.this, CollectActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_comment_onPage:
                Intent intent2 = new Intent(ContentActivity.this, CommentActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_userLayout_onPage:
                break;
            case R.id.ll_drawBoardLayout_onPage:
                break;
            case R.id.et_addNewCommit_onPage:
                break;
        }
    }

    private class PoponDismissListener implements PopupWindow.OnDismissListener {
        @Override
        public void onDismiss() {
            backgroundAlpha(1f);
        }
    }

    private void backgroundAlpha(float v) {
        WindowManager.LayoutParams lp = this.getWindow().getAttributes();
        lp.alpha = v;
        this.getWindow().setAttributes(lp);
    }
}
