package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie(1, "Inception", "2010","Christopher Nolan", 8);
    }

    @Test
    public void testGetId() throws Exception {
        assertEquals(movie.getId(), 1);
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals(movie.getName(), "Inception");
    }

    @Test
    public void testGetYear() throws Exception {
        assertEquals(movie.getYear(), "2010");
    }

    @Test
    public void testGetDirector() throws Exception {
        assertEquals(movie.getDirector(), "Christopher Nolan");
    }

    @Test
    public void testGetRating() throws Exception {
        assertEquals(movie.getMovieRating(), 8);
    }

    @Test
    public void testGetUnrated() throws Exception {
        Movie newMovie = new Movie(1, "Inception", "2010","Christopher Nolan", 0);
        assertEquals(newMovie.getMovieRatingString(), "Unrated");
    }

    // test set rating
}