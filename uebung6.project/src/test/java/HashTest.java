public class HashTest {

	public static void main(String[] args) {
		// create some HashEntries
		HashEntry entry1 = new HashEntry(1, 10000);
		HashEntry entry2 = new HashEntry(2, 20000);
		HashEntry entry3 = new HashEntry(7, 30000);
		
		// insert into HashTable
		HashTableChaining hashTable = new HashTableChaining();
		hashTable.insert(entry1);
		hashTable.insert(entry2);
		hashTable.insert(entry3);
		
		hashTable.printHash();
		
	}

}
