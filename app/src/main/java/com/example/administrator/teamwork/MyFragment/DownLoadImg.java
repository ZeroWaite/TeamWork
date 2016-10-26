package com.example.administrator.teamwork.MyFragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.teamwork.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/10/25.
 */
public class DownLoadImg extends Activity implements View.OnClickListener{
    ImageView content;
    ImageView image;
    Bitmap bitmap;
    Button clean;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_click_load);
        content=(ImageView)findViewById(R.id.image_load);
        image=(ImageView)findViewById(R.id.iv_image_load);
        clean=(Button) findViewById(R.id.bt_clean);
        content.setOnClickListener(this);;
        image.setOnClickListener(this);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image_load:
                //加入网络图片地址
                new Task().execute("http://pic.4j4j.cn/upload/pic/20130617/55695c3c95.jpg");
                Toast.makeText(DownLoadImg.this, "下载", Toast.LENGTH_SHORT).show();
                SavaImage(bitmap, Environment.getExternalStorageDirectory().getPath()+"/Test");
                break;
           /* case R.id.iv_image_load:
                //点击图片后将图片保存到SD卡跟目录下的Test文件夹内
                SavaImage(bitmap, Environment.getExternalStorageDirectory().getPath()+"/Test");
                Toast.makeText(DownLoadImg.this, "图片保存", Toast.LENGTH_SHORT).show();
                break;*/

            default:
                break;
        }
    }

    Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if(msg.what==0x123){
                image.setImageBitmap(bitmap);
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
            fileOutputStream=new FileOutputStream(path+"/"+System.currentTimeMillis()+".png");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
