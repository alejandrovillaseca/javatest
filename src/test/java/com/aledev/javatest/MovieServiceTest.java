package com.aledev.javatest;

import com.aledev.javatest.movies.data.MovieRepository;
import com.aledev.javatest.movies.model.Genre;
import com.aledev.javatest.movies.model.Movie;
import com.aledev.javatest.movies.service.MovieService;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertThat;

/**
 * MovieServiceTest
 */
public class MovieServiceTest {
    private MovieService movieService;

    @Before
    public void setup() {
        var movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll())
                .thenReturn(Arrays.asList(new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Momento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER), new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY), new Movie(7, "Matrix", 136, Genre.ACTION)));
        movieService = new MovieService(movieRepository);
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    public void return_movies_by_genre() {
        var movies = movieService.findMoviesByGenre(Genre.COMEDY);
        // Get returned ID's
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 6)));
    }


    @Test
    public void return_movies_by_length() {
        var movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void findByName() {
        var movies  = movieService.findByName("Super");
        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(4,"Super 8", 112, Genre.THRILLER)
        )));
    }
}