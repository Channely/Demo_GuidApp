package com.li.learn.guidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class LoadingActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_layout);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!isFirst()) {
                    goTo(MainActivity.class);
                } else {
                    goTo(GuideActivity.class);
                }

            }
        }, 2000);
    }

    private void goTo(Class<? extends Activity> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
        finish();
    }

    private boolean isFirst() {
        return true;
    }
}
