package com.example.lomba.firstproject.ViewHolder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lomba.firstproject.Activities.MainActivity;
import com.example.lomba.firstproject.Model.Movie;
import com.example.lomba.firstproject.R;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitleMovieTextView;
    private TextView mDescriptionMovieTextView;
    private int movieId;
    private ImageView mMovieImageView;


    public MoviesViewHolder(@NonNull final View itemView) {
        super(itemView);

        this.mTitleMovieTextView = itemView.findViewById(R.id.movieTitle);
        this.mDescriptionMovieTextView = itemView.findViewById(R.id.movieDescription);
        this.mMovieImageView = itemView.findViewById(R.id.movieImage);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(itemView.getContext(), MainActivity.class);
                i.putExtra("MOVIE_ID", (int) itemView.getTag());
                Log.d("testviewholder","" + (int) itemView.getTag() );
                itemView.getContext().startActivity(i);
            }
        });
    }

    public void layoutforMovie(Movie movie) {
        if (movie != null) {
            if (mTitleMovieTextView != null) {
                mTitleMovieTextView.setText(movie.getmTitle());
            }
            if (mDescriptionMovieTextView != null) {
                mDescriptionMovieTextView.setText(movie.getmDescription());
            }

            itemView.setTag(movie.getId());
//            if (mMovieImageView != null) {
//                mMovieImageView.setImageResource(movie.getmMovieImageId());
//            }

        }
    }
}
