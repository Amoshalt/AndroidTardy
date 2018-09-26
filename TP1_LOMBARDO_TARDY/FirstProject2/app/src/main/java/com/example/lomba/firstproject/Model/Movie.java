package com.example.lomba.firstproject.Model;

public class Movie {

    private String mTitle;
    private String mOriginalTitle;
    private String mDescription;
    private String mKeyWords;
    private boolean isSection;
    private int mMovieImageId;

    public Movie(String mTitle, String mOriginalTitle, String mDescription, String mKeyWords, int mMovieImageId, boolean isSection) {
        this.mTitle = mTitle;
        this.mOriginalTitle = mOriginalTitle;
        this.mDescription = mDescription;
        this.mKeyWords = mKeyWords;
        this.mMovieImageId = mMovieImageId;
        this.isSection = isSection;
    }

    public int getmMovieImageId() {
        return mMovieImageId;
    }

    public void setmMovieImageId(int mMovieImageId) {
        this.mMovieImageId = mMovieImageId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmOriginalTitle() {
        return mOriginalTitle;
    }

    public void setmOriginalTitle(String mOriginalTitle) {
        this.mOriginalTitle = mOriginalTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmKeyWords() {
        return mKeyWords;
    }

    public void setmKeyWords(String mKeyWords) {
        this.mKeyWords = mKeyWords;
    }

    public boolean isSection() {
        return isSection;
    }

    public void setSection(boolean section) {
        isSection = section;
    }

}
