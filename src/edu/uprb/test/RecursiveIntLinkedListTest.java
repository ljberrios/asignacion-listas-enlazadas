/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */

package edu.uprb.test;

import edu.uprb.datastructure.RecursiveIntLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * JUnit test case for the {@link RecursiveIntLinkedList} class.
 *
 * @author Antonio F. Huertas {@literal <antonio.huertas@upr.edu>}
 * @author Luis J. Berríos Negrón
 */
public class RecursiveIntLinkedListTest {

    /**
     * Reference to linked list under test
     */
    private RecursiveIntLinkedList lst;

    /**
     * Creates a linked list for testing.
     */
    @BeforeEach
    public void setUp() {
        lst = new RecursiveIntLinkedList();
        lst.addFirst(30);
        lst.addFirst(10);
        lst.addFirst(40);
        lst.addFirst(20);
    }

    /**
     * Tests the sum of a non-empty list is computed as expected.
     */
    @Test
    public void testSumElements() {
        assertEquals(100, lst.sumElements());
    }

    /**
     * Tests the sum of an empty list is computed as expected.
     */
    @Test
    public void testSumElementsForEmptyList() {
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();
        assertEquals(0, empty.sumElements());
    }

    /**
     * Tests the maximum of a non-empty list is computed as expected.
     */
    @Test
    public void testMaximumElement() {
        assertEquals(40, lst.maximumElement());
    }

    /**
     * Tests the maximum of an empty list is computed as expected.
     */
    @Test
    public void testMaximumElementForEmptyList() {
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();

        try {
            int max = empty.maximumElement();
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
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();
        assertEquals("[]", empty.toString());
    }

    /**
     * Tests searching for a valid value in a non-empty list.
     */
    @Test
    public void testLinearSearch() {
        assertEquals(2, lst.linearSearch(10));
    }

    /**
     * Tests searching for an invalid value in a non-empty list.
     */
    @Test
    public void testLinearSearchInvalidValue() {
        assertEquals(-1, lst.linearSearch(5));
    }

    /**
     * Tests searching in an empty list.
     */
    @Test
    public void testLinearSearchForEmptyList() {
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();
        assertEquals(-1, empty.linearSearch(5));
    }

    /**
     * Tests sorting a non-empty list.
     */
    @Test
    public void testInsertionSort() {
        lst.insertionSort();
        assertEquals("[10, 20, 30, 40]", lst.toString());
    }

    /**
     * Tests sorting an empty list.
     */
    @Test
    public void testInsertionSortForEmptyList() {
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();
        empty.insertionSort();
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
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();
        empty.addLast(50);
        assertEquals("[50]", empty.toString());
    }

    /**
     * Tests the product of the elements
     * of a non-empty list is computed as excepted.
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
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();

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
        assertEquals((30 + 10 + 40 + 20) / 4, lst.averageOfList());
    }

    /**
     * Tests the average of the elements of an empty
     * list cannot be computed and an exception is thrown.
     */
    @Test
    public void testAverageForEmptyList() {
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();

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
        RecursiveIntLinkedList empty = new RecursiveIntLinkedList();

        try {
            int minimum = empty.minimumElement();
            fail("Test failure with empty list: minimum=" + minimum);
        } catch (NoSuchElementException ex) {
            assertEquals("empty list", ex.getMessage());
        }
    }

}