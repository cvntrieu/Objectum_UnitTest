package lma.objectum.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest { // 8 tests

    Book book;

    @BeforeEach
    void setUp() {
        book = new Book(
                "111", 9781111111111L, "Theory of Java", "Author1",
                4.9, "2010", "Publisher1", "http://image");
    }

    @Test
    void getIsbnTest() {
        assertEquals("111", book.getIsbn());
    }

    @Test
    void getIsbn_13Test() {
        assertEquals(9781111111111L, book.getIsbn_13());
    }

    @Test
    void getTitleTest() {
        assertEquals("Theory of Java", book.getTitle());
    }

    @Test
    void getAuthorsTest() {
        assertEquals("Author1", book.getAuthors());
    }

    @Test
    void getRatingTest() {
        assertEquals(4.9, book.getRating());
    }

    @Test
    void getDateTest() {
        assertEquals("2010", book.getDate());
    }

    @Test
    void getPublisherTest() {
        assertEquals("Publisher1", book.getPublisher());
    }

    @Test
    void getImageUrlTest() {
        assertEquals("http://image", book.getImageUrl());
    }
}