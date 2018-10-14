package de.fh_rosenheim.algorithmen.lecture03;

public class MyArrayStack<Item> {
    private Item[] items;  // stack entries;
    private int n;         // stack size;

    public MyArrayStack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        // TODO
        items[n++] = item;
    }

    public Item pop() {
        // TODO
        return items[--n];

    }
}
