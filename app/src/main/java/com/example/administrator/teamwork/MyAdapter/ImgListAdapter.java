package com.example.administrator.teamwork.MyAdapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.administrator.teamwork.MyInfo.LocalShareInfo;
import com.example.administrator.teamwork.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

/**
 * Created by anzhuo on 2016/9/19.
 */
public class ImgListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<LocalShareInfo> mList;
    LocalShareInfo localImgListInfo;
    Context mContext;
    LayoutInflater mInflater;
    private MyClickListener mListener = null;
    protected final int mItemLayoutId;

    public enum ITEM_TYPE {
        ITEM1,
        ITEM2
    }

    public void setClickListener(MyClickListener listener) {

        this.mListener = listener;

    }

    public interface MyClickListener {
        void onThisItemClick(int position);
        void onImageContentClick(int position);

        void onUserMsgClick(int position);
    }

    public ImgListAdapter(List<LocalShareInfo> List, Context context, int itemId) {
        this.mList = List;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mItemLayoutId = itemId;


    }

    @Override
    public int getItemViewType(int position) {
        if (mItemLayoutId == 1) {
            return ITEM_TYPE.ITEM1.ordinal();
        } else {
            return ITEM_TYPE.ITEM2.ordinal();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE.ITEM1.ordinal()) {
            return new MyViewHolder1(mInflater.inflate(R.layout.home_image_item, parent, false));
        } else {
            Log.i("get","adapter2");
            return new MyViewHolder2(mInflater.inflate(R.layout.find_item_layout, parent, false));
        }

       /* View view = mInflater.inflate(R.layout.home_image_item, parent, false);

        View view1 = mInflater.inflate(R.layout.find_item_layout,parent,false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;*/
    }



    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        localImgListInfo = mList.get(position);

        if (holder instanceof MyViewHolder2) {
            ((MyViewHolder2) holder).coverTitle.setText(localImgListInfo.getCoverTitle());
            ((MyViewHolder2) holder).coverImg.setImageURI(localImgListInfo.getCoverImg());
            ((MyViewHolder2) holder).coverImg.setAspectRatio(1.0f);


            if (mListener != null) {
                ((MyViewHolder2) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mListener.onThisItemClick(position);
                    }
                });
            }


        } else if (holder instanceof MyViewHolder1) {


            ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(localImgListInfo.getContentImg()))
                    .setProgressiveRenderingEnabled(true)
                    .build();
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .setAutoPlayAnimations(true)
                    .setOldController(((MyViewHolder1) holder).imageContent.getController())
                    .build();
            ((MyViewHolder1) holder).imageContent.setController(controller);


         /*   ((MyViewHolder1) holder).imageContent.setImageURI(localImgListInfo.getContentImg());*/
            float imgWidth = Float.parseFloat(localImgListInfo.getImgWidth());
            float imgHeight = Float.parseFloat(localImgListInfo.getImgHeight());
            if (imgWidth / imgHeight < 0.5) {
                ((MyViewHolder1) holder).imageContent.setAspectRatio(0.5f);
            } else {
                ((MyViewHolder1) holder).imageContent.setAspectRatio(imgWidth / imgHeight);
            }


            ((MyViewHolder1) holder).userHead.setImageURI(localImgListInfo.getUserHead());
            ((MyViewHolder1) holder).username.setText(localImgListInfo.getUsername());
            ((MyViewHolder1) holder).imageIntroduce.setText(localImgListInfo.getRaw_text());
            if (localImgListInfo.getRaw_text().equals("")) {
                ((MyViewHolder1) holder).imageIntroduce.setVisibility(View.GONE);
            } else {
                ((MyViewHolder1) holder).imageIntroduce.setVisibility(View.VISIBLE);
                ((MyViewHolder1) holder).imageIntroduce.setText(localImgListInfo.getRaw_text());
            }
            if (localImgListInfo.getRepin_count().equals("0")) {
                ((MyViewHolder1) holder).transPond.setVisibility(View.GONE);
            } else {
                ((MyViewHolder1) holder).transPond.setVisibility(View.VISIBLE);
                ((MyViewHolder1) holder).transPond.setText(localImgListInfo.getRepin_count());
            }
            if (localImgListInfo.getLike_count().equals("0")) {
                ((MyViewHolder1) holder).collect.setVisibility(View.GONE);
            } else {
                ((MyViewHolder1) holder).collect.setVisibility(View.VISIBLE);
                ((MyViewHolder1) holder).collect.setText(localImgListInfo.getLike_count());
            }
            if (localImgListInfo.getComment_count().equals("0")) {
                ((MyViewHolder1) holder).comments.setVisibility(View.GONE);
            } else {
                ((MyViewHolder1) holder).comments.setVisibility(View.VISIBLE);
                ((MyViewHolder1) holder).comments.setText(localImgListInfo.getComment_count());
            }

            ((MyViewHolder1) holder).drawBoardName.setText(localImgListInfo.getTitle());
            if (mListener != null) {

                ((MyViewHolder1) holder).imageContent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.onImageContentClick(position);
                    }
                });
                ((MyViewHolder1) holder).userMsg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.onUserMsgClick(position);
                    }
                });

            }


        }


    }


    public void onDataChange(List<LocalShareInfo> list) {
        this.mList = list;
        this.notifyDataSetChanged();
    }


    /*public void addItem(List<LocalImgListInfo> newDatas) {
        *//* mTitles.add(position, data);
         notifyItemInserted(position);*//*
         newDatas.addAll(mList);
         mList.removeAll(mList);
         mList.addAll(newDatas);
         notifyDataSetChanged();
     }*/
    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        SimpleDraweeView coverImg;
        TextView coverTitle;

        public MyViewHolder2(View itemView) {
            super(itemView);

            coverImg = (SimpleDraweeView) itemView.findViewById(R.id.iv_phone_wallpaper);
            coverTitle = (TextView) itemView.findViewById(R.id.tv_phone_wallpaper);
        }
    }

    public static class MyViewHolder1 extends RecyclerView.ViewHolder {


        RelativeLayout userMsg;
        //用户头像
        SimpleDraweeView userHead;
        //图片内容
        SimpleDraweeView imageContent;
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

        public MyViewHolder1(View itemView) {
            super(itemView);

            userMsg = (RelativeLayout) itemView.findViewById(R.id.rl_userMsg_home);
            userHead = (SimpleDraweeView) itemView.findViewById(R.id.iv_userHead_home);
            imageContent = (SimpleDraweeView) itemView.findViewById(R.id.iv_interImage_home);
            username = (TextView) itemView.findViewById(R.id.tv_username_home);
            imageIntroduce = (TextView) itemView.findViewById(R.id.tv_image_introduce_home);
            drawBoardName = (TextView) itemView.findViewById(R.id.tv_userDrawBoard_home);
            transPond = (TextView) itemView.findViewById(R.id.tv_transPond_home);
            collect = (TextView) itemView.findViewById(R.id.tv_collect_home);
            comments = (TextView) itemView.findViewById(R.id.tv_comment_home);


        }

    }

}
