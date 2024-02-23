package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Genre genres : genres) {
            stringBuilder.append(genres + ", ");
        }
        stringBuilder.delete(stringBuilder.length() -2, stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        List<Genre> genres = new ArrayList<>();
        Collections.addAll(genres, Genre.ACTION, Genre.ADVENTURE);

        movies.add(new Movie("Mew", "This is a movie , mew",genres));

        genres = new ArrayList<>();
        Collections.addAll(genres, Genre.ACTION);
        movies.add(new Movie("Camonna Tong", "Look at me",genres));

        return movies;
    }
}
