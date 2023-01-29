package com.driver;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class MovieController {
//
//    @Autowired
//    MovieService movieService;
//
//    @PostMapping("/movies/add-movie")
//    public ResponseEntity addMovie(@RequestBody Movie movieName){
//        return new ResponseEntity<>(movieService.addMovie(movieName), HttpStatus.CREATED);
//    }
//    @PostMapping("/movies/add-director")
//    public ResponseEntity addDirector(@RequestBody Director directorName){
//        return new ResponseEntity<>(movieService.addDirector(directorName),HttpStatus.CREATED);
//    }
//    @PutMapping("/movies/add-movie-director-pair")
//    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("directorName") String directorName){
//        return new ResponseEntity<>(movieService.addMovieDirectorPair(movieName,directorName),HttpStatus.ACCEPTED);
//    }
//    @GetMapping("/movies/get-movie-by-name/{movieName}")
//    public ResponseEntity getMovieByName(@PathVariable("movieName") String movieName){
//        return new ResponseEntity<>(movieService.getMovieByName(movieName),HttpStatus.FOUND);
//    }
//    @GetMapping("/movies/get-director-by-name/{directorName}")
//    public ResponseEntity getDirectorByName(@PathVariable("directorName")String directorName){
//        return new ResponseEntity<>(movieService.getDirectorByName(directorName),HttpStatus.FOUND);
//    }
//    @GetMapping("/movies/get-movies-by-director-name/{directorName}")
//    public ResponseEntity getMoviesByDirectorName(@PathVariable("directorName") String directorName ){
//        return new ResponseEntity<>(movieService.getMoviesByDirectorName(directorName),HttpStatus.FOUND);
//    }
//    @GetMapping("/movies/get-all-movies")
//    public ResponseEntity findAllMovies(){
//        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND);
//    }
//    @DeleteMapping("/movies/delete-director-by-name")
//    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
//    return new ResponseEntity<>(movieService.deleteDirectorByName(directorName),HttpStatus.ACCEPTED);
//    }
//    @DeleteMapping("movies/delete-all-directors")
//    public ResponseEntity deleteAllDirectors(){
//        return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.ACCEPTED);
//    }
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("movies")
@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie)
    {
        String response =movieService.addMovie(movie);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director)
    {
        String response =movieService.addDirector(director);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("nameM") String nameM,@RequestParam("nameD") String nameD)
    {
        String response=movieService.addMovieDirectorPair(nameM,nameD);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{nameM}")
    public ResponseEntity getMovieByName(@PathVariable("nameM") String nameM)
    {
        Movie movie = movieService.getMovieByName(nameM);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{nameD}")
    public ResponseEntity getDirectorByName(@PathVariable("nameD") String nameD)
    {
        Director director = movieService.getDirectorByName(nameD);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{nameD}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("nameD") String nameD)
    {
        List<String>ml=new ArrayList<>();

        ml= movieService.getMoviesByDirectorName(nameD);
        return new ResponseEntity<>(ml,HttpStatus.FOUND);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies()
    {
        List<String>ml=new ArrayList<>();
        ml=movieService.findAllMovies();
        return new ResponseEntity(ml,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("nameD") String nameD)
    {
        String response=movieService.deleteDirectorByName(nameD);
        return new ResponseEntity(response,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors()
    {
        String response=movieService.deleteAllDirectors();
        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }


}
