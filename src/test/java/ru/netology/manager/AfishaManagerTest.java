package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager = new AfishaManager(5);
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
    void shouldAdd() {
        AfishaRepository repo = new AfishaRepository();
        AfishaManager manag = new AfishaManager(repo);
        manag.add(one);
        manag.add(two);
        manag.add(three);
        manag.add(four);

        Movie[] expected = {one, two, three, four};

        Movie[] actual = repo.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        Movie[] returned = {one, two, three, four};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {four, three, two, one};
        Movie[] actual = manager.getAll();

        assertArrayEquals(expected, actual);

        verify(repository).findAll();
    }

    @Test
    void shouldGetLastMoviesNoMoreThanMax() {
        Movie[] returned = {one, two, three, four};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {four, three, two, one};
        Movie[] actual = manager.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetLastMoviesMoreThanMax() {
        Movie[] returned = {one, two, three, four, five, six, seven};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {seven, six, five, four, three};
        Movie[] actual = manager.getLastMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        Movie[] moviesTest = {one, two, three, four};
        AfishaRepository repo = new AfishaRepository();
        repo.setMovies(moviesTest);
        AfishaManager manag = new AfishaManager(repo);
        manag.removeById(3);

        Movie[] expected = {one, two, four};
        Movie[] actual = repo.getMovies();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Movie[] moviesTest = {one, two, three};
        AfishaRepository repo = new AfishaRepository();
        repo.setMovies(moviesTest);
        AfishaManager manag = new AfishaManager(repo);

        Movie expected = two;
        Movie actual = manag.findById(2);
        ;

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        Movie[] moviesTest = {one, two, three, four, five};
        AfishaRepository repo = new AfishaRepository();
        repo.setMovies(moviesTest);
        AfishaManager manag = new AfishaManager(repo);

        Movie[] expected = new Movie[0];

        manag.removeAll();
        Movie[] actual = repo.getMovies();

        assertArrayEquals(expected, actual);
    }
}