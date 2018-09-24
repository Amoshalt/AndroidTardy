package com.example.lomba.firstproject.Manager;

import android.text.TextUtils;

import com.example.lomba.firstproject.Model.Movie;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class MovieManager {

    private static MovieManager movieManager = null;

    private Collection<Movie> movieCollection;

    private MovieManager() {
         this.movieCollection =
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
         this.setMovieCollection();
    }

    public static MovieManager getInstance(){
        if (movieManager == null) {
            movieManager = new MovieManager();

        }
        return movieManager;

    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movieCollection);
    }

    public Movie getMovieById(int id) {
        if (id <0 || id >= movieCollection.size()) {
            return null;
        }
        else  {
            ArrayList movieList = new ArrayList(movieCollection);
            return (Movie) movieList.get(id);
        }
    }

    private void setMovieCollection() {

        for (int i = 64; i>=0; i--) {
            movieCollection.add(new Movie(i,"Title " + i,"Original Title " + i, "Description " + i, "" + i, 1,false));
        }
        movieCollection.add(new Movie(65,"a","b","b","" + 1, 1,false));
        movieCollection.add(new Movie(66,"a","c","c","" + 1, 1,false));
        movieCollection.add(new Movie(67,"a","a","a","" + 1, 1,false));
        movieCollection.add(new Movie(68,"a","d","d","" + 1, 1,false));
        movieCollection.add(new Movie(69,"a","e","e","" + 1, 1,false));


        String lastHeader = "";
        ArrayList<Movie> movies = new ArrayList<>(movieCollection);
        for (int i = 0; i < movieCollection.size(); i++) {
            String header = String.valueOf(movies.get(i).getmTitle().charAt(0)).toUpperCase();
            if (!TextUtils.equals(lastHeader, header)) {
                lastHeader = header;
                movies.get(i).setSection(true);
            }
            if (i == movieCollection.size() - 1) {
                movies.get(i).setSection(true);
            }
        }
    }

}
