package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by anzhuo on 2016/9/26.
 */
public class ContentActivity extends Activity {
    ImageView imageLager;
    TextView link;
    TextView username;
    TextView boardName;
    ImageView userHead;
    ImageView boardImg;
    TextView created_at;
    TextView raw_text;
    TextView collect;
    ImageView back;
    TextView transPond;
    TextView comment;
    EditText commenting;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_page_layout);
        imageLager = (ImageView) findViewById(R.id.iv_interImage_larger);
        userHead = (ImageView) findViewById(R.id.iv_userHead_onPage);
        boardName = (TextView) findViewById(R.id.tv_drawBoardName_onPage);
        username = (TextView) findViewById(R.id.tv_username_onPage);
        link = (TextView) findViewById(R.id.tv_from_onPage);
        created_at = (TextView) findViewById(R.id.tv_upDataTime_onPage);
        raw_text = (TextView) findViewById(R.id.tv_imageIntroduce_onPage);
        collect = (TextView) findViewById(R.id.tv_collect_onPage);
        transPond = (TextView) findViewById(R.id.tv_transPond_onPage);
        comment = (TextView) findViewById(R.id.tv_comment_onPage);
        commenting = (EditText) findViewById(R.id.et_addNewCommit_onPage);
        boardImg = (ImageView) findViewById(R.id.iv_drawBoardHead_onPage);
        back= (ImageView) findViewById(R.id.ib_back_onPage);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();

        String contentImg = intent.getExtras().getString("contentImg");
        String head = intent.getExtras().getString("userHead");
        String boardHead = intent.getExtras().getString("boardImg");


        Picasso.with(this).load(contentImg).placeholder(R.mipmap.ic_launcher).error(R.mipmap.lock).into(imageLager);
        userHead.setImageURI(Uri.parse(head));
        username.setText(intent.getExtras().getString("username"));
        boardName.setText(intent.getExtras().getString("title"));
        raw_text.setText(intent.getExtras().getString("raw_text"));
        created_at.setText(intent.getExtras().getString("created_at"));
        link.setText(intent.getExtras().getString("from"));
        transPond.setText(intent.getExtras().getString("comment_count"));
        collect.setText(intent.getExtras().getString("like_count"));
        comment.setText(intent.getExtras().getString("comment_count"));
        boardImg.setImageURI(Uri.parse(boardHead));


           /* intent.putExtra("follow_count",mList.get(position).getFollow_count());*/

    }
}
