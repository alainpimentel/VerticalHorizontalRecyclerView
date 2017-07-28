package com.example.alainp.tutorials;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lsjwzh.widget.recyclerviewpager.RecyclerViewPager;

public class MainActivity extends AppCompatActivity {

    private boolean isPagerActive;
    private ZRecyclerViewVertical mRecyclerView;
    private RecyclerViewPager mRecyclerViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Original RecyclerView
         */
        mRecyclerView = (ZRecyclerViewVertical) findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ZPagerSnapHelper snapHelper = new ZPagerSnapHelper();
        SearchAdapter searchAdapter = new SearchAdapter();

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(searchAdapter);
        snapHelper.attachToRecyclerView(mRecyclerView);

//        CustomGestureDetector detector = new CustomGestureDetector("conchaSearch", true);


        final GestureDetector gestureDetector = new GestureDetector(this, new ScrollDetector());
        mRecyclerView.setGestureDetector(gestureDetector);

//        mRecyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                boolean res = super.onInterceptTouchEvent(rv, e);
//                Log.d("conchaInterceptSearch", e.toString());
////                Log.d("conchaInterceptSearch", String.valueOf(res));
//
//                if (gestureDetector.onTouchEvent(e)) {
//                    return true;
//                }
//
//                return false;
//            }
//        });

//        SwipeGestureDetector detector = new SwipeGestureDetector();
//        final GestureDetector gestureDetector = new GestureDetector(this, detector);
//        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return super.onTouch(v, event);
//            }
//        });
//        mRecyclerView.setOnTouchListener(new RecyclerView.OnTouchL3istener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return super.);
//            }
//            //            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////                gestureDetector.onTouchEvent(event);
////
////                return MainActivity.super.onTouchEvent(v, event);
////            }
//        });gma

        /**
         * RecyclerViewPager
         */
        mRecyclerViewPager = (RecyclerViewPager) findViewById(R.id.recyclerViewPager);
        LinearLayoutManager pagerlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        SearchAdapter pagerSearchAdapter = new SearchAdapter();

        mRecyclerViewPager.setLayoutManager(pagerlayoutManager);
        mRecyclerViewPager.setAdapter(pagerSearchAdapter);

        /**
         * Button Logic
         */
        Button button = (Button) findViewById(R.id.button_componentToggle);
        final TextView textView = (TextView) findViewById(R.id.text_component);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPagerActive) {
                    mRecyclerViewPager.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.VISIBLE);
                    textView.setText("Original RecyclerView");
                    isPagerActive = false;
                } else {
                    mRecyclerViewPager.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.VISIBLE);
                    textView.setText("Library RecyclerViewPager");
                    isPagerActive = true;
                }
            }
        });

        isPagerActive = false;
        mRecyclerViewPager.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    public class SearchAdapter extends RecyclerView.Adapter {
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ProfileView view = new ProfileView(parent.getContext());
            view.setLayoutParams(
                    new RecyclerView.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));

            return new SearchViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((SearchViewHolder) holder).bindData();
        }

        @Override
        public int getItemCount() {
            return 50;
        }
    }

    class ScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceX) > Math.abs(distanceY);
        }
    }

    static class SearchViewHolder extends RecyclerView.ViewHolder {

        private final int[] colors = {
                R.color.blue,
                R.color.colorAccent,
                R.color.darkblue,
                R.color.purple,
                R.color.darkorange,
                R.color.blue
        };

        public SearchViewHolder(View itemView) {
            super(itemView);
        }

        void bindData() {
            int random = (int)(Math.random() * 5);
            itemView.setBackgroundColor(itemView.getContext().getResources().getColor(colors[random]));
        }
    }

}
