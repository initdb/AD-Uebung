package de.fh_rosenheim.algorithmen.lecture03;

public class MyArrayList<Item> {
	
	private Item[] elements;     // array to store elements
	private int n; 		       	 // current number of elements

	public MyArrayList(int capacity) {
		elements = (Item []) new Object[capacity];
		n = 0;
	}

	public Item search(Item x) {
		for (int i = 0; i < n; i++) {
			if (elements[i].equals(x)) {
				return elements[i];
			}
		}
		return null;
	}

	public void insertFront(Item x) throws Exception {
		// TODO
		if (n == elements.length) {
			throw new Exception("No space left");
		}
		for (int i = n; i > 0; i--) {		// shift to right
			elements[i] = elements[i-1];
		}
		elements[0] = x;
		n++;
	}

	public void delete(Item x) {
		for (int i = 0; i < n; i++) {
			if (elements[i].equals(x)) {   // TODO
				elements [i] = null;
				for (int j = i; j < n - 1 ; j++) {
					elements[j] = elements[j+1];  // shift to left
				}
				n--;
				return;
			}
		}
	}
}








