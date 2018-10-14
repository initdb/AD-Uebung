package de.fh_rosenheim.algorithmen.lecture03;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item>  {
    private Item[] items;       // queue elements
    private int n;          // number of elements on queue
    private int head;      // index of head element of queue
    private int tail;       // index of next available slot


    /**
     * Initializes an empty queue.
     */
    public MyArrayQueue() {
        items = (Item[]) new Object[2];
        n = 0;
        head = 0;
        tail = 0;
    }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    // resize the underlying array
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = items[(head + i) % items.length];
        }
        items = temp;
        head = 0;
        tail = n;
    }

    /**
     * Adds the item to this queue.
     * @param item the item to add
     */
    public void enqueue(Item item) {
        // double size of array if necessary and recopy to front of array
        if (n == items.length) resize(2* items.length);   // double size of array if necessary
        items[tail++] = item;                        // add item
        if (tail == items.length) tail = 0;          // wrap-around
        n++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = items[head];
        items[head] = null;                            // to avoid loitering
        n--;
        head++;
        if (head == items.length) head = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == items.length/4) resize(items.length/2);
        return item;
    }


}