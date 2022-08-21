package com.bridgelabz.HashTable;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        String sentence = "To be or not to be";

        String[] value = sentence.toLowerCase().split(" ");

        for (String word : value) {
            Integer val = hashTable.get(word);

            if (val == null)
                val = 1;
            else
                val = val + 1;
            hashTable.add(word, val);
        }
        System.out.print(hashTable);
    }
}
