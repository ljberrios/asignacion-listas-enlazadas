/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */

package edu.uprb.test;

import edu.uprb.datastructure.IntLinkedList_02;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test case for the {@link IntLinkedList_02} class.
 *
 * @author Antonio F. Huertas {@literal <antonio.huertas@upr.edu>}
 * @author Luis J. Berríos Negrón
 */
public class IntLinkedList_02Test {

    /**
     * Reference to linked list under test
     */
    private IntLinkedList_02 lst;

    /**
     * Creates a linked list for testing.
     */
    @BeforeEach
    public void setUp() {
        lst = new IntLinkedList_02();
        lst.addFront(30);
        lst.addFront(10);
        lst.addFront(40);
        lst.addFront(20);
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
        IntLinkedList_02 empty = new IntLinkedList_02();
        assertEquals(0, empty.length());
    }

    /**
     * Tests the sum of a non-empty list is computed as expected.
     */
    @Test
    public void testSumElements() {
        assertEquals(100, lst.sum());
    }

    /**
     * Tests the sum of an empty list is computed as expected.
     */
    @Test
    public void testSumElementsForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();
        assertEquals(0, empty.sum());
    }

    /**
     * Tests the maximum of a non-empty list is computed as expected.
     */
    @Test
    public void testMaximumElement() {
        assertEquals(40, lst.maximum());
    }

    /**
     * Tests the maximum of an empty list is computed as expected.
     */
    @Test
    public void testMaximumElementForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();

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
        assertEquals("[20, 40, 10, 30]", lst.toString());
    }

    /**
     * Tests an empty list has the expected string representation.
     */
    @Test
    public void testToStringForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();
        assertEquals("[]", empty.toString());
    }

    /**
     * Tests adding a value at the end of a non-empty list.
     */
    @Test
    public void testAddLast() {
        lst.addLast(50);
        assertEquals("[20, 40, 10, 30, 50]", lst.toString());
    }

    /**
     * Tests adding a value at the end of an empty list.
     */
    @Test
    public void testAddLastForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();
        empty.addLast(50);
        assertEquals("[50]", empty.toString());
    }

    /**
     * Tests searching a non-empty list for
     * a given key value returns the expected result.
     */
    @Test
    public void testSearch() {
        assertTrue(lst.search(30));
    }

    /**
     * Tests searching an empty list for
     * a given key value returns the expected result.
     */
    @Test
    public void testSearchForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();
        assertFalse(empty.search(30));
    }

    /**
     * Tests clearing a non-empty list removes
     * all the elements in the list as expected.
     */
    @Test
    public void testClear() {
        lst.clear();
        assertEquals("[]", lst.toString());
    }

    /**
     * Tests clearing an empty list cannot
     * be done and an exception is thrown.
     */
    @Test
    public void testClearForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();

        try {
            empty.clear();
            fail("Test failure with empty list: list is already empty");
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

    /**
     * Tests the product of the elements of
     * a non-empty list is computed as expected.
     */
    @Test
    public void testProduct() {
        assertEquals(30 * 10 * 40 * 20, lst.productOfList());
    }

    /**
     * Tests the product of the elements of an empty
     * list cannot be computed and an exception is thrown.
     */
    @Test
    public void testProductForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();

        try {
            int product = empty.productOfList();
            fail("Test failure with empty list: product=" + product);
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

    /**
     * Tests the average of the elements of
     * a non-empty list is computed as expected.
     */
    @Test
    public void testAverage() {
        assertEquals((30 + 10 + 40 + 20) / 4, lst.averageOfList());
    }

    /**
     * Tests the average of the elements of an empty list
     * cannot be computed and an exception is thrown.
     */
    @Test
    public void testAverageForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();

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
        assertEquals(10, lst.minimumElement());
    }

    /**
     * Tests the minimum of an empty list
     * cannot be computed and an exception is thrown.
     */
    @Test
    public void testMinimumForEmptyList() {
        IntLinkedList_02 empty = new IntLinkedList_02();

        try {
            int minimum = empty.minimumElement();
            fail("Test failure with empty list: minimum=" + minimum);
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

}