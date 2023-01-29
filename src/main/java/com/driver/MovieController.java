package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movieName){
        return new ResponseEntity<>(movieService.addMovie(movieName), HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director directorName){
        return new ResponseEntity<>(movieService.addDirector(directorName),HttpStatus.CREATED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movieName") String movieName,@RequestParam("directorName") String directorName){
        return new ResponseEntity<>(movieService.addMovieDirectorPair(movieName,directorName),HttpStatus.ACCEPTED);
    }
    @GetMapping("/movies/get-movie-by-name/{movieName}")
    public ResponseEntity getMovieByName(@PathVariable("movieName") String movieName){
        return new ResponseEntity<>(movieService.getMovieByName(movieName),HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-director-by-name/{directorName}")
    public ResponseEntity getDirectorByName(@PathVariable("directorName")String directorName){
        return new ResponseEntity<>(movieService.getDirectorByName(directorName),HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-movies-by-director-name/{directorName}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("directorName") String directorName ){
        return new ResponseEntity<>(movieService.getMoviesByDirectorName(directorName),HttpStatus.FOUND);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.FOUND);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("directorName") String directorName){
    return new ResponseEntity<>(movieService.deleteDirectorByName(directorName),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return new ResponseEntity<>(movieService.deleteAllDirectors(),HttpStatus.ACCEPTED);
    }
}
