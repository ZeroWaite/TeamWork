package com.example.administrator.teamwork.MyAdapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.teamwork.MyInfo.LocalHomePageInfo;
import com.example.administrator.teamwork.MyInfo.LocalPrettyGirlInfo;
import com.example.administrator.teamwork.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anzhuo on 2016/9/19.
 */
public class PrettyGirlAdapter extends RecyclerView.Adapter<PrettyGirlAdapter.MyViewHolder> {
    List<LocalPrettyGirlInfo> mList;
    LocalPrettyGirlInfo localPrettyGirlInfo;
    Context mContext;
    LayoutInflater mInflater;
    private MyClickListener mListener = null;

    public void setClickListener(MyClickListener listener) {

        this.mListener = listener;

    }

    public interface MyClickListener {
        void onImageContentClick(int position);

        void onUserMsgClick(int position);
    }

    public PrettyGirlAdapter(List<LocalPrettyGirlInfo> List, Context context) {
        this.mList = List;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.home_image_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }


    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
         /* Picasso.with(mContext).load(localPrettyGirlInfo.getUserHead()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.lock).into(holder.userHead);*/
      /*  holder.localPrettyGirlInfo.setCreated_at(String.valueOf(interPrettyGirlInfo.getPins().get(i).getCreated_at()));//需转换为时间差
        holder.localPrettyGirlInfo.setComment_count(String.valueOf(interPrettyGirlInfo.getPins().get(i).getComment_count()));
        holder.localPrettyGirlInfo.setLike_count(String.valueOf(interPrettyGirlInfo.getPins().get(i).getLike_count()));
        holder.localPrettyGirlInfo.setRepin_count(String.valueOf(interPrettyGirlInfo.getPins().get(i).getRepin_count()));
        holder.localPrettyGirlInfo.setFollow_count(String.valueOf(interPrettyGirlInfo.getPins().get(i).getLike_count()));*/
        localPrettyGirlInfo = mList.get(position);

        Picasso.with(mContext).load(localPrettyGirlInfo.getContentImg()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.lock).into(holder.imageContent);

        holder.userHead.setImageURI(localPrettyGirlInfo.getUserHead());
        holder.username.setText(localPrettyGirlInfo.getUsername());
        holder.imageIntroduce.setText(localPrettyGirlInfo.getRaw_text());
        if (localPrettyGirlInfo.getRaw_text().equals("")) {
            holder.imageIntroduce.setVisibility(View.GONE);
        } else {
            holder.imageIntroduce.setVisibility(View.VISIBLE);
            holder.imageIntroduce.setText(localPrettyGirlInfo.getRaw_text());
        }
        if (localPrettyGirlInfo.getRepin_count().equals("0")) {
            holder.transPond.setVisibility(View.GONE);
        } else {
            holder.transPond.setVisibility(View.VISIBLE);
            holder.transPond.setText(localPrettyGirlInfo.getRepin_count());
        }
        if (localPrettyGirlInfo.getLike_count().equals("0")) {
            holder.collect.setVisibility(View.GONE);
        } else {
            holder.collect.setVisibility(View.VISIBLE);
            holder.collect.setText(localPrettyGirlInfo.getLike_count());
        }
        if (localPrettyGirlInfo.getComment_count().equals("0")) {
            holder.comments.setVisibility(View.GONE);
        } else {
            holder.comments.setVisibility(View.VISIBLE);
            holder.comments.setText(localPrettyGirlInfo.getComment_count());
        }


     /*   holder.from.setText(localPrettyGirlInfo.getSource());*/
        holder.drawBoardName.setText(localPrettyGirlInfo.getTitle());
        if (mListener != null) {
            holder.imageContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onImageContentClick(position);
                }
            });
            holder.userMsg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onUserMsgClick(position);
                }
            });
        }


    }

    public void onDataChange(List<LocalPrettyGirlInfo> list) {
        this.mList = list;
        this.notifyDataSetChanged();
    }


    /* public void addItem(List<LocalPrettyGirlInfo> newDatas) {
         //mTitles.add(position, data);
         //notifyItemInserted(position);
         newDatas.addAll(mList);
         mList.removeAll(mList);
         mList.addAll(newDatas);
         notifyDataSetChanged();
     }*/
    class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout userMsg;
        //用户头像
        SimpleDraweeView userHead;
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

        public MyViewHolder(View itemView) {
            super(itemView);
            userMsg = (RelativeLayout) itemView.findViewById(R.id.rl_userMsg_home);
            userHead = (SimpleDraweeView) itemView.findViewById(R.id.iv_userHead_home);
            imageContent = (ImageView) itemView.findViewById(R.id.iv_interImage_home);
            username = (TextView) itemView.findViewById(R.id.tv_username_home);
            imageIntroduce = (TextView) itemView.findViewById(R.id.tv_image_introduce_home);
            drawBoardName = (TextView) itemView.findViewById(R.id.tv_userDrawBoard_home);
            transPond = (TextView) itemView.findViewById(R.id.tv_transPond_home);
            collect = (TextView) itemView.findViewById(R.id.tv_collect_home);
            comments = (TextView) itemView.findViewById(R.id.tv_comment_home);

        }

    }

}
