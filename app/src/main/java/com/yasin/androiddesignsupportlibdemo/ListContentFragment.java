package com.yasin.androiddesignsupportlibdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasin on 2017/4/25.
 * Email : yasin27878@163.com
 * Description :
 */

public class ListContentFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    public static BaseFragment newInstance(String titles, int id) {
        Bundle args = new Bundle();
        args.putString("title", titles);
        args.putInt("id", id);
        BaseFragment fragment = new ListContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        title = getArguments().getString("title");
        View view = LayoutInflater.from(getContext()).inflate(R.layout.recycler_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> ss = new ArrayList<>();
        ss.add("1111111111111");
        ss.add("2222222222222");
        ss.add("3333333333333");
        ss.add("4444444444444");
        ss.add("55555555555555");
        ss.add("66666666666666");
        ss.add("77777777777777");
        ListAdapter adapter = new ListAdapter(getActivity(), ss);
        mRecyclerView.setAdapter(adapter);

    }
}
