package com.example.administrator.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.teamwork.MyAdapter.MyDraweeView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
    MyDraweeView image_blow;
    TextView transPond;
    TextView comment;
    EditText commenting;
    LinearLayout ll_user;
    LinearLayout ll_drawBarad;
    ImageView gather;
    ImageView share;
    ImageView back;
    ImageView download;
  Bitmap bitmap;




    String choice;
    String userID;
    String contentImg;
    private float imgWidth;
    private float imgHeight;
    private File cache;

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
        gather= (ImageView) findViewById(R.id.ib_getNew_onPage);
        share= (ImageView) findViewById(R.id.ib_transPond_onPage);
        back= (ImageView) findViewById(R.id.ib_back_onPage);


        ll_user = (LinearLayout) findViewById(R.id.ll_userLayout_onPage);
        ll_drawBarad = (LinearLayout) findViewById(R.id.ll_drawBoardLayout_onPage);

        commenting.setOnClickListener(this);

        ll_user.setOnClickListener(this);
        ll_drawBarad.setOnClickListener(this);
        link.setOnClickListener(this);
        collect.setOnClickListener(this);
        comment.setOnClickListener(this);
        transPond.setOnClickListener(this);
        commenting.setOnClickListener(this);
        imageLager.setOnClickListener(this);
        gather.setOnClickListener(this);
        share.setOnClickListener(this);
        back.setOnClickListener(this);

  /*  f*/
        Intent intent = getIntent();

         contentImg = intent.getExtras().getString("contentImg");
        String head = intent.getExtras().getString("userHead");
        String boardHead = intent.getExtras().getString("boardImg");
        imgWidth = Float.parseFloat(intent.getExtras().getString("imgWidth"));
        imgHeight = Float.parseFloat(intent.getExtras().getString("imgHeight"));
        choice = intent.getExtras().getString("userurlname");

        userID = intent.getExtras().getString("userID");

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(contentImg)
                .setAutoPlayAnimations(true)

                .build();

        imageLager.setController(controller);
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
    /**
     * 获取网络图片
     * @param imageurl 图片网络地址
     * @return Bitmap 返回位图
     */
    public Bitmap GetImageInputStream(String imageurl){
        URL url;
        HttpURLConnection connection=null;
        Bitmap bitmap=null;
        try {
            url = new URL(imageurl);
            connection=(HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(6000); //超时设置
            connection.setDoInput(true);
            connection.setUseCaches(true); //设置不使用缓存
            InputStream inputStream=connection.getInputStream();
            bitmap= BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0x123){
                imageLager.setImageBitmap(bitmap);
            }
        };
    };


    /**
     * 异步线程下载图片
     *
     */
    class Task extends AsyncTask<String, Integer, Void> {

        protected Void doInBackground(String... params) {
            bitmap=GetImageInputStream((String)params[0]);
            return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Message message=new Message();
            message.what=0x123;
            handler.sendMessage(message);
        }

    }

    /**
     * 保存位图到本地
     * @param bitmap
     * @param path 本地路径
     * @return void
     */
    public void SavaImage(Bitmap bitmap, String path){
        File file=new File(path);
        FileOutputStream fileOutputStream=null;
        //文件夹不存在，则创建它
        if(!file.exists()){
            file.mkdir();
        }
        try {
            fileOutputStream=new FileOutputStream(path+"/"+System.currentTimeMillis()+".jpg");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_interImage_larger:
                final PopupWindow pop = new PopupWindow();
                View v = LayoutInflater.from(ContentActivity.this).inflate(R.layout.image_click_load, null);
                pop.setContentView(v);
                image_blow = (MyDraweeView) v.findViewById(R.id.iv_image_load);
                download= (ImageView) v.findViewById(R.id.image_load);
                image_blow.setImageURI(contentImg);
                /*image_blow.setAspectRatio(imgWidth / imgHeight);*/
                pop.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                pop.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                pop.setFocusable(true);
                pop.setTouchable(true);
                pop.setOutsideTouchable(true);
                pop.setAnimationStyle(R.style.Popwindow2);
                pop.setOnDismissListener(new PoponDismissListener());
                pop.showAtLocation(imageLager,Gravity.CENTER,0,0);
                backgroundAlpha(0.3f);
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                v.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        if (keyCode==KeyEvent.KEYCODE_BACK){
                            //如果PopupWindow处于显示状态，则关闭PopupWindow
                            if (pop.isShowing()) {
                                pop.dismiss();
                            }

                        }
                        return false;
                    }
                });
                 image_blow.setOnClickListener(new MyDraweeView.OnClickListener() {
                     @Override
                     public void onClick() {
                         pop.dismiss();
                     }
                 });
                download.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (bitmap==null){
                            Toast.makeText(ContentActivity.this, "正在下载", Toast.LENGTH_SHORT).show();
                            new Task().execute(contentImg);
                            SavaImage(bitmap, Environment.getExternalStorageDirectory().getPath()+"/Testy");
                        }else {
                            Toast.makeText(ContentActivity.this, "图片已存在", Toast.LENGTH_SHORT).show();
                        }

                    }
                });



            case R.id.tv_from_onPage:
                break;
            case R.id.ib_back_onPage:
                finish();
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
                Intent toUserContent=new Intent(ContentActivity.this,UserContentActivity.class);
                toUserContent.putExtra("userID",userID);
                toUserContent.putExtra("choice",choice);
                startActivity(toUserContent);
                break;
            case R.id.ll_drawBoardLayout_onPage:
                break;
            case R.id.et_addNewCommit_onPage:
                Intent intent3=new Intent(ContentActivity.this,CommentActivity.class);
                startActivity(intent3);
                break;

            case R.id.ib_transPond_onPage:
                PopupWindow popupWindow=new PopupWindow();
                View v0= LayoutInflater.from(ContentActivity.this ).inflate(R.layout.share_picture_layout,null);
                popupWindow.setContentView(v0);
                popupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
                popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setTouchable(true);
                popupWindow.setFocusable(true);
                view.setFocusableInTouchMode(true);
                view.setFocusable(true);
                popupWindow.setAnimationStyle(R.style.Popwindow2);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.showAtLocation(imageLager, Gravity.BOTTOM, 0, 0);
                backgroundAlpha(0.3f);
                popupWindow.setOnDismissListener(new PoponDismissListener());
                break;
            case R.id.ib_getNew_onPage:
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
