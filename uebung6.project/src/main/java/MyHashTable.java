/**
 * Created by muwo522 on 25.11.2016.
 */
public class MyHashTable {

    // inner class that represents an entry of the hashtable
    private class Entry {

        private int key;
        private String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    // size of hash hashTable
    private final static int TABLE_SIZE = 5;

    // array that actually implements the hash table
    private Entry hashTable[];


    MyHashTable() {
        hashTable = new Entry[TABLE_SIZE];
    }

    // hash function
    private int hashFunction(int key) {
        return key % TABLE_SIZE;
    }

    // search value (=String) for key k (linear probing (dt. "Lineares Sondieren")
    public String search(int k) {

        int hash = hashFunction(k);
        int i = 0;      // counter for probing sequence

        while (i < TABLE_SIZE)  {
            // compute probing position in hash table
            int j  = (hash + i) % TABLE_SIZE;

            if (hashTable[j] == null) {
                return null;
            }
            else if (hashTable[j].key == k) {
                return hashTable[j].value;
            }

            i++;
        }
        return null;
    }



    // insert key k and value v
    public void insert(int k, String v) {

        int hash = hashFunction(k);
        int i = 0;      // counter for probing sequence

        while (i < TABLE_SIZE)  {
            // compute probing position in hash table
            int j  = (hash + i) % TABLE_SIZE;

            if (hashTable[j] == null) {
                hashTable[j] = new Entry(k,v);
                return;
            }
            i++;
        }
        throw new RuntimeException("Hash Table is full!");
    }


    // delete entry with key k from hash table
    public void delete(int k)  {

        // TODO

        // do other methods have to be modified as well?
    }

    public void printHash() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[i] != null) {
                System.out.println("i=" + i + ": key=" + hashTable[i].key
                        + ", value=" + hashTable[i].value);
            } else {
                System.out.println("i=" + i + "---");
            }
        }
    }


    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable();

        // Inserting keys 1, 2, 6
        hashTable.insert(1, "AD");
        hashTable.insert(2, "RN");
        hashTable.insert(6, "PRG3");
        System.out.println("Einträge nach Einfügen der Schlüssel 1, 2, 6: ");
        hashTable.printHash();

        // Searching keys
        System.out.println("\nSuche nach Schlüssel 6 und 3:");
        String result = (hashTable.search(6) != null) ? "Key 6 found" : "Key 6 not found";
        System.out.println(result);
        result = (hashTable.search(3) != null) ? "Key 3 found" : "Key 3 not found";
        System.out.println(result);

        // Deleting key 1

        hashTable.delete(1);
        System.out.println("\nEinträge nach Löschen von Schlüssel 1: ");
        hashTable.printHash();

        // Now searching key 6
        System.out.println("\nSuche von 6 nachdem Schlüssel 1 gelöscht wurde:");
        result = (hashTable.search(6) != null) ? "Key 6 found" : "Key 6 not found";
        System.out.println(result);

    }
}
