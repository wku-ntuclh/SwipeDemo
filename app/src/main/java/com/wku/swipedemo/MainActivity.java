package com.wku.swipedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.github.pwittchen.swipe.library.Swipe;
import com.github.pwittchen.swipe.library.SwipeListener;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    //step 1 Declare Swipe attribute
    private Swipe swipe;
    private int i = 1;
    private int[] array = { R.drawable.b0, R.drawable.b1, R.drawable.b2, R.drawable.b3 };
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        //step 2 Initialise and add listener
        swipe = new Swipe();
        swipe.addListener(new SwipeListener() {
            @Override
            public void onSwipingLeft(MotionEvent event) {

            }

            @Override
            public void onSwipedLeft(MotionEvent event) {
//                Toast.makeText(MainActivity.this, "onSwipedLeft", Toast.LENGTH_SHORT).show();
                i = (i+1) % array.length;
                updateImage(array[i]);
            }

            @Override
            public void onSwipingRight(MotionEvent event) {

            }

            @Override
            public void onSwipedRight(MotionEvent event) {
//                Toast.makeText(MainActivity.this, "onSwipedRight", Toast.LENGTH_SHORT).show();
                i = (i -1 + array.length) % array.length;
                updateImage(array[i]);
            }

            @Override
            public void onSwipingUp(MotionEvent event) {

            }

            @Override
            public void onSwipedUp(MotionEvent event) {
//                Toast.makeText(MainActivity.this, "onSwipedUp", Toast.LENGTH_SHORT).show();
                updateImage(R.drawable.bigbird);
            }

            @Override
            public void onSwipingDown(MotionEvent event) {

            }

            @Override
            public void onSwipedDown(MotionEvent event) {
//                Toast.makeText(MainActivity.this, "onSwipedDown", Toast.LENGTH_SHORT).show();
                updateImage(R.drawable.p0);
            }
        });
    }

    //step 3 override dispatchTouchEvent(MotionEvent event)
    @Override public boolean dispatchTouchEvent(MotionEvent event) {
        swipe.dispatchTouchEvent(event);
        return super.dispatchTouchEvent(event);
    }

    public void updateImage(int id) {
        imageView.setImageResource(id);
    }
}
