package com.mynewapp.Models;

/**
 * Created by Arun1234 on 2/18/2017.
 */

public class Album
{
    private String categoryName;
    private int numOfSongs;
    private int categoryThumb;

    public Album() {}

    public Album(String name, int numOfSongs, int thumbnail) {
        this.categoryName = name;
        this.numOfSongs = numOfSongs;
        this.categoryThumb = thumbnail;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getCategoryThumb() {
        return categoryThumb;
    }

    public void setCategoryThumb(int categoryThumb) {
        this.categoryThumb = categoryThumb;
    }
}
