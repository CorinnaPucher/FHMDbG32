package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void initializeMovies_returns_not_null() {
        // If an Object is returned
        assertNotNull(Movie.initializeMovies());
    }
    @Test
    void initializeMovies_returns_array_that_is_not_empty() {
        int expected = 0;
        int actual = Movie.initializeMovies().size();
        assertNotEquals(expected, actual);
    }
    @Test
    void if_list_is_sorted_ascending() {
        List<Movie> moviesActual = new ArrayList<>();
        moviesActual.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));
        moviesActual.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));
        moviesActual.add(new Movie("Mach das", "Das ist ein dritter Test", null));

        Collections.sort(moviesActual);

        List<Movie> moviesExpected = new ArrayList<>();
        moviesExpected.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));
        moviesExpected.add(new Movie("Mach das", "Das ist ein dritter Test", null));
        moviesExpected.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));

        assertEquals(moviesExpected,moviesActual);
    }
    @Test
    void if_list_is_sorted_descending() {
        List<Movie> moviesActual = new ArrayList<>();
        moviesActual.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));
        moviesActual.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));
        moviesActual.add(new Movie("Mach das", "Das ist ein dritter Test", null));

        Collections.sort(moviesActual);
        Collections.reverse(moviesActual);

        List<Movie> moviesExpected = new ArrayList<>();
        moviesExpected.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));
        moviesExpected.add(new Movie("Mach das", "Das ist ein dritter Test", null));
        moviesExpected.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));

        assertEquals(moviesExpected,moviesActual);
    }
}