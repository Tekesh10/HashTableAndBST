package com.bridgelabz.BinarySearchTree;

import java.util.Scanner;

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
        } else {
            size = this.getSizeRecursively(root.left) + 1 + this.getSizeRecursively(root.right);
        }
        return size;
    }
    public void searchElement(K key) {
        MyBinaryNode<K> currentNode = this.searchRecursively(root, key);
        System.out.println(currentNode.key + " FOUND");
    }

    private MyBinaryNode<K> searchRecursively(MyBinaryNode<K> currentNode, K key) {
        if (currentNode == null || currentNode.key == key) {
            return currentNode;
        }
        if (key.compareTo(currentNode.key) < 0) {
            return searchRecursively(currentNode.left, key);
        }
        if (key.compareTo(currentNode.key) > 0) {
            return searchRecursively(currentNode.right, key);
        }
        return currentNode;
    }
    
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter element: ");
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            tree.add(input);
        }
        tree.getSize();
        System.out.println("Enter data to search");
        int searchData = scanner.nextInt();
        tree.searchElement(searchData);
    }
}