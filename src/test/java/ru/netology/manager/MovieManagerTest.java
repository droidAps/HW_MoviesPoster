package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    Movie one = new Movie(1, "url1", "Матрица", "фантастика");
    Movie two = new Movie(2, "url2", "Последняя дуэль", "драма");
    Movie three = new Movie(3, "url3", "Дюна", "фантастика");
    Movie four = new Movie(4, "url4", "Не время умирать", "боевик");
    Movie five = new Movie(5, "url5", "Король Лир", "драма");
    Movie six = new Movie(6, "url6", "Аннетт", "драма");
    Movie seven = new Movie(7, "url7", "Ходячий замок", "мультфильм");
    Movie eight = new Movie(8, "url8", "Номер один", "комедия");
    Movie nine = new Movie(9, "url9", "Тролли. Мировой тур", "мультфильм");
    Movie ten = new Movie(10, "url10", "Человек-невидимка", "ужасы");

    @Test
    void shouldGetLastMoviesNoMoreThanMax() {
        MovieManager manager = new MovieManager();
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);

        Movie[] expected = {ten,
                nine,
                eight,
                seven,
                six,
                five,
                four,
                three,
                two,
                one};

        Movie[] actual = manager.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesMoreThanMax() {
        MovieManager manager = new MovieManager(5);
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);

        Movie[] expected = {ten,
                nine,
                eight,
                seven,
                six};

        Movie[] actual = manager.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddMovie() {
        Movie movie = new Movie(11, "url11", "Люси", "боевик");
        MovieManager manager = new MovieManager();
        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);
        manager.addMovie(movie);

        Movie[] expected = {one,
                two,
                three,
                four,
                five,
                six,
                seven,
                eight,
                nine,
                ten,
                movie};

        Movie[] actual = manager.getMoviesPoster();

        assertArrayEquals(expected, actual);
    }
}