package com.example.administrator.teamwork;

/**
 * Created by anzhuo on 2016/11/3.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * 屏蔽 滑动事件
 * Created by fc on 2015/7/16.
 */
public   class MyScrollView extends ScrollView {
    private int downX;
    private int downY;
    private int mTouchSlop;
    private ScrollViewListener scrollViewListener = null;

    public boolean isLast() {
        return  isLast;
    }

    public void setLast(boolean top) {
        isLast = top;
    }

    private boolean  isLast = false;//是不是滑动到了最低端 ；使用这个方法，解决了上拉加载的问题
    private OnScrollToBottomListener onScrollToBottom;

    public MyScrollView(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX,
                                  boolean clampedY) {
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
        if(scrollY != 0 && null != onScrollToBottom && isLast()){
            onScrollToBottom.onScrollBottomListener(clampedY);
        }
    }
    //判断顶部，底部的接口
    public interface OnScrollToBottomListener{
        void onScrollBottomListener(boolean isBottom);
    }

    public void setOnScrollToBottomLintener(OnScrollToBottomListener listener){
        onScrollToBottom = listener;
    }
    //监听滑动方向的接口
    public interface ScrollViewListener {
        void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy);
    }

    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }
    @Override
    protected void onScrollChanged(int x, int y, int oldx, int oldy) {
        super.onScrollChanged(x, y, oldx, oldy);
        if (scrollViewListener != null) {
            scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
        }
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        int action = e.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setLast(false);
                downX = (int) e.getRawX();
                downY = (int) e.getRawY();
                Log.i("-----::----downY-----::",downY+"");
                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) e.getRawY();
                Log.i("-----::----moveY-----::",moveY+"");
               /****判断是向下滑动，才设置为true****/
                if(downY-moveY>0){
                    setLast(true);
                }else{
                    setLast(false);
                }
                if (Math.abs(moveY - downY) > mTouchSlop) {
                    return true;
                }
        }
        return super.onInterceptTouchEvent(e);
    }
}