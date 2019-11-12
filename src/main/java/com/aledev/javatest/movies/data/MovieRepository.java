package com.aledev.javatest.movies.data;

import com.aledev.javatest.movies.model.*;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);
}