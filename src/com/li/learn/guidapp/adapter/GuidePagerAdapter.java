package com.li.learn.guidapp.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by shoubo.lsb on 13-9-9.
 */
public class GuidePagerAdapter extends PagerAdapter {


    private List<ImageView> pagerImageList;

    public GuidePagerAdapter(List<ImageView> pagerImageList) {
        this.pagerImageList = pagerImageList;
    }

    @Override
    public int getCount() {
        return pagerImageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (View) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = pagerImageList.get(position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
