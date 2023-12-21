# HashTable

This repository contains the `HashTable.java` class which contains the implementation for a hashtable where the integer keys are also the data values. This file contains two versions of most of its methods since both linear probing and double hashing are supported by the file for open addressing.

This file also includes a `main` method which tests certain methods of the class and prints all of the results to the terminal when it is run. More description about the main method is given below.

----

These are the methods in the `HashTable.java` class:
- `int h1(int key)` - the first hash function to be run with the basic equation: $mod(key,tableSize)$
- `int h2(int key)` - the second hash function to be run with the equation: $7-mod(key,7)$
- `int probe(int key)` - finds an open position in the hash table using double hashing
- `int linearProbe(int key)` - finds an open position in the hash table using linear search
- `int findKey(int key)` - returns the location of a given key in the hash table using double hashing
- `int linearFindKey(int key)` - returns the location of a given key in the hash table using linear search
- `int search(int key)` - searches for the entry in the hash table and returns its key using double hashing
- `int linearSearch(int key)` - searches for the entry in the hash table and returns its key using linear search
- `void remove(int key)` - removes an entry from the hash table using double hashing
- `void linearRemove(int key)` - removes an entry from the hash table using linear search
- `void insert(int key)` - inserts a new entry into the hash table using double hashing
- `void linearInsert(int key)` - inserts a new entry into the hash table using linear search
- `void printTable()` - prints out a representation of the table to the terminal

----

When the `main` method is run, it solves the following 3 problems using a combination of linear search and double hashing.

Problem 1:

    Use linear probing to build a hash table with length 10. Insert the following elements in the order they are given:
    [14, 17, 18, 3, 8, 1, 18, 11, 13, 20]
The step-by-step results of this problem are printed to the terminal.

Problem 2:

Part a)

    Use linear probing to build a hash table with length 10. Insert the following elements in the order they are given:
    [2, 12, 22, 32, 42, 52, 62, 72, 82, 92]

Part b)

    Use double hashing to build a hash table with length 20. Insert the following elements in the order they are given:
    [2, 12, 22, 32, 42, 52, 62, 72, 82, 92]
The step-by-step solutions for both problems 2a and 2b are printed to the terminal.