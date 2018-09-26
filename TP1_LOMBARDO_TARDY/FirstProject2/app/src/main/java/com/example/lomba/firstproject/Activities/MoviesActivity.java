package com.example.lomba.firstproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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

    private ImageView imgViewClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_list);
        MovieAdapter movieAdapter = new MovieAdapter();
        movieAdapter.setmMovies(this.setMoviesList());
        this.mRecyclerView = findViewById(R.id.movieListRecyclerView);

        imgViewClose = findViewById(R.id.closeButton);

        movieAdapter.setClickManager(this);
        this.mRecyclerView.setAdapter(movieAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        backLayout = findViewById(R.id.backLayout);
        backLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goBack(v);
            }
        });
        imgViewClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                closeIt(v);
            }
        });
    }

    private void goBack(View v) {
        Intent i = new Intent(this, CategoriesActivity.class);
        startActivity(i);
    }

    private void closeIt(View v) {

        finishAffinity();
        System.exit(0);
    }


    public List<Movie> setMoviesList (){
        return MovieManager.getInstance().getMovies();
    }


    @Override
    public void OnClickItem(Object object) {
        int movieId = (int) object;
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("MOVIE_ID", movieId);
        startActivity(i);
    }
}
