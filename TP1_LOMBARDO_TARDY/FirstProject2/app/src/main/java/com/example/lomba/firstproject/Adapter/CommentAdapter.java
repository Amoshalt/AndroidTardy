package com.example.lomba.firstproject.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lomba.firstproject.Model.Comment;
import com.example.lomba.firstproject.ViewHolder.CommentViewHolder;
import com.example.lomba.firstproject.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter {

    private RecyclerView mRecyclerView;
    private List<Comment> mComments;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comment_layout, viewGroup, false);
        CommentViewHolder viewHolder = new CommentViewHolder(mView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Comment currentComment = mComments.get(i);
        if (viewHolder instanceof CommentViewHolder && currentComment != null) {
            CommentViewHolder commentViewHolder = (CommentViewHolder) viewHolder;
            commentViewHolder.layoutforComment(currentComment);
        }
    }

    @Override
    public int getItemCount() {
        if (mComments != null) {
            return mComments.size();
        } else return 0;
    }

    public void setmComments(List<Comment> mComments) {
        this.mComments = mComments;
    }
}
