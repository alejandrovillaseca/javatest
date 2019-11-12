package com.aledev.javatest.movies.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.aledev.javatest.movies.data.*;
import com.aledev.javatest.movies.model.*;

public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream().filter(movie -> movie.getGenre() == genre)
                .collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= length)
                .collect(Collectors.toList());
    }

    public Collection<Movie> findByName(String name){
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    public Collection<Movie> findMoviesByTemplate(Movie template) {
        //return movieRepository.findAll()
        return null;
    }
}