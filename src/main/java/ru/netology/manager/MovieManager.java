package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {
    private int maxMoviesView = 10;

    Movie one = new Movie (1,"url1", "Матрица", "фантастика");
    Movie two = new Movie(2,"url2", "Последняя дуэль", "драма");
    Movie three = new Movie(3,"url3", "Дюна", "фантастика");
    Movie four = new Movie(4, "url4","Не время умирать", "боевик");
    Movie five = new Movie(5,"url5", "Король Лир", "драма");
    Movie six = new Movie(6,"url6", "Аннетт", "драма");
    Movie seven = new Movie(7,"url7", "Ходячий замок", "мультфильм");
    Movie eight = new Movie(8,"url8", "Номер один", "комедия");
    Movie nine = new Movie(9,"url9", "Тролли. Мировой тур", "мультфильм");
    Movie ten = new Movie(10,"url10", "Человек-невидимка", "ужасы");

    private Movie[] moviesPoster = {one,
            two,
            three,
            four,
            five,
            six,
            seven,
            eight,
            nine,
            ten};

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
