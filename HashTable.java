/**
 * Contains the implementation for a hash table where the integer key is also the value
 * @author Nikhil Jindal
 */
public class HashTable {
    
    // creates a table full of Entry's that will be used for the hash table
    private Entry[] table;

    // stores the size of the hash table
    private int tableSize;
    
    /**
     * Constructor for the hash table
     * @param size  the size of the hash table
     */
    public HashTable(int size) {
        this.table = new Entry[size];
        this.tableSize = size;
    }

    /**
     * Private class for the entries in the hash table
     */
    private class Entry {
        // the key for the entry
        private int key;

        // contains whether the element in the array has been removed
        private boolean removed;

        /**
         * Constructor for the entry
         * @param key  value for the entry
         */
        public Entry(int key) {
            this.key = key;
            removed = false;
        }        
    }

    /**
     * First hash function to be run
     * @param key  the key to be hashed
     * @return  the hashed value
     */
    private int h1(int key) {
        return key % tableSize;
    }

    /**
     * Second hash function to be run
     * @param key  the key to be hashed
     * @return  the hashed value
     */
    private int h2(int key) {
        return (7 - (key % 7));
    }

    /**
     * Finds an open position in the hash table (using double hashing)
     * @param key  the key to search for
     * @return  the index value of the open position in the hash table
     */
    private int probe(int key) {
        // value of the first hash
        int i = h1(key);
        
        // value of the second hash
        int j = h2(key);

        // number of iterations
        int k = 1;

        // keep probing until the entry is empty or removed
        while (table[i] != null && table[i].removed == false) {
            i = (i + j) % tableSize;
            k++;

            // break out if the number of iterations is greater than the table size
            if (k > tableSize) {
                return -1;
            }
        }

        // return the open index value
        return i;
    }

    /**
     * Finds an open position in the hash table (using linear search)
     * @param key  the key to search for
     * @return  the index value of the open position in the hash table
     */
    private int linearProbe(int key) {
        // value of the first hash
        int i = h1(key);

        // number of iterations
        int k = 1;

        // keep probing until the entry is empty or removed
        while (table[i] != null && table[i].removed == false) {
            i = (i + 1) % tableSize;
            k++;

            // break out if the number of iterations is greater than the table size
            if (k > tableSize) {
                return -1;
            }
        }

        // return the open index value
        return i;
    }

    /**
     * Returns the location of a given key in the hash table (using double hashing)
     * Returns -1 if the key is not found
     * @param key  the key to search for
     * @return  the location of the key in the hash table
     */
    private int findKey(int key) {
        // value of the first hash
        int i = h1(key);

        // value of the second hash
        int j = h2(key);

        // number of iterations
        int iterations = 0;

        // keep probing while the entry is not empty
        while (table[i] != null) {
            // return if key is found, otherwise continue
            if (table[i].removed == false && table[i].key == key) {
                i = (i + j) % tableSize;
                iterations++;
                if (iterations >= tableSize) {
                    return -1;
                }
            }
        }

        // return -1 if key is not found
        return -1;
    }

    /**
     * Returns the location of a given key in the hash table (using linear search)
     * Returns -1 if the key is not found
     * @param key  the key to search for
     * @return  the location of the key in the hash table
     */
    private int linearFindKey(int key) {
        // value of the first hash
        int i = h1(key);

        // number of iterations
        int iterations = 0;

        // keep probing while the entry is not empty
        while (table[i] != null) {
            // return if key is found, otherwise continue
            if (table[i].removed == false && table[i].key == key) {
                i = (i + 1) % tableSize;
                iterations++;
                if (iterations >= tableSize) {
                    return -1;
                }
            }
        }

        // return -1 if key is not found
        return -1;
    }

    /**
     * Searches for the entry in the hash table and returns the key (using double hashing)
     * Returns -1 if the key is not found
     * @param key  the key to search for
     * @return  the key of the entry in the hash table if it is found
     */
    private int search(int key) {
        // find the location of the key
        int i = findKey(key);

        // return the key if it was found
        if (i != -1) {
            return key;
        } else {
            return -1;
        }
    }

    /**
     * Searches for the entry in the hash table and returns the key (using linear search)
     * Returns -1 if the key is not found
     * @param key  the key to search for
     * @return  the key of the entry in the hash table if it is found
     * @return  -1 if the key is not found
     */
    private int linearSearch(int key) {
        // fint the location of the key
        int i = linearFindKey(key);

        // return the key if it was found
        if (i != -1) {
            return key;
        } else {
            return -1;
        }
    }

    /**
     * Removes an entry from the hash table given its key (using double hashing)
     * @param key  the key of the entry to remove
     */
    private void remove(int key) {
        // find the location of the key
        int i = findKey(key);

        // remove the entry if it was found
        if (i == -1) {
            return;
        } else {
            table[i].removed = true;
        }
    }

    /**
     * Removes an entry from the hash table given its key (using linear search)
     * @param key  the key of the entry to remove
     */
    private void linearRemove(int key) {
        // find the location of the key
        int i = linearFindKey(key);

        // remove the entry if it was found
        if (i == -1) {
            return;
        } else {
            table[i].removed = true;
        }
    }

    /**
     * Inserts a new entry into the hash table (using  double hashing)
     * @param key  the key of the entry to insert
     */
    private void insert(int key) {
        // find an open position in the hash table
        int i = probe(key);

        // insert the entry if an open position was found
        if (i == -1) {
            throw new RuntimeException("Table is full");
        } else {
            table[i] = new Entry(key);
        }
    }

    /**
     * Inserts a new entry into the hash table (using linear search)
     * @param key  the key of the entry to insert
     */
    private void linearInsert(int key) {
        // find an open position in the hash table
        int i = linearProbe(key);

        // insert the entry if an open position was found
        if (i == -1) {
            throw new RuntimeException("Table is full");
        } else {
            table[i] = new Entry(key);
        }
    }

    /**
     * Prints out a representation of the hash table
     */
    private void printTable() {
        System.out.print("[");
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null) {
                System.out.print(table[i].key);
                if (i < tableSize - 1) {
                    System.out.print(", ");
                }
            } else {
                System.out.print(" ,");
            }
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        
        /**********
         * PART 1 *
         **********/
        System.out.println("Part 1:\nInserting in the order [14,17,18,3,8,1,18,11,13,20] using linear probing");
        int[] p1array = {14,17,18,3,8,1,18,11,13,20};
        HashTable p1hashtable = new HashTable(10);
        for (int i = 0; i < p1hashtable.tableSize; i++) {
            p1hashtable.linearInsert(p1array[i]);
            System.out.printf("Step %d: ", i + 1);
            p1hashtable.printTable();
        }
        System.out.println();
        System.out.println();

        /***********
         * PART 2a *
         ***********/
        System.out.println("Part 2a:\nInserting in the order [2,12,22,32,42,52,62,72,82,92] using linear probing");
        int[] p2array = {2,12,22,32,42,52,62,72,82,92};
        HashTable p2hashtable = new HashTable(10);
        for (int i = 0; i < p2hashtable.tableSize; i++) {
            p2hashtable.linearInsert(p2array[i]);
            System.out.printf("Step %d: ", i + 1);
            p2hashtable.printTable();
        }
        System.out.println();
        System.out.println();

        /***********
         * PART 2b *
         ***********/ 
        System.out.println("Part 2b:\nInserting in the order [2,12,22,32,42,52,62,72,82,92,14,17,18,3,8,1,18,11,13,20] using double hashing");
        int[] array = {2,12,22,32,42,52,62,72,82,92,14,17,18,3,8,1,18,11,13,20};
        HashTable table = new HashTable(20);
        for (int i = 0; i < table.tableSize; i++) {
            table.insert(array[i]);
            System.out.printf("Step %d: ", i + 1);
            table.printTable();
        }
    }
    
}
