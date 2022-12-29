package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        String result=movieRepository.addMovie(movie);
        return result;
    }

    public String addDirector(Director director) {
        String result=movieRepository.addDirector(director);
        return result;
    }

    public String addMovieDirectorPair(String movieName,String directorName) {
        String result=movieRepository.addMovieDirectorPair(movieName,directorName);
        return result;
    }

    public Movie getMovieByName(String name) {
        Movie movie=movieRepository.getMovieByName(name);
        return movie;
    }

    public Director getDirectorByName(String name) {
        Director director=movieRepository.getDirectorByName(name);
        return director;
    }

    public List<String> findAllMovies() {
        List<String> list=movieRepository.findAllMovies();
        return list;
    }

    public void deleteDirectorByName(String name) {
        movieRepository.deleteDirectorByName(name);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }

    public List<String> getMoviesByDirectorName(String name) {
        List<String> list=movieRepository.getMoviesByDirectorName(name);
        return list;
    }
}
