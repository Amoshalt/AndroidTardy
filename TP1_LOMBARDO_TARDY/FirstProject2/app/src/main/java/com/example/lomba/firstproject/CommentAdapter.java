package com.example.lomba.firstproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter {

    private RecyclerView mRecyclerView;
    private List<Comment> mComments;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        if (mComments != null) {
            return mComments.size();
        } else return 0;
    }
}
