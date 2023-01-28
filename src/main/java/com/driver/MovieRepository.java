package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String,Movie> mdb=new HashMap<>();
    Map<String, Director> ddb=new HashMap<>();

    //for storing director and their respective movie pair
    Map<String,List<String>> pdb=new HashMap<>();

    public String addMovie(Movie movie){
        mdb.put(movie.getName(), movie);
        return "Movie Added Successfully";
    }
    public String addDirector(Director director){
        ddb.put(director.getName(),director);
        return "Director Added Successfully";
    }

    //Didn't understand at first but later found the way
    public String addMovieDirectorPair(String movieName,String directorName){
        //checking if it contains or not
        if(!mdb.containsKey(movieName) || !ddb.containsKey(directorName))
            return "Any of the two is not found";
        //getting the value
        List<String> temp=pdb.getOrDefault(directorName,new ArrayList<>());
        //checking whether the value of director contains the
        if(temp.contains(movieName)) return "Pair already exists";


        //if it doesn't then
        temp.add(movieName);
        pdb.put(directorName,temp);
        return "Director and movie Pair added Successfully";
    }
    public Movie getMovieByName(String movieName){
//        if(!mdb.containsKey(movieName)) return "not present";
        return mdb.get(movieName);
    }
    public Director getDirectorByName(String directorName){
        return ddb.get(directorName);
    }
    public List<String> getMoviesByDirectorName(String directorName){
        if(pdb.containsKey(directorName)) return pdb.get(directorName);
        return null;
    }
    public List<String> findAllMovies(){
        List<String> allMovies=new ArrayList<>();
        for(String i: mdb.keySet()){
            allMovies.add(i);
        }
        return allMovies;
    }
    public String deleteDirectorByName(String directorName){
       List<String> copy=new ArrayList<>();

       //getting the value of pdb
       if (pdb.containsKey(directorName)){
           copy=pdb.get(directorName);
       }
       //iterating and removing all teh movies name from mdb database
       for (String movie:copy){
           if(mdb.containsKey(movie)){
               mdb.remove(movie);
           }
       }
       //removing it from the pair database
       pdb.remove(directorName);

       //removing from the directors' database
       if(ddb.containsKey(directorName)){
           ddb.remove(directorName);
       }
       return "Removed deleteDirectorByName";
    }
    public String deleteAllDirectors(){
        //iterating over the keySet of pdb database
        for (String key:pdb.keySet()){
            List<String> copy=new ArrayList<>();
            copy=pdb.get(key);
            for(String movie:copy){
                if(mdb.containsKey(movie)) mdb.remove(movie);
            }
            pdb.remove(key);
        }

        //removing from the director database
        for (String director: ddb.keySet()){
            ddb.remove(director);
        }
        return "All directors with their respective movies has been removed successfully";
    }
}
