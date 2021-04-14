package com.blog.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {
    private ArrayList<String> examples;
    private IndexActivity.IClickItemListener clickListener;

    public SimpleAdapter(IndexActivity.IClickItemListener listener, ArrayList<String> datas) {
        this.clickListener = listener;
        examples = datas;
    }

    @NonNull
    @Override
    public SimpleAdapter.ViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_layout, parent, false);
        return new SimpleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleAdapter.ViewHolder holder, int position) {
        holder.tvContent.setText(examples.get(position));
        holder.clickCallback.position = position;
        holder.clickCallback.setViewHolder(holder);
        holder.allLayout.setOnClickListener(holder.clickCallback);
    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleAdapter.MyClickListener clickCallback = new SimpleAdapter.MyClickListener();
        LinearLayout allLayout;
        TextView tvContent;

        ViewHolder(View view) {
            super(view);
            tvContent = view.findViewById(R.id.tv_content);
            allLayout = view.findViewById(R.id.all_layout);
        }
    }

    class MyClickListener implements View.OnClickListener {
        WeakReference<ViewHolder> wrf;
        int position;

        void setViewHolder(SimpleAdapter.ViewHolder viewHolder) {
            wrf = new WeakReference<>(viewHolder);
        }

        @Override
        public void onClick(View v) {
            if (wrf != null && wrf.get() != null && clickListener != null) {
                clickListener.onClick(position);
            }
        }
    }
}
