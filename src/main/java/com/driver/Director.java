package com.driver;

////String name, int durationInMinutes, double imdbRating,
//// no-args constructor, all-args constructor and getters-setters
//public class Director {
//    private String name;
//    private int durationInMinutes;
//    private double imdbRating;
//
//    //default constructor
//    public Director() {
//    }
//
//    //parameterized constructor
//    public Director(String name, int durationInMinutes, double imdbRating) {
//        this.name = name;
//        this.durationInMinutes = durationInMinutes;
//        this.imdbRating = imdbRating;
//    }
//
//    //getters and setters
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getDurationInMinutes() {
//        return durationInMinutes;
//    }
//
//    public void setDurationInMinutes(int durationInMinutes) {
//        this.durationInMinutes = durationInMinutes;
//    }
//
//    public double getImdbRating() {
//        return imdbRating;
//    }
//
//    public void setImdbRating(double imdbRating) {
//        this.imdbRating = imdbRating;
//    }
//}

public class Director {

    private String name;
    private int numberOfMovies;
    private double imdbRating;

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }

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
    //String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters
}