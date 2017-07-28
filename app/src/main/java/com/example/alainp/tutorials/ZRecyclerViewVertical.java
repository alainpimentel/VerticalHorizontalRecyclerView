package com.example.alainp.tutorials;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by alainp on 7/26/17.
 */

public class ZRecyclerViewVertical extends RecyclerView{

    private GestureDetector gestureDetector;

    public ZRecyclerViewVertical(Context context) {
        super(context);
    }

    public ZRecyclerViewVertical(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZRecyclerViewVertical(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
//        Log.d("test", "RecyclerView onTouchEvent");
//        gestureDetector.onTouchEvent(e);
//        if (gestureDetector.onTouchEvent(e)) {
//            Log.d("conchaa", "should stop");
////            stopScroll();
//            return false;
//        }
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        if (gestureDetector != null && gestureDetector.onTouchEvent(e)) {
            Log.d("conchaintercept", "Intercepted");
//            super.onInterceptTouchEvent(e);
//            stopScroll();
            return false;
        }
//        Log.d("concha", "inner onInterceptTouchEvent");
//        gestureDetector.onTouchEvent(e);

//        getMinFlingVelocity()
//        if (gestureDetector.onTouchEvent(e)) {
//            Log.d("conchaa", "should stop");
////            stopScroll();
//            return false;
//        }
        return super.onInterceptTouchEvent(e);
    }

    //    @Override
//    public boolean onInterceptTouchEvent(MotionEvent e) {
//        Log.d("conconcha", "MotionEvent: " + e + " --- scroll state: " + getScrollState());
//
//        boolean res = super.onInterceptTouchEvent(e);
//        Log.d("conconcha", "Result: " + res);
//
//        return super.onInterceptTouchEvent(e);
//    }
//
//    @Override
//    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
//        Log.d("conconcha", "onStartNestedScroll: " + nestedScrollAxes);
//        return super.onStartNestedScroll(child, target, nestedScrollAxes);
//    }
}
