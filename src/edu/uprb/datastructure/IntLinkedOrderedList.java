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
 * Represents an ordered singly linked list of integers.
 */
public class IntLinkedOrderedList {

    /**
     * Represents a singly linked list node.
     */
    private class Node {
        /**
         * Data of the node
         */
        public int data;
        /**
         * Reference to the next node
         */
        public Node next;

        /**
         * Construct a singly linked list node with
         * the given data and reference to the next node.
         *
         * @param data Data of the node
         * @param next Reference to the next node
         */
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Reference to the first node in the list.
     */
    private Node head;

    /**
     * Construct an instance of an ordered singly linked list.
     */
    public IntLinkedOrderedList() {
        head = null;
    }

    /**
     * Add an element to the list, while keeping the list in order.
     *
     * @param elem The element to add
     */
    public void add(int elem) {
        if (head == null) {
            head = new Node(elem, null);
            return;
        }

        Node trav = head;
        Node prev = null;
        while (trav != null) {
            if (elem > trav.data) {
                prev = trav;
                trav = trav.next;
            } else {
                if (prev == null) {
                    head = new Node(elem, trav);
                } else {
                    prev.next = new Node(elem, trav);
                }
                return;
            }
        }
        trav = new Node(elem, null);
        prev.next = trav;
    }

    /**
     * Get the last node in the list.
     *
     * @return The last node in the list
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
     * @return {@code true} if the list contains the
     * given key value, {@code false} if otherwise
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
     * Get the maximum element in the list.
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