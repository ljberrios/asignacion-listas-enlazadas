/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */


package edu.uprb.test;

import edu.uprb.datastructure.IntLinkedOrderedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test case for the {@link IntLinkedOrderedList} class.
 *
 * @author Luis J. Berríos Negrón
 */
public class IntLinkedOrderedListTest {

    /**
     * Reference to the class under test.
     */
    IntLinkedOrderedList lst;

    /**
     * Creates an ordered linked list for testing.
     */
    @BeforeEach
    public void setUp() {
        lst = new IntLinkedOrderedList();
        lst.add(4);
        lst.add(1);
        lst.add(3);
        lst.add(2);
    }

    /**
     * Tests the length of a non-empty list is computed as expected.
     */
    @Test
    public void testLength() {
        assertEquals(4, lst.length());
    }

    /**
     * Tests the length of an empty list is computed as expected.
     */
    @Test
    public void testLengthForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();
        assertEquals(0, empty.length());
    }

    /**
     * Tests the sum of the elements of
     * a non-empty list is computed as expected.
     */
    @Test
    public void testSumElements() {
        assertEquals(10, lst.sum());
    }

    /**
     * Tests the sum of the elements
     * of an empty list is computed as expected.
     */
    @Test
    public void testSumElementsForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();
        assertEquals(0, empty.sum());
    }

    /**
     * Tests the maximum of a non-empty
     * list is computed as expected.
     */
    @Test
    public void testMaximumElement() {
        assertEquals(4, lst.maximum());
    }

    /**
     * Tests the maximum of an empty list
     * cannot be computed and an exception is thrown.
     */
    @Test
    public void testMaximumElementForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();

        try {
            int max = empty.maximum();
            fail("Test failure with empty list: max=" + max);
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

    /**
     * Tests a non-empty list has the expected string representation.
     */
    @Test
    public void testToString() {
        assertEquals("[1, 2, 3, 4]", lst.toString());
    }

    /**
     * Tests an empty list has the expected string representation.
     */
    @Test
    public void testToStringForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();
        assertEquals("[]", empty.toString());
    }

    /**
     * Tests searching a non-empty list for a
     * given key value returns the expected result.
     */
    @Test
    public void testSearch() {
        assertTrue(lst.search(4));
    }

    /**
     * Tests searching an empty list for a
     * given key value returns the expected result.
     */
    @Test
    public void testSearchForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();
        assertFalse(empty.search(5));
    }

    /**
     * Tests clearing a non-empty list
     * removes all the elements in the list as expected.
     */
    @Test
    public void testClear() {
        lst.clear();
        assertEquals("[]", lst.toString());
    }

    /**
     * Tests clearing an empty list
     * cannot be done and an exception is thrown.
     */
    @Test
    public void testClearForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();

        try {
            empty.clear();
            fail("Test failure with empty list: list is already empty");
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

    /**
     * Tests the product of the elements
     * of a non-empty list is computed as excepted.
     */
    @Test
    public void testProduct() {
        assertEquals(4 * 3 * 2, lst.productOfList());
    }

    /**
     * Tests the product of the elements of an empty
     * list cannot be computed and an exception is thrown.
     */
    @Test
    public void testProductForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();

        try {
            int product = empty.productOfList();
            fail("Test failure with empty list: product=" + product);
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

    /**
     * Tests the average of the elements
     * of a non-empty list is computed as expected.
     */
    @Test
    public void testAverage() {
        assertEquals(10 / 4, lst.averageOfList());
    }

    /**
     * Tests the average of the elements of an empty
     * list cannot be computed and an exception is thrown.
     */
    @Test
    public void testAverageForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();

        try {
            int average = empty.averageOfList();
            fail("Test failure with empty list: average=" + average);
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

    /**
     * Tests the minimum of a non-empty list is computed as expected.
     */
    @Test
    public void testMinimum() {
        assertEquals(1, lst.minimumElement());
    }

    /**
     * Tests the minimum of an empty list
     * cannot be computed and an exception is thrown.
     */
    @Test
    public void testMinimumForEmptyList() {
        IntLinkedOrderedList empty = new IntLinkedOrderedList();

        try {
            int minimum = empty.minimumElement();
            fail("Test failure with empty list: minimum=" + minimum);
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

}
