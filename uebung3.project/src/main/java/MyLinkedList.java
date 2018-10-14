package de.fh_rosenheim.algorithmen.lecture03;

public class MyLinkedList<Item> {

    private class Node {
        Item item;
        Node next;  // next node
        Node prev;  // previous node
    }

    private Node first;
    private int n; 		       	 // current number of elements

    public void insertFront(Item x)  {
        // TODO
        Node oldFirst = first;
        first = new Node();
        first.item = x;
        first.next = oldFirst;
        oldFirst.prev = first;
    }

    public Item search(Item x) {
        // TODO
        Node current = first;

        while (current != null && !current.item.equals(x)) {
            current = current.next;
        }

        if (current.item.equals(x)) {
            return current.item;
        }
        else {
            return null;
        }
    }
}
