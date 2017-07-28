package com.example.alainp.tutorials;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by alainp on 7/26/17.
 */

public class ProfileView extends FrameLayout {

    private ZRecyclerViewVertical mRecyclerView;
//    private GestureDetector gestureDetector;

    public ProfileView(@NonNull Context context) {
        super(context);
        init();
    }

    public ProfileView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ProfileView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        inflate(getContext(), R.layout.item_search, this);

        mRecyclerView = (ZRecyclerViewVertical) findViewById(R.id.recyclerView_profile);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        ProfileAdapter profileAdapter = new ProfileAdapter();

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(profileAdapter);
        snapHelper.attachToRecyclerView(mRecyclerView);

//        CustomGestureDetector detector = new CustomGestureDetector("conchaProfileView", false);
//        gestureDetector = new GestureDetector(getContext(), detector);
//         GestureDetector gestureDetector = new GestureDetector(getContext(), new ScrollDetectors());
//        mRecyclerView.setGestureDetector(gestureDetector);

//        mRecyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                rv.getMaxFlingVelocity();
//                boolean res = super.onInterceptTouchEvent(rv, e);
//                Log.d("conchaInterceptProfile", e.toString());
////                Log.d("conchaInterceptProfile", String.valueOf(res));
//
//                return res;
//            }
//        });

//        mRecyclerView.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if(
//                        event.getAction() == MotionEvent.ACTION_DOWN &&
//                                v instanceof ViewGroup
//                        ) {
//                    ((ViewGroup) v).requestDisallowInterceptTouchEvent(true);
//                }
//                return false;
//            }
//        });

//
//        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.getParent().requestDisallowInterceptTouchEvent(true);
//                switch (event.getAction() & MotionEvent.ACTION_MASK) {
//                    case MotionEvent.ACTION_UP:
//                        v.getParent().requestDisallowInterceptTouchEvent(false);
//                        break;
//                }
//                return false;
//            }
//
//        });

    }


    public class ProfileAdapter extends RecyclerView.Adapter {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content, parent, false);

            return new ProfileViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ProfileViewHolder) holder).bindData();
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

    static class ProfileViewHolder extends RecyclerView.ViewHolder {

        private final int[] colors = {
                R.color.darkred,
                R.color.orange,
                R.color.colorPrimaryDark,
        };

        public ProfileViewHolder(View itemView) {
            super(itemView);
        }

        void bindData() {
            int random = (int)(Math.random() * 2);
            ((TextView) itemView.findViewById(R.id.text)).setTextColor(itemView.getContext().getResources().getColor(colors[random]));
        }
    }

    public class ScrollDetectors extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceX) > Math.abs(distanceY);
        }
    }


}
