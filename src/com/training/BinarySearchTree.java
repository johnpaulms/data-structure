package com.training;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
 *
 * Created by JohnPaul Manohar on 9/14/2020.
 */
public class BinarySearchTree {

    static Node root;

    public static void main(String... args) {

        insert(50);
        insert(30);
        insert(20);
        insert(40);
        insert(70);
        insert(60);
        insert(80);

        System.out.println("inorder:");
        inorder(root);
        System.out.println("preorder:");
        preorder(root);
        System.out.println("postorder:");
        postorder(root);

        System.out.println("");
        System.out.println("");
        System.out.println("levelorder:");
        levelorder(root);

        System.out.println("");
        System.out.println("");
        System.out.println("search: 50 -> " + search(root,50));
        System.out.println("search: 70 -> " + search(root,70));
        System.out.println("search: 150 -> " + search(root,150));

        delete(50);

        System.out.println("");
        System.out.println("");
        System.out.println("levelorder:");
        levelorder(root);

    }

    static void insert(int data) {

        root = insertRecursive(root, data);
    }

    static Node insertRecursive(Node root, int data) {

        if(root == null) return new Node(data);

        if(root.data > data)
            root.left = insertRecursive(root.left, data);
        else if(root.data < data)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    static void delete(int data) {

        root = deleteRecursive(root, data);

    }

    static Node deleteRecursive(Node root, int data) {

        if(root == null) return root;

        if(root.data > data) {
            root.left = deleteRecursive(root.left, data);
        }
        else if(root.data < data) {
            root.right = deleteRecursive(root.right, data);
        }
        else {

            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            root.data = inorderSuccessor(root.right);

            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    static int inorderSuccessor(Node root) {

        int successor = root.data;

        while (root.left != null) {
            root = root.left;
            successor = root.data;
        }

        return successor;
    }

    static boolean search(Node curr, int data) {

        if (curr == null) return false;

        if (curr.data == data) {
            return true;
        } else if (curr.data > data) {
            return search(curr.left, data);
        } else {
            return search(curr.right, data);
        }

    }

    //DFS
    static void inorder(Node root) {

        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " -> ");
            inorder(root.right);
        }

    }

    //DFS
    static void preorder(Node root) {

        if(root != null) {
            System.out.print(root.data + " -> ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    //DFS
    static void postorder(Node root) {

        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " -> ");
        }
    }

    //BFS
    static void levelorder(Node root) {

        int currentLevel = 0;

        Queue<Node> queue = new LinkedList<>();
        root.level = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if(curr.level > currentLevel) {
                System.out.println("");
                currentLevel = curr.level;
            }

            System.out.print(curr.data + " -> ");

            if(curr.left != null) {
                curr.left.level = curr.level + 1;
                queue.add(curr.left);
            }

            if(curr.right != null) {
                curr.right.level = curr.level + 1;
                queue.add(curr.right);
            }
        }


    }

    static class Node {
        public int data;
        public Node left;
        public Node right;
        public int level;

        public Node(int _data) {
            data = _data;
            left = right = null;
        }
    }
}
