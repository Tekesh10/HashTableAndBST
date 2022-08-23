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
    public void getSize() {
        int size = getSizeRecursively(root);
        if (size == 0) {
            System.out.println("Tree is empty");
        } else {
            System.out.println("Elements in tree = " + size);
        }
    }
    private int getSizeRecursively(MyBinaryNode<K> root) {
        int size;
        if (root == null) {
            size = 0;
        }else {
            size = this.getSizeRecursively(root.left) + 1 + this.getSizeRecursively(root.right);
        }
        return size;
    }
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(56);
        tree.add(30);
        tree.add(70);
        tree.getSize();
    }
}