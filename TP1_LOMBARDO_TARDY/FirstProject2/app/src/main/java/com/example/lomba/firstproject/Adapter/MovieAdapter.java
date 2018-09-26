package com.example.lomba.firstproject.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lomba.firstproject.Interfaces.IItemOnCLickManager;
import com.example.lomba.firstproject.Model.Movie;
import com.example.lomba.firstproject.R;
import com.example.lomba.firstproject.ViewHolder.LetterViewHolder;
import com.example.lomba.firstproject.ViewHolder.MoviesViewHolder;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter {

    private static final int SECTION_VIEW = 0;
    private static final int CONTENT_VIEW = 1;
    private List<Movie> mMovies;
    private int nbMovies = 0;

    private IItemOnCLickManager mgr;

    public void setClickManager(IItemOnCLickManager mgr) {
        this.mgr = mgr;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View mViewLetter = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.letter, viewGroup, false);
        View mViewMovie = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie, viewGroup, false);

        if (i == SECTION_VIEW) {
            LetterViewHolder vh = new LetterViewHolder(mViewLetter);
            vh.setClickManager(mgr);
            return vh;
        } else {
            MoviesViewHolder vh = new MoviesViewHolder(mViewMovie);
            vh.setClickManager(mgr);
            return vh;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Movie currentMovie = mMovies.get(i);

        if (SECTION_VIEW == getItemViewType(i)) {

            LetterViewHolder letterViewHolder= (LetterViewHolder) viewHolder;
            char c = mMovies.get(i).getmTitle().charAt(0);

            if (i == mMovies.size() -1) {
                c = ' ';
            }
            letterViewHolder.layoutforLetter(c,nbMovies);
            nbMovies = 0;
            return;
        }

        if (currentMovie != null) {
            MoviesViewHolder moviesViewHolder = (MoviesViewHolder) viewHolder;
            moviesViewHolder.layoutforMovie(currentMovie);
        }
        nbMovies++;
    }

    @Override
    public int getItemCount() {
        if (mMovies != null) {
            return mMovies.size();
        } else return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMovies.get(position).isSection()) {
            return SECTION_VIEW;
        } else {
            return CONTENT_VIEW;
        }
    }

    public void setmMovies(List<Movie> mMovies) {
        this.mMovies = mMovies;
    }
}
