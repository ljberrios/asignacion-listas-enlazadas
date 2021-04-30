/**
 * University of Puerto Rico at Bayamon
 * Department of Computer Science
 * SICI 4036 - Data Structures, Spring 2021
 * Luis J. Berríos Negrón
 * 802-18-1607
 * luis.berrios17@upr.edu
 */

package edu.uprb.datastructure;

import java.util.NoSuchElementException;

/**
 * Represents a doubly linked list of integers.
 */
public class IntDoublyLinkedList {

    /**
     * Represents a doubly linked list node, which is almost the same as
     * a singly linked list node, but differs in that it contains
     * a reference to the previous node.
     */
    private class Node {
        /**
         * Data of the node
         */
        public int data;
        /**
         * Reference to the previous node
         */
        public Node prev;
        /**
         * Reference to the next node
         */
        public Node next;

        /**
         * Construct an instance of a doubly linked list
         * node with the given data, reference to the previous node,
         * and reference to the next node.
         *
         * @param elem The data of the node
         * @param prev The reference to the previous node
         * @param next The reference to the next node
         */
        public Node(int elem, Node prev, Node next) {
            this.data = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Reference to the first node in the list
     */
    private Node head;

    /**
     * Construct an instance of a doubly linked list of integers.
     */
    public IntDoublyLinkedList() {
        head = null;
    }

    /**
     * Add an element to the start of the list.
     *
     * @param elem The element to add
     */
    public void addFront(int elem) {
        head = new Node(elem, null, head);
    }

    /**
     * Add an element to the end of the list.
     *
     * @param elem The element to add
     */
    public void addLast(int elem) {
        Node prev = getLastNode();
        if (head == null)
            head = new Node(elem, null, null);
        else
            prev.next = new Node(elem, prev, null);
    }

    /**
     * Get the last node of the list.
     *
     * @return The last node of the list
     */
    private Node getLastNode() {
        Node trav = head;
        Node prev = null;
        while (trav != null) {
            prev = trav;
            trav = trav.next;
        }
        return prev;
    }

    /**
     * Search the list for the given key value.
     *
     * @param key The key value to search for
     * @return {@code true} if the list contains
     * the given key value, {@code false} if otherwise
     */
    public boolean search(int key) {
        Node trav = head;
        while (trav != null) {
            if (trav.data == key)
                return true;
            trav = trav.next;
        }
        return false;
    }

    /**
     * Get the sum of the elements in the list.
     *
     * @return The sum of the elements in the list
     */
    public int sum() {
        int acum = 0;
        for (Node trav = head; trav != null; trav = trav.next)
            acum += trav.data;
        return acum;
    }

    /**
     * Get the amount of elements in the list.
     *
     * @return The amount of elements in the list
     */
    public int length() {
        int contador = 0;
        Node trav;
        for (trav = head; trav != null; trav = trav.next)
            contador++;
        return contador;
    }

    /**
     * Get the maximum elements in the list.
     *
     * @return The maximum element in the list
     */
    public int maximum() {
        if (head == null)
            throw new NoSuchElementException("empty list");

        int max = head.data;
        Node trav = head.next;
        while (trav != null) {
            if (max < trav.data)
                max = trav.data;
            trav = trav.next;
        }
        return max;
    }

    /**
     * Remove all the elements in the list.
     */
    public void clear() {
        if (head == null)
            throw new NoSuchElementException("empty list");
        head = null;
    }

    /**
     * Get the product of the elements in the list.
     *
     * @return The product of the elements in the list
     */
    public int productOfList() {
        if (head == null)
            throw new NoSuchElementException("empty list");

        int result = 1;
        for (Node trav = head; trav != null; trav = trav.next)
            result *= trav.data;
        return result;
    }

    /**
     * Get the average of the elements in the list.
     *
     * @return The average of the elements in the list
     */
    public int averageOfList() {
        if (head == null)
            throw new NoSuchElementException("empty list");

        int sum = 0;
        int length = 0;
        for (Node trav = head; trav != null; trav = trav.next) {
            sum += trav.data;
            length++;
        }
        return sum / length;
    }

    /**
     * Get the minimum element in the list.
     *
     * @return The minimum element in the list
     */
    public int minimumElement() {
        if (head == null)
            throw new NoSuchElementException("empty list");

        int min = head.data;
        for (Node trav = head; trav != null; trav = trav.next)
            if (min > trav.data)
                min = trav.data;
        return min;
    }

    /**
     * Get the string representation of the list.
     *
     * @return The string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder strBldRef = new StringBuilder("[");
        Node trav = head;
        while (trav != null) {
            strBldRef.append(trav.data);
            if (trav.next != null)
                strBldRef.append(", ");
            trav = trav.next;
        }
        strBldRef.append("]");
        return strBldRef.toString();
    }

}