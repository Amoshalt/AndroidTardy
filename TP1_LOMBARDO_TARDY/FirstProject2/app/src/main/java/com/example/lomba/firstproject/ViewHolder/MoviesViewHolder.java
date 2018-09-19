package com.example.lomba.firstproject.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lomba.firstproject.Model.Movie;
import com.example.lomba.firstproject.R;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitleMovieTextView;
    private TextView mDescriptionMovieTextView;

    private ImageView mMovieImageView;


    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mTitleMovieTextView = itemView.findViewById(R.id.movieTitle);
        this.mDescriptionMovieTextView = itemView.findViewById(R.id.movieDescription);
        this.mMovieImageView = itemView.findViewById(R.id.movieImage);
    }

    public void layoutforMovie(Movie movie) {
        if (movie != null) {
            if (mTitleMovieTextView != null) {
                mTitleMovieTextView.setText(movie.getmTitle());
            }
            if (mDescriptionMovieTextView != null) {
                mDescriptionMovieTextView.setText(movie.getmDescription());
            }
//            if (mMovieImageView != null) {
//                mMovieImageView.setImageResource(movie.getmMovieImageId());
//            }

        }
    }
}
