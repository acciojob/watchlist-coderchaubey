package com.driver;

//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class MovieRepository {
//
//    Map<String,Movie> mdb=new HashMap<>();
//    Map<String, Director> ddb=new HashMap<>();
//
//    //for storing director and their respective movie pair
//    Map<String,List<String>> pdb=new HashMap<>();
//
//    public String addMovie(Movie movie){
//        mdb.put(movie.getName(), movie);
//        return "Movie Added Successfully";
//    }
//    public String addDirector(Director director){
//        ddb.put(director.getName(),director);
//        return "Director Added Successfully";
//    }
//
//    //Didn't understand at first but later found the way
//    public String addMovieDirectorPair(String movieName,String directorName){
//        //checking if it contains or not
//        if(!mdb.containsKey(movieName) || !ddb.containsKey(directorName))
//            return "Any of the two is not found";
//        //getting the value
//        List<String> temp=pdb.getOrDefault(directorName,new ArrayList<>());
//        //checking whether the value of director contains the
//        if(temp.contains(movieName)) return "Pair already exists";
//
//
//        //if it doesn't then
//        temp.add(movieName);
//        pdb.put(directorName,temp);
//        return "Director and movie Pair added Successfully";
//    }
//    public Movie getMovieByName(String movieName){
////        if(!mdb.containsKey(movieName)) return "not present";
//        return mdb.get(movieName);
//    }
//    public Director getDirectorByName(String directorName){
//        return ddb.get(directorName);
//    }
//    public List<String> getMoviesByDirectorName(String directorName){
//        if(pdb.containsKey(directorName)) return pdb.get(directorName);
//        return null;
//    }
//    public List<String> findAllMovies(){
//        List<String> allMovies=new ArrayList<>();
//        for(String i: mdb.keySet()){
//            allMovies.add(i);
//        }
//        return allMovies;
//    }
//    public String deleteDirectorByName(String directorName){
//       List<String> copy=new ArrayList<>();
//
//       //getting the value of pdb
//       if (pdb.containsKey(directorName)){
//           copy=pdb.get(directorName);
//       }
//       //iterating and removing all teh movies name from mdb database
//       for (String movie:copy){
//           if(mdb.containsKey(movie)){
//               mdb.remove(movie);
//           }
//       }
//       //removing it from the pair database
//       pdb.remove(directorName);
//
//       //removing from the directors' database
//       if(ddb.containsKey(directorName)){
//           ddb.remove(directorName);
//       }
//       return "Removed deleteDirectorByName";
//    }
//    public String deleteAllDirectors(){
//        //iterating over the keySet of pdb database
//        for (String key:pdb.keySet()){
//            List<String> copy=new ArrayList<>();
//            copy=pdb.get(key);
//            for(String movie:copy){
//                if(mdb.containsKey(movie)) mdb.remove(movie);
//            }
//            pdb.remove(key);
//        }
//
//        //removing from the director database
//        for (String director: ddb.keySet()){
//            ddb.remove(director);
//        }
//        return "All directors with their respective movies has been removed successfully";
//    }
//}


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie>Mdb=new HashMap<>();
    HashMap<String,Director>Ddb=new HashMap<>();
    HashMap<String, List<String>>Pdb=new HashMap<>();

    public String addMovie(Movie movie)
    {
        String name=movie.getName();
        Mdb.put(name,movie);
        return "Movie added successfully";
    }
    public String addDirector(Director director)
    {
        String name=director.getName();
        Ddb.put(name,director);
        return "Director added successfully";
    }
    public String addMovieDirectorPair(String nameM,String nameD) {
        if(!Mdb.containsKey(nameM) || !Ddb.containsKey(nameD)) return "Movie or Director not found in database";
        List<String>ml = Pdb.getOrDefault(nameD, new ArrayList<>());
        if(ml.contains(nameM)) return "Pair already exists";
        ml.add(nameM);
        Pdb.put(nameD,ml);
        return "Pair added successfully";
    }
    public Movie getMovieByName(String nameM)
    {
        if(Mdb.containsKey(nameM))
        {
            return Mdb.get(nameM);
        }
        return null ;
    }
    public Director getDirectorByName(String nameD)
    {
        if(Ddb.containsKey(nameD))
        {
            return Ddb.get(nameD);
        }
        return null;
    }
    public List<String> getMoviesByDirectorName(String nameD)
    {
        if(Pdb.containsKey(nameD))
        {
            return Pdb.get(nameD);
        }
        return null;
    }
    public List<String> findAllMovies()
    {
        List<String>allmovie=new ArrayList<>();
        for(String m:Mdb.keySet())
        {
            allmovie.add(m);
        }
        return allmovie;
    }
    public String deleteDirectorByName(String nameD)
    {
        List<String>ml=new ArrayList<>();
        if(Pdb.containsKey(nameD))
        {
            ml=Pdb.get(nameD);
        }
        for(String movie:ml)
        {
            if(Mdb.containsKey(movie))
            {
                Mdb.remove(movie);
            }
        }
        Pdb.remove(nameD);
        if(Ddb.containsKey(nameD))
        {
            Ddb.remove(nameD);
        }
        return "Director and its movies removed successfully";
    }
    public String deleteAllDirectors()
    {
        for(String D:Pdb.keySet())
        {
            List<String>dml=new ArrayList<>();
            dml=Pdb.get(D);
            for(String movie:dml)
            {
                if(Mdb.containsKey(movie))
                {
                    Mdb.remove(movie);
                }
            }
            Pdb.remove(D);
        }
        for(String D:Ddb.keySet())
        {
            Ddb.remove(D);
        }
        return "All directors and all of their movies removed successfully";

    }


}