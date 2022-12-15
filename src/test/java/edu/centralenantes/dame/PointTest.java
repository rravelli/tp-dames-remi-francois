package edu.centralenantes.dame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author inky19
 */
public class PointTest {

    public PointTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValid method, of class Point.
     */
    @Test
    public void testIsValid() {
        System.out.println("Test Point.isValid()");
        Point validPoint00 = new Point(0, 0);
        Point validPoint99 = new Point(9, 9);
        Point invalidPointn1n1 = new Point(-1, -1);
        Point invalidPoint153 = new Point(15, 3);
        Point invalidPoint103 = new Point(10, 3);
        assertEquals(true, validPoint00.isValid(), "Test failed with point" + validPoint00.toString());
        assertEquals(true, validPoint99.isValid(), "Test failed with point" + validPoint99.toString());
        assertEquals(false, invalidPointn1n1.isValid(), "Test failed with point" + invalidPointn1n1.toString());
        assertEquals(false, invalidPoint153.isValid(), "Test failed with point" + invalidPoint153.toString());
        assertEquals(false, invalidPoint103.isValid(), "Test failed with point" + invalidPoint103.toString());
    }

    /**
     * Test of toString method, of class Point.
     */
    @Test
    public void testToString() {
        System.out.println("Test Point.toString()");
        Point p23 = new Point(2, 3);
        assertEquals(p23.toString(), "2, 3");
        Point p810 = new Point(8, 10);
        assertEquals(p810.toString(), "8, 10");
        Point pn15 = new Point(-1, 5);
        assertEquals(pn15.toString(), "-1, 5");
    }

    /**
     * Test of equals method, of class Point.
     */
    @Test
    public void testEquals() {
        System.out.println("Test Point.equals()");
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-6, -1);
        Point p3 = new Point(1, 1);
        assertEquals(p1.equals(p1), true);
        assertEquals(p1.equals(null), false);
        assertEquals(p1.equals(p2), false);
        assertEquals(p1.equals(p3), true);

    }

}
