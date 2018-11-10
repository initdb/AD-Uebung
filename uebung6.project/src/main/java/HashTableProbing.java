package de.fh_rosenheim.algorithmen.lecture06;


/**
 * simple hash table that stores HashEntry objects as value 
 * uses "Lineares Sondieren"
 * 
 * @author muwo522
 *
 */
public class HashTableProbing {

	// size of hash table
	private final static int TABLE_SIZE = 5;

	// array that implements hash table
	private HashEntry table[];

	// constructor, initialize empty hash table
	HashTableProbing() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
		}
	}

	// compute hash value for key
	private int hash(int key) {
		return key % TABLE_SIZE;
	}

	// search HashEntry that has key k ("Lineares Sondieren")
	public HashEntry search(int k) {
		// todo
		int h = hash(k);
		int i = 0;
		int j;

		do {
			j = h + i;
			if (table[j].getKey() == k) {
				return table[j];
			}
			i++;
		} while (table[j] != null && i != TABLE_SIZE);
		return null;
	}
	



	// insert value (key, value)
	public void insert(HashEntry entry) {
		int key = entry.getKey();
		int h = hash(entry.getKey());

		int i = 0;
		int j;
		do {
			j = h + i;
			if (table[j] == null) {
				table[j] = entry;
				return;
			}
			else {
				i++;
			}
		} while (i != TABLE_SIZE);
		return;

	}

	public void printHash() {
		System.out.println("Die Hashtabelle hat folgende Eintr�ge");
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (table[i] != null) {
				System.out.println("i=" + i + ": key=" + table[i].getKey()
						+ ", value" + table[i].getValue());
			} else {
				System.out.println("i=" + i + "---");
			}
		}
	}

}






