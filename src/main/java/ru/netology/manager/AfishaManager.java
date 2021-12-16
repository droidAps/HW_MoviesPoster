package ru.netology.manager;

import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

@NoArgsConstructor

public class AfishaManager {
    private AfishaRepository repository;
    private int maxMoviesView = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(int maxMoviesView) {
        this.maxMoviesView = maxMoviesView;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getAll() {
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] getLastMovies() {
        Movie[] movies = repository.findAll();
        int resultLength;
        if (movies.length > maxMoviesView) {
            resultLength = maxMoviesView;
        } else {
            resultLength = movies.length;
        }
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Movie findById(int id) {
        Movie result = repository.findById(id);
        return result;
    }

    public void removeAll() {
        repository.removeAll();
    }
}
