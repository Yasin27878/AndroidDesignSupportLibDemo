package com.yasin.androiddesignsupportlibdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Yasin on 2017/4/25.
 * Email : yasin27878@163.com
 * Description :
 */

public class GradContentFragment extends BaseFragment {
    public static BaseFragment newInstance(String titles, int id) {
        Bundle args = new Bundle();
        args.putString("title", titles);
        args.putInt("id", id);
        BaseFragment fragment = new GradContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        title = getArguments().getString("title");
        id = getArguments().getInt("id", 0);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.frgment_base, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("GradContentFragment");
        return view;
    }
}
