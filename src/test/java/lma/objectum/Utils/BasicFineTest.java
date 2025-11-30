package lma.objectum.Utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class BasicFineTest {

    private BasicFine fine; // BasicFine nam trong Utils, ko can controller

    @BeforeEach
    void setUp() {
       fine = new BasicFine();
    }

    @Test
    void test1() {
        Date returnDate = Date.valueOf("2010-01-31");
        Date dueDate = Date.valueOf("2010-01-31");
        assertEquals(0, fine.calculateFine(returnDate, dueDate));
    }

    @Test
    void test2() {
        Date returnDate = Date.valueOf("2010-02-01");
        Date dueDate = Date.valueOf("2010-01-31");
        assertEquals(1, fine.calculateFine(returnDate, dueDate));
    }

    @Test
    void test3() {
        Date returnDate = Date.valueOf("2010-02-03");
        Date dueDate = Date.valueOf("2010-01-31");
        assertEquals(3, fine.calculateFine(returnDate, dueDate));
    }

    @Test
    void test4() {
        Date returnDate = Date.valueOf("2010-01-30");
        Date dueDate = Date.valueOf("2010-01-31");
        assertEquals(0, fine.calculateFine(returnDate, dueDate));
    }
}