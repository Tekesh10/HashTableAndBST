package com.bridgelabz.HashTable;

public class MyMapNode<K,V> {
    K key;
    V value;
    com.bridgelabz.HashTable.MyMapNode<K,V> next;
    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public com.bridgelabz.HashTable.MyMapNode<K,V> getNext() {
        return next;
    }

    public void setNext(com.bridgelabz.HashTable.MyMapNode<K,V> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nWord -> '").append(key).append("' Frequency -> ").append(value);
        if(next != null)
            builder.append(next);
        return builder.toString();
    }
}