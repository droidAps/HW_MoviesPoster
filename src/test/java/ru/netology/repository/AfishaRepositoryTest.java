package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    Movie one = new Movie(1, "url1", "Матрица", "фантастика");
    Movie two = new Movie(2, "url2", "Последняя дуэль", "драма");
    Movie three = new Movie(3, "url3", "Дюна", "фантастика");
    Movie four = new Movie(4, "url4", "Не время умирать", "боевик");

    @Test
    void saveTest() {
        AfishaRepository repo = new AfishaRepository();
        repo.save(one);
        repo.save(two);

        Movie[] expected = {one, two};
        Movie[] actual = repo.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllTest() {
        Movie[] moviesTest = {one, two, three, four};
        AfishaRepository repo = new AfishaRepository();
        repo.setMovies(moviesTest);

        Movie[] expected = {one, two, three, four};
        Movie[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findByIdTest() {
        Movie[] moviesTest = {one, two, three, four};
        AfishaRepository repo = new AfishaRepository();
        repo.setMovies(moviesTest);

        Movie expected = three;
        Movie actual = repo.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    void removeByIdTest() {
        Movie[] moviesTest = {one, two, three, four};
        AfishaRepository repo = new AfishaRepository();
        repo.setMovies(moviesTest);

        Movie[] expected = {one, three, four};

        repo.removeById(2);
        Movie[] actual = repo.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAllTest() {
        Movie[] moviesTest = {one, two, three, four};
        AfishaRepository repo = new AfishaRepository();
        repo.setMovies(moviesTest);

        Movie[] expected = new Movie[0];

        repo.removeAll();
        Movie[] actual = repo.getMovies();

        assertArrayEquals(expected, actual);
    }
}