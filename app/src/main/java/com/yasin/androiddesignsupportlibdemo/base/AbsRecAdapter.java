package com.yasin.androiddesignsupportlibdemo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsRecAdapter<T> extends RecyclerView.Adapter<AbsViewHolder> {

    protected List<T> mData = new ArrayList<>();

    protected final Context mContext;

    protected LayoutInflater mInflater;

    private OnItemClickListener mClickListener;

    private OnItemLongClickListener mLongClickListener;


    public AbsRecAdapter(Context ctx) {
        mContext = ctx;
        mInflater = LayoutInflater.from(ctx);
    }

    public AbsRecAdapter(final Context context, final List<T> data) {
        this(context);
        if (data == null || data.size() == 0) {
            return;
        }
        this.mData.addAll(data);
    }


    public void setList(List<T> data) {
        this.mData.clear();
        if (data != null) {
            this.mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void addList(List<T> data) {
        if (data != null) {
            this.mData.addAll(data);
        }
        notifyDataSetChanged();
    }


    public List<T> getData() {
        return mData;
    }

    @Override
    public AbsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final AbsViewHolder holder = new AbsViewHolder(mContext,
                mInflater.inflate(getItemLayoutId(viewType), parent, false));
        if (mClickListener != null) {
            holder.itemView.setOnClickListener(v ->
                    mClickListener.onItemClick(holder.itemView, holder.getAdapterPosition()));
        }
        if (mLongClickListener != null) {
            holder.itemView.setOnLongClickListener(v -> {
                mLongClickListener.onItemLongClick(holder.itemView, holder.getAdapterPosition());
                return true;
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(AbsViewHolder holder, int position) {
        bindData(holder, position, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    abstract public int getItemLayoutId(int viewType);

    abstract public void bindData(AbsViewHolder holder, int position, T item);

    public interface OnItemClickListener {
        void onItemClick(View itemView, int pos);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View itemView, int pos);
    }
}