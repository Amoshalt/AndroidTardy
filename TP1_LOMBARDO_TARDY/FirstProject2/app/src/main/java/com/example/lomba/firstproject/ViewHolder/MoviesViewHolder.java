package com.example.lomba.firstproject.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lomba.firstproject.Interfaces.IItemOnCLickManager;
import com.example.lomba.firstproject.Manager.MovieManager;
import com.example.lomba.firstproject.Model.Movie;
import com.example.lomba.firstproject.R;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitleMovieTextView;
    private TextView mDescriptionMovieTextView;
    private ImageView mMovieImageView;

    private IItemOnCLickManager mgr;


    public void setClickManager(IItemOnCLickManager mgr) {
        this.mgr = mgr;
    }


    public MoviesViewHolder(@NonNull final View itemView) {
        super(itemView);

        this.mTitleMovieTextView = itemView.findViewById(R.id.movieTitle);
        this.mDescriptionMovieTextView = itemView.findViewById(R.id.movieDescription);
        this.mMovieImageView = itemView.findViewById(R.id.movieImage);
    }

    public void layoutforMovie(final Movie movie) {
        if (movie != null) {
            if (mTitleMovieTextView != null) {
                mTitleMovieTextView.setText(movie.getmTitle());
            }
            if (mDescriptionMovieTextView != null) {
                mDescriptionMovieTextView.setText(movie.getmDescription());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mgr.OnClickItem(MovieManager.getInstance().getIdOfMovie(movie));
                }
            });

//            if (mMovieImageView != null) {
//                mMovieImageView.setImageResource(movie.getmMovieImageId());
//            }

        }
    }
}
