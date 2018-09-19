package com.example.lomba.firstproject.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lomba.firstproject.R;

public class LetterViewHolder extends RecyclerView.ViewHolder{

    private TextView titleTextView;

    public LetterViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.letterText);
    }

    public void layoutforLetter(char aChar) {
        this.titleTextView.setText(" " + aChar);
    }
}
