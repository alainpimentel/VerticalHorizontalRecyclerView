package com.example.alainp.tutorials;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by alainp on 7/26/17.
 */

public class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {

    private final String log;
    private boolean isVertical;

    public CustomGestureDetector(String log, boolean isVertical) {
        this.log = log;
        this.isVertical = isVertical;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {

        if (e1 == null || e2 == null) {
            return false;
        }

        Log.d(log, e1.toString());
        Log.d(log, e2.toString());
        Log.d(log, "x abs = " + Math.abs(e1.getX() - e2.getX()) + " --- y abs = " + Math.abs(e1.getY() - e2.getY()));
//        Log.d(log, "GESTURE - velx: " + velocityX + " --- velY: " + velocityY);


        if (e1.getX() < e2.getX()) {
            Log.d(log, "Left to Right swipe performed");
//            return !isVertical;
        }

        if (e1.getX() > e2.getX()) {
            Log.d(log, "Right to Left swipe performed");
//            return !isVertical;
        }

        if (e1.getY() < e2.getY()) {
            Log.d(log, "Up to Down swipe performed");
//            return isVertical;
        }

        if (e1.getY() > e2.getY()) {
            Log.d(log, "Down to Up swipe performed");
//            return isVertical;
        }

//        switch (getSlope(e1.getX(), e1.getY(), e2.getX(), e2.getY())) {
//            case 1:
//                Log.d(log, "top");
//            case 2:
//                Log.d(log, "left");
//            case 3:
//                Log.d(log, "down");
//            case 4:
//                Log.d(log, "right");
//        }
        return false;
    }

    private int getSlope(float x1, float y1, float x2, float y2) {
        Double angle = Math.toDegrees(Math.atan2(y1 - y2, x2 - x1));
        if (angle > 45 && angle <= 135)
            // top
            return 1;
        if (angle >= 135 && angle < 180 || angle < -135 && angle > -180)
            // left
            return 2;
        if (angle < -45 && angle >= -135)
            // down
            return 3;
        if (angle > -45 && angle <= 45)
            // right
            return 4;
        return 0;
    }

}
