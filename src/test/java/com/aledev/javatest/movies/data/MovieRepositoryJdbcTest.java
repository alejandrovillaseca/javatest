package com.aledev.javatest.movies.data;

import com.aledev.javatest.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import static com.aledev.javatest.movies.model.Genre.ACTION;
import static com.aledev.javatest.movies.model.Genre.THRILLER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRepositoryJdbcTest {
    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {
        var movies = movieRepository.findAll();
        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "Matrix", 136, ACTION)
        )));

    }

    @Test
    public void load_by_id() {
        var movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, THRILLER)));
    }

    @Test
    public void insert_movie() {
        var movie = new Movie("Super 8", 12, THRILLER);
        movieRepository.saveOrUpdate(movie);
        var movieFromDb = movieRepository.findById(4);
        assertThat(movieFromDb, is(new Movie(4, "Super 8", 12, THRILLER)));
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("DROP ALL objects DELETE files");
    }
}
