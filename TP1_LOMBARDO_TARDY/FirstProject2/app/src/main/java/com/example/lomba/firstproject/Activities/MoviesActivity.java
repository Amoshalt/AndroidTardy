package com.example.lomba.firstproject.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.lomba.firstproject.Adapter.MovieAdapter;
import com.example.lomba.firstproject.Model.Movie;
import com.example.lomba.firstproject.R;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MoviesActivity extends AppCompatActivity {

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
        Collection<Movie> movieCollection =
                new TreeSet<Movie>(new Comparator<Movie>() {
                    @Override
                    public int compare(Movie movie, Movie t1) {
                        Collator usCollator = Collator.getInstance();
                        usCollator.setStrength(Collator.PRIMARY);
                        int comp = usCollator.compare(movie.getmTitle(), t1.getmTitle());
                        if(comp == 0) {
                            int comp2 = usCollator.compare(movie.getmOriginalTitle(), t1.getmOriginalTitle());
                            if(comp2 == 0) {
                                return 1;
                            } else return comp2;
                        } else return comp;
                    }
                });
        for (int i = 64; i>=0; i--) {
            movieCollection.add(new Movie("Title " + i,"Original Title " + i, "Description " + i, new String[]{"" + i, ""}, i,false));
        }
        movieCollection.add(new Movie("a","b","b",new String[]{"" + 1, ""}, 1,false));
        movieCollection.add(new Movie("a","c","c",new String[]{"" + 1, ""}, 1,false));
        movieCollection.add(new Movie("a","a","a",new String[]{"" + 1, ""}, 1,false));
        movieCollection.add(new Movie("a","d","d",new String[]{"" + 1, ""}, 1,false));
        movieCollection.add(new Movie("a","e","e",new String[]{"" + 1, ""}, 1,false));


        String lastHeader = "";
        ArrayList<Movie> movies = new ArrayList<>(movieCollection);
        for (int i = 0; i < movieCollection.size(); i++) {
            String header = String.valueOf(movies.get(i).getmTitle().charAt(0)).toUpperCase();
            if (!TextUtils.equals(lastHeader, header)) {
                lastHeader = header;
                movies.get(i).setSection(true);
            }
        }

        return new ArrayList<>(movieCollection);
    };


}
