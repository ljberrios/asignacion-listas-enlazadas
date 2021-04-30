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
 * This is a class that represents a linked list.
 *
 * @author Antonio F. Huertas {@literal <antonio.huertas@upr.edu>}
 * @author Luis J. Berríos Negrón
 */
public class RecursiveIntLinkedList {

    /**
     * Reference to the first node in the list
     */
    private Node head;
    /**
     * Amount of elements inside the list
     */
    private int size;

    /**
     * Adds an element to the start of this list.
     *
     * @param elem The elements to be added
     */
    public void addFirst(int elem) {
        head = new Node(elem, head);
        size++;
    }

    /**
     * Adds an element to the end of this list.
     *
     * @param elem The elements to be added
     */
    public void addLast(int elem) {
        head = addLast(elem, head);
        size++;
    }

    private Node addLast(int elem, Node curr) {
        if (curr == null)
            curr = new Node(elem, null);
        else
            curr.next = addLast(elem, curr.next);
        return curr;
    }

    /**
     * Returns the sum of the elements in this list.
     *
     * @return The sum of the elements in this list
     */
    public int sumElements() {
        return sum(head);
    }

    private int sum(Node curr) {
        if (curr == null)
            return 0;
        else
            return curr.data + sum(curr.next);
    }


    /**
     * Returns the maximum element in this list.
     *
     * @return The maximum element in this list
     */
    public int maximumElement() {
        if (head == null)
            throw new NoSuchElementException("empty list");
        return maximum(head);
    }

    private int maximum(Node curr) {
        if (curr.next == null)
            return curr.data;
        else
            return Math.max(curr.data, maximum(curr.next));
    }

    /**
     * Get the product of the elements in the list.
     *
     * @return The product of the elements in the list
     */
    public int productOfList() {
        if (head == null)
            throw new NoSuchElementException("empty list");
        return product(head);
    }

    private int product(Node curr) {
        if (curr == null)
            return 1;
        else
            return curr.data * product(curr.next);
    }

    /**
     * Get the average of the elements in the list.
     *
     * @return The average of the elements in the list
     */
    public int averageOfList() {
        if (head == null)
            throw new NoSuchElementException("empty list");
        return sumElements() / size;
    }

    /**
     * Get the minimum element in the list.
     *
     * @return The minimum element in the list
     */
    public int minimumElement() {
        if (head == null)
            throw new NoSuchElementException("empty list");
        return minimum(head);
    }

    private int minimum(Node curr) {
        if (curr.next == null)
            return curr.data;
        else
            return Math.min(curr.data, minimum(curr.next));
    }

    /**
     * Returns the string representation of this list.
     *
     * @return The string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        listToString(head, str);
        return str.append("]").toString();
    }

    private void listToString(Node curr, StringBuilder str) {
        if (curr != null) {
            str.append(curr.data);
            if (curr.next != null)
                str.append(", ");
            listToString(curr.next, str);
        }
    }

    /**
     * Searches for an element in this list.
     *
     * @param elem The element to be searched
     * @return The position of the element or -1 if it is not found
     */
    public int linearSearch(int elem) {
        return linearSearch(elem, 0, head);
    }

    private int linearSearch(int elem, int pos, Node curr) {
        if (curr == null)
            return -1;
        else if (elem == curr.data)
            return pos;
        else
            return linearSearch(elem, pos + 1, curr.next);
    }

    /**
     * Sorts this list using the insertion sort algorithm.
     */
    public void insertionSort() {
        head = insertionSort(head);
    }

    private Node insertionSort(Node curr) {
        if (curr == null)
            return null;
        else
            return insert(curr.data, insertionSort(curr.next));
    }

    private Node insert(int elem, Node curr) {
        if (curr == null)
            curr = new Node(elem, null);
        else if (elem < curr.data)
            curr = new Node(elem, curr);
        else
            curr.next = insert(elem, curr.next);
        return curr;
    }

    /**
     * Private class for a linked list node
     */
    private static class Node {
        /**
         * The data of this node.
         */
        public int data;

        /**
         * The link to the next node.
         */
        public Node next;

        /**
         * Creates a node with the given data and next link.
         *
         * @param data The data of this node
         * @param next The link to the next node.
         */
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}