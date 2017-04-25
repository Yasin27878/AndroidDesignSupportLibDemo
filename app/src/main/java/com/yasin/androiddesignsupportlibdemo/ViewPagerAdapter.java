package com.yasin.androiddesignsupportlibdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasin on 2017/4/25.
 * Email : yasin27878@163.com
 * Description : ViewPager适配器
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        BaseFragment fragment = fragments.get(position);
        return TextUtils.isEmpty(fragment.title) ? fragment.getArguments().getString("title") : fragment.title;
    }

    public synchronized void removePager(int position) {
        fragments.remove(position);
        notifyDataSetChanged();
    }

    public synchronized void addPager(BaseFragment fragment) {
        int size = getCount();
        addPager(fragment, size);
    }

    public synchronized void addPager(BaseFragment fragment, int postion) {
        if (fragments == null) {
            fragments = new ArrayList<>(4);
        }

        fragments.add(postion, fragment);
        notifyDataSetChanged();
    }
}
