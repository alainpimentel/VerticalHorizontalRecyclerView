package com.example.alainp.tutorials;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by alainp on 7/26/17.
 */

public class ZRecyclerView extends RecyclerView {

    public ZRecyclerView(Context context) {
        super(context);
    }

    public ZRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

//    @Override
//    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
//        Log.d("concha", String.format("l %d --- t %d --- oldl %d --- oldt %d", l, t, oldl, oldt));
//        super.onScrollChanged(l, t, oldl, oldt);
//    }
//



    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
//        Log.d("concha", "MotionEvent: " + event + " --- scroll state: " + getScrollState());
//
        boolean res = super.onInterceptTouchEvent(event);
//                Log.d("concha", "Result: " + res);
        return res;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return super.onTouchEvent(e);
    }



    /**
     * The RecyclerView is not currently scrolling.
     * @see #getScrollState()
     */
//    public static final int SCROLL_STATE_IDLE = 0;

    /**
     * The RecyclerView is currently being dragged by outside input such as user touch input.
     * @see #getScrollState()
     */
//    public static final int SCROLL_STATE_DRAGGING = 1;

    /**
     * The RecyclerView is currently animating to a final position while not under
     * outside control.
     * @see #getScrollState()
     */
//    public static final int SCROLL_STATE_SETTLING = 2;

}
