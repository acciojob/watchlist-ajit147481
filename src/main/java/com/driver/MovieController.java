package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String responce=movieService.addMovie(movie);
        return new ResponseEntity<>(responce,HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String responce=movieService.addDirector(director);
        return new ResponseEntity<>(responce,HttpStatus.OK);
    }

    @PutMapping("/addMovieDectorPair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestBody() Pair pair){
        String responce=movieService.addMovieDirectorPair(pair);
        return new ResponseEntity<>(responce,HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name") String name) {
        Movie movie=movieService.getMovieByName(name);
        if(movie==null){
            return new ResponseEntity<>(movie,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name") String name){
        Director director=movieService.getDirectorByName(name);
        if(director==null){
            return new ResponseEntity<>(director,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }
}


