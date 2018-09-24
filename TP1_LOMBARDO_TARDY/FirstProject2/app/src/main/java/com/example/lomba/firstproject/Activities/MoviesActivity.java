package com.example.lomba.firstproject.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.lomba.firstproject.Adapter.MovieAdapter;
import com.example.lomba.firstproject.Interfaces.IItemOnCLickManager;
import com.example.lomba.firstproject.Manager.MovieManager;
import com.example.lomba.firstproject.Model.Movie;
import com.example.lomba.firstproject.R;

import java.util.List;

public class MoviesActivity extends AppCompatActivity implements IItemOnCLickManager {

    private RecyclerView mRecyclerView;

    private RelativeLayout backLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_list);
        MovieAdapter movieAdapter = new MovieAdapter();
        movieAdapter.setmMovies(this.setMoviesList());
        this.mRecyclerView = findViewById(R.id.movieListRecyclerView);
        this.mRecyclerView.setAdapter(movieAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {}
        });
    }


    public List<Movie> setMoviesList (){
        return MovieManager.getInstance().getMovies();
    }


    @Override
    public void OnClickItem(Object object) {

    }
}
