package com.li.learn.guidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.li.learn.guidapp.adapter.GuidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {

    private LinearLayout btnGroup;
    private ViewPager viewPager;
    private GuidePagerAdapter pagerAdapter;
    private List<ImageView> pagerImageList;

    private int currentSelectedPage;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_layout);
        initUI();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initGuideImages();
        initGuideDims();

        initListener();
    }

    private void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int position) {
                btnGroup.getChildAt(currentSelectedPage).setSelected(false);
                currentSelectedPage = position;
                btnGroup.getChildAt(currentSelectedPage).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initUI() {
        btnGroup = (LinearLayout) findViewById(R.id.guide_btn_group);
        viewPager = (ViewPager) findViewById(R.id.guide_view_pager);
    }

    private void initGuideImages() {
        pagerImageList = new ArrayList<ImageView>();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);

        ImageView guide01ImageView = new ImageView(this);
        guide01ImageView.setBackgroundResource(R.drawable.guide_1);
        guide01ImageView.setLayoutParams(layoutParams);

        ImageView guide02ImageView = new ImageView(this);
        guide02ImageView.setBackgroundResource(R.drawable.guide_2);
        guide02ImageView.setLayoutParams(layoutParams);

        ImageView guide03ImageView = new ImageView(this);
        guide03ImageView.setBackgroundResource(R.drawable.guide_3);
        guide03ImageView.setLayoutParams(layoutParams);

        guide03ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        pagerImageList.add(guide01ImageView);
        pagerImageList.add(guide02ImageView);
        pagerImageList.add(guide03ImageView);

        pagerAdapter = new GuidePagerAdapter(pagerImageList);
        viewPager.setAdapter(pagerAdapter);
        currentSelectedPage = 0;
    }

    private void initGuideDims() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10, 0, 10, 0);

        for (int index = 0; index < pagerImageList.size(); index++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.dim_select);
            imageView.setLayoutParams(layoutParams);
            btnGroup.addView(imageView);
        }

        btnGroup.getChildAt(currentSelectedPage).setSelected(true);
    }
}