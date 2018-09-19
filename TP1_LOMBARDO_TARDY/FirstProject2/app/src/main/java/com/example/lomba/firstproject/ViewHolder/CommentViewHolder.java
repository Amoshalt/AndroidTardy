package com.example.lomba.firstproject.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lomba.firstproject.Model.Comment;
import com.example.lomba.firstproject.R;

public class CommentViewHolder extends RecyclerView.ViewHolder{

    private TextView mTextCommentTextView;
    private TextView mUsernameCommentTextView;

    private ImageView mUserImageCommentTextView;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mTextCommentTextView = itemView.findViewById(R.id.text);
        this.mUserImageCommentTextView = itemView.findViewById(R.id.imageUser);
        this.mUsernameCommentTextView = itemView.findViewById(R.id.userName);
    }

    public void layoutforComment(Comment comment) {
        if (comment != null) {
            if (mUsernameCommentTextView != null) {
                mTextCommentTextView.setText(comment.getText());
            }
            if (mUsernameCommentTextView != null) {
                mUsernameCommentTextView.setText(comment.getUserName());
            }
//            if (mUserImageCommentTextView != null) {
//                mUserImageCommentTextView.setImageResource(comment.getuserImageId());
//            }
        }
    }
}
