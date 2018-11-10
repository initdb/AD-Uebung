package de.fh_rosenheim.algorithmen.lecture06;

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * simple hash table that stores arbitrary objects as value uses chaining to
 * resolve collisions
 * 
 * @author muwo522
 *
 */
public class HashTableChaining {

	// size of hash table
	private final static int TABLE_SIZE = 5;

	// array that implements hash table
	private ArrayList<LinkedList<HashEntry>> table;

	// constructor, initial ArrayList with 10 entries; each entry empty
	// LinkedList
	HashTableChaining() {
		table = new ArrayList<LinkedList<HashEntry>>();
		for (int i = 0; i < TABLE_SIZE; i++) {
			table.add(new LinkedList<HashEntry>());
		}
	}

	// compute hash value for key
	private int hash(int key) {
		// TODO
		return key % TABLE_SIZE;
	}

	// get HashEntry that has key k 
	public HashEntry search(int k) {
		//TODO
		int  h = hash(k);

		LinkedList<HashEntry> list = table.get(h);
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getKey() == k ) {
				return list.get(i);
			}
		}
		return null;

	}


	// insert value (key, value)
	public void insert(HashEntry entry) {
		int key = entry.getKey();
		int h = hash(entry.getKey());

		LinkedList<HashEntry> l = table.get(h);
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getKey() == key) {
				return;			// key bereits gespeichert
			}
		}
		l.add(entry);
	}

	public void printHash() {
		System.out.println("Die Hashtabelle hat folgende Eintr�ge");
		for (int i = 0; i < TABLE_SIZE; i++) {
			LinkedList<HashEntry> l = table.get(i);
			System.out.print("i=" + i + ": ");
			for (int j=0; j < l.size(); j++) {
				System.out.print("j=" + j  + " -> Key: " + l.get(j).getKey() + "\t");
			}
			System.out.println("");
		}
	}
      
}





