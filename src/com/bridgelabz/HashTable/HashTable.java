package com.bridgelabz.HashTable;

import java.util.ArrayList;

public class HashTable<K,V> {
    MyMapNode head;
    MyMapNode tail;
    private final int numOfBuckets;
    ArrayList<MyMapNode<K, V>> myBucketArray;

    public HashTable() {
        this.numOfBuckets = 10;
        this.myBucketArray = new ArrayList<>();
        for (int i = 0; i < numOfBuckets; i++)
            this.myBucketArray.add(null);
    }

    public void add(K key, V value) {
        int index = this.BucketIndex(key);
        MyMapNode<K, V> MyMapNode = this.myBucketArray.get(index);
        if (MyMapNode == null) {
            MyMapNode = new MyMapNode<>(key, value);
            this.myBucketArray.set(index, MyMapNode);
        }
        MyMapNode = (MyMapNode<K, V>) searchNode(key);
        if (MyMapNode == null) {
            MyMapNode = new MyMapNode<>(key, value);
            this.append(MyMapNode);
        } else {
            MyMapNode.setValue(value);
        }
    }

    public void append(MyMapNode myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public MyMapNode<K, V> searchNode(K data) {
        MyMapNode currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(data)) {
                return currentNode.next;
            }
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public V get(K word) {
        int index = this.BucketIndex(word);
        if (this.myBucketArray.get(index) == null)
            return null;
        MyMapNode<K, V> myMapNode = searchNode(word);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    private int BucketIndex(K word) {
        int hashCode = Math.abs(word.hashCode());
        int index = hashCode % numOfBuckets;
        return index;
    }

    @Override
    public String toString() {
        return " \n{" + head + "}";
    }
}