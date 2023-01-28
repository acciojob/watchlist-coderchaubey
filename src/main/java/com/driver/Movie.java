package com.driver;

// String name, int numberOfMovies, double imdbRating,
// no-args constructor, all-args constructor and getters-setters
public class Movie {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    //default constructor
    public Movie() {
    }

    //parameterized constructor
    public Movie(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
