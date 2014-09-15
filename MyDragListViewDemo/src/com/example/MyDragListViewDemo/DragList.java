package com.example.MyDragListViewDemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by WANGZHENGZE on 2014/9/15.
 */
public class DragList extends ListView {

    private WindowManager windowManager = null;
    private WindowManager.LayoutParams windowParams = null;
    private View dragImageView = null;



    public DragList(Context context) {
        super(context);
    }

    public DragList(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragList(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    private void mySetOnlongClick() {
        setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });
    }



    public void startDrag(Bitmap dragBitmap, int x, int y) {
        stopDrag();
        windowParams = new WindowManager.LayoutParams();// 获取WINDOW界面的
        //Gravity.TOP|Gravity.LEFT;这个必须加
        windowParams.gravity = Gravity.TOP | Gravity.LEFT;
//		windowParams.x = x - (int)((itemWidth / 2) * dragScale);
//		windowParams.y = y - (int) ((itemHeight / 2) * dragScale);
        //得到preview左上角相对于屏幕的坐标
        windowParams.x = x;
        windowParams.y = y;
//		this.windowParams.x = (x - this.win_view_x + this.viewX);//位置的x值
//		this.windowParams.y = (y - this.win_view_y + this.viewY);//位置的y值
        //设置拖拽item的宽和高
        windowParams.width = (int) (1.2 * dragBitmap.getWidth());// 放大dragScale倍，可以设置拖动后的倍数
        windowParams.height = (int) (1.2 * dragBitmap.getHeight());// 放大dragScale倍，可以设置拖动后的倍数
        this.windowParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
        this.windowParams.format = PixelFormat.TRANSLUCENT;
        this.windowParams.windowAnimations = 0;
        ImageView iv = new ImageView(getContext());
        iv.setImageBitmap(dragBitmap);
        windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);// "window"
        windowManager.addView(iv, windowParams);
        dragImageView = iv;
    }
    private void stopDrag() {
        if (dragImageView != null) {
            windowManager.removeView(dragImageView);
            dragImageView = null;
        }
    }
}
