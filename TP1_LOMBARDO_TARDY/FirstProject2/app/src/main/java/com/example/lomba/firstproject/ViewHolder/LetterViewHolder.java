package com.example.lomba.firstproject.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lomba.firstproject.R;

public class LetterViewHolder extends RecyclerView.ViewHolder{

    private TextView letterTextView;
    private TextView nbMoviesTextView;

    public LetterViewHolder(@NonNull View itemView) {
        super(itemView);
        letterTextView = itemView.findViewById(R.id.letterText);
        nbMoviesTextView = itemView.findViewById(R.id.nbMoviesText);
    }

    public void layoutforLetter(char aChar, int nbMovies) {
        this.letterTextView.setText(" " + aChar);
        if (nbMovies >0) {
            this.nbMoviesTextView.setText("" + nbMovies + " movies");
        }
    }
}
