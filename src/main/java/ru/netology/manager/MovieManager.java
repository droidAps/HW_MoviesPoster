package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {
    private int maxMoviesView = 10;
    private Movie[] moviesPoster = new Movie[0];

    public MovieManager(int maxMoviesView) {
        this.maxMoviesView = maxMoviesView;
    }

    public Movie[] getMoviesPoster() {
        return moviesPoster;
    }

    public Movie[] getLastMovies() {
        int resultLength;
        if (moviesPoster.length > maxMoviesView) {
            resultLength = maxMoviesView;
        } else {
            resultLength = moviesPoster.length;
        }

        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = moviesPoster.length - i - 1;
            result[i] = moviesPoster[index];
        }
        return result;
    }

    public void addMovie(Movie movie) {
        int length = moviesPoster.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(moviesPoster, 0, tmp, 0,moviesPoster.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        moviesPoster = tmp;
    }

}
