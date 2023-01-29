package com.driver;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MovieService {
//
//    @Autowired
//    MovieRepository movieRepository;
//
//    public String addMovie(Movie movie){
//
//        return movieRepository.addMovie(movie);
//    }
//
//    public String addDirector(Director director){
//        return movieRepository.addDirector(director);
//    }
//    public String addMovieDirectorPair(String movieName,String directorName){
//        return movieRepository.addMovieDirectorPair(movieName,directorName);
//    }
//    public Movie getMovieByName(String movieName){
//        return movieRepository.getMovieByName(movieName);
//    }
//    public Director getDirectorByName(String directorName){
//        return movieRepository.getDirectorByName(directorName);
//    }
//    public List<String> getMoviesByDirectorName(String directorName){
//        return movieRepository.getMoviesByDirectorName(directorName);
//    }
//    public List<String> findAllMovies(){
//        return movieRepository.findAllMovies();
//    }
//    public String deleteDirectorByName(String directorName){
//        return movieRepository.deleteDirectorByName(directorName);
//    }
//    public String deleteAllDirectors(){
//        return movieRepository.deleteAllDirectors();
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie)
    {
        return movieRepository.addMovie(movie);
    }
    public String addDirector(Director director)
    {
        return movieRepository.addDirector(director);
    }
    public String addMovieDirectorPair(String nameM,String nameD)
    {
        return movieRepository.addMovieDirectorPair(nameM,nameD);
    }
    public Movie getMovieByName(String nameM)
    {
        return movieRepository.getMovieByName(nameM);
    }
    public Director getDirectorByName(String nameD)
    {
        return movieRepository.getDirectorByName(nameD);
    }
    public List<String> getMoviesByDirectorName(String nameD)
    {
        return movieRepository.getMoviesByDirectorName(nameD);
    }
    public List<String> findAllMovies()
    {
        return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String nameD)
    {
        return movieRepository.deleteDirectorByName(nameD);
    }
    public String deleteAllDirectors()
    {
        return movieRepository.deleteAllDirectors();
    }



}