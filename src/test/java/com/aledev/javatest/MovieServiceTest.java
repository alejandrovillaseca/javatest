package com.aledev.javatest;

import com.aledev.javatest.movies.data.MovieRepository;
import com.aledev.javatest.movies.model.Genre;
import com.aledev.javatest.movies.service.MovieService;

import org.junit.Test;
import org.mockito.Mockito;
/**
 * MovieServiceTest
 */
public class MovieServiceTest {

    @Test
    public void return_movies_by_genre(){
        var movieRepository = Mockito.mock(MovieRepository.class);
        
        var service = new MovieService();
        service.findMoviesByGenre(Genre.COMEDY);
    }
}