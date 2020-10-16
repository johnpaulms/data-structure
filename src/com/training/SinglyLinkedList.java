package com.training;

/**
 * Created by JohnPaul Manohar on 9/14/2020.
 */
public class SinglyLinkedList {

    static Node head;

    public static void main(String... args) {

        insert(34);
        insert(65);
        insert(49);
        insert(52);
        insert(50);
        insert(23);
        insert(68);
        insert(27);
        insert(21);
        insert(95);

        show();

        System.out.println(search(67));
        System.out.println(search(52));

        delete(50);
        delete(68);
        delete(95);

        show();

    }

    static void insert(int data) {
        Node curr = new Node(data);
        curr.next = head;

        head = curr;
    }

    static boolean search(int data) {

        Node curr = head;

        while(curr.next != null) {

            if(curr.next.data == data) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    static void delete(int data) {

        Node curr = head;

        if(head != null && head.data == data) {
            head = head.next;
        }
        else {
            while (curr.next != null) {

                if (curr.next.data == data) {
                    curr.next = curr.next.next;
                    return;
                }
                curr = curr.next;
            }
        }
    }

    static void show() {

        Node curr = head;

        while(curr.next != null) {

            System.out.print(curr.data + " -> ");

            curr = curr.next;
        }

        System.out.println(curr.data + " -> ");
    }

    static class Node {
        public int data;
        public Node next;

        public Node(int _data) {
            data = _data;
            next = null;
        }
    }
}

