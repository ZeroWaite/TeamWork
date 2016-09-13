package com.example.administrator.teamwork.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.teamwork.MyInfo.MyHomeInfo;
import com.example.administrator.teamwork.R;

import java.util.List;

/**
 * Created by anzhuo on 2016/9/12.
 */
public class MyImageAdapter extends BaseAdapter {
    List<MyHomeInfo> mList;
    List<MyHomeInfo.WeekliesBean> wList;
    MyHomeInfo.WeekliesBean weekliesBean;
    MyHomeInfo myHomeInfo;
    Context mContext;

    public MyImageAdapter(List<MyHomeInfo> mList, List<MyHomeInfo.WeekliesBean> wList, Context mContext) {
        this.mList = mList;
        this.wList = wList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.home_image_item, null);
            holder = new ViewHolder();
            holder.userHead = (ImageView) view.findViewById(R.id.iv_userHead_home);
            holder.imageContent = (ImageView) view.findViewById(R.id.iv_interImage_home);
            holder.username = (TextView) view.findViewById(R.id.tv_username_home);
            holder.imageIntroduce = (TextView) view.findViewById(R.id.tv_image_introduce_home);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        myHomeInfo = mList.get(i);
        weekliesBean = wList.get(i);
        holder.userHead.setImageResource(R.mipmap.ic_launcher);
        holder.imageContent.setImageResource(R.mipmap.ic_launcher);
        holder.username.setText(weekliesBean.getTitle());
        holder.imageIntroduce.setText(weekliesBean.getDescription());

        return view;
    }

    class ViewHolder {
        //用户头像
        ImageView userHead;
        //图片内容
        ImageView imageContent;
        //用户名
        TextView username;
        //画板名
        TextView drawBoardName;
        //图片介绍
        TextView imageIntroduce;
        //上传时间
        TextView date;
        //图片来源
        TextView from;
        //转发
        TextView transPond;
        //评论
        TextView comments;
        //收藏
        TextView collect;
    }
}


