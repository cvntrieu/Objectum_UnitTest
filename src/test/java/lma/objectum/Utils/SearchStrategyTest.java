package lma.objectum.Utils;

import lma.objectum.Models.Book;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SearchStrategyTest {

    private List<Book> books;
    private List<Book> result;

    @BeforeEach
    void setUp() {
        books = List.of(
                new Book("111", 9781111111111L, "Theory of Java", "Author1", 4.9, "2010", "Publisher1", "http://image1"),
                new Book("222", 9782222222222L, "Clean Code", "Author2", 4.7, "2010", "Publisher2", "http://image2"),
                new Book("333", 9783333333333L, "Java Practice", "Author3", 4.8, "2010", "Publisher1", "http://image3")
        );
        result = new ArrayList<>();
    }
    // 12 tests
    @Test
    void test1() { // title co ton tai
        SearchStrategy strategy = new TitleSearchStrategy();
        for (Book book : books) {
            if (strategy.match(book, "Java")) {
                result.add(book);
            }
        }
        assertEquals(2, result.size()); // 2 books found: Theory of Java, Java Practice
    }

    @Test
    void test2() { // title ko ton tai
        SearchStrategy strategy = new TitleSearchStrategy();
        for (Book book : books) {
            if (strategy.match(book, "C++")) {
                result.add(book);
            }
        }
        assertTrue(result.isEmpty());
    }

    @Test
    void test3() { // author
        SearchStrategy strategy = new AuthorSearchStrategy();
        for (Book book : books) {
            if (strategy.match(book, "Author1")) {
                result.add(book);
            }
        }
        assertEquals(1, result.size());
        assertEquals("Theory of Java", result.getFirst().getTitle());
    }

    @Test
    void test4() { // isbn
        SearchStrategy strategy = new IsbnSearchStrategy();
        for (Book book : books) {
            if (strategy.match(book, "012345")) {
                result.add(book);
            }
        }
        assertTrue(result.isEmpty());
    }

    @Test
    void getIsbnTest() {
        assertEquals("111", books.getFirst().getIsbn());
    }

    @Test
    void getIsbn_13Test() {
        assertEquals(9781111111111L, books.getFirst().getIsbn_13());
    }

    @Test
    void getTitleTest() {
        assertEquals("Theory of Java", books.getFirst().getTitle());
    }

    @Test
    void getAuthorsTest() {
        assertEquals("Author1", books.getFirst().getAuthors());
    }

    @Test
    void getRatingTest() {
        assertEquals(4.9, books.getFirst().getRating());
    }

    @Test
    void getDateTest() {
        assertEquals("2010", books.getFirst().getDate());
    }

    @Test
    void getPublisherTest() {
        assertEquals("Publisher1", books.getFirst().getPublisher());
    }

    @Test
    void getImageUrlTest() {
        assertEquals("http://image1", books.getFirst().getImageUrl());
    }
}