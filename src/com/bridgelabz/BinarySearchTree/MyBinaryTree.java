package com.bridgelabz.BinarySearchTree;

public class MyBinaryTree<K extends Comparable<K>> {
    MyBinaryNode<K> root;
    public void add(K key) {
        this.root = this.addRecursively(root, key);
    }
    MyBinaryNode<K> addRecursively(MyBinaryNode<K> currentNode, K key) {
        if (currentNode == null)
            return new MyBinaryNode<>(key);

        if (key.compareTo(currentNode.key) > 0)
            currentNode.right = addRecursively(currentNode.right, key);
        else if (key.compareTo(currentNode.key) < 0)
            currentNode.left = addRecursively(currentNode.left, key);
        return currentNode;
    }

    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(56);
        tree.add(30);
        tree.add(70);
    }
}