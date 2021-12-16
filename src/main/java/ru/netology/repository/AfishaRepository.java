package ru.netology.repository;

import ru.netology.domain.Movie;

public class AfishaRepository {
    private Movie[] movies = new Movie[0];

    public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

//    findAll - возвращает массив всех хранящихся в массиве объектов
//    save - добавляет объект в массив
//    findById - возвращает объект по идентификатору (либо null, если такого объекта нет)
//    removeById - удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
//    removeAll - полностью вычищает репозиторий

    public void save(Movie movie) {
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movie[] findAll() {
        return movies;
    }

    public Movie findById(int id) {
        Movie result = new Movie();
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                result = movie;
            }
        }
        return result;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        Movie[] tmp = new Movie[0];
        movies = tmp;
    }
}