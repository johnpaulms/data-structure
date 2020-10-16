package com.training;

/**
 * Created by JohnPaul Manohar on 9/14/2020.
 */
public class Arrays {

    static int[] arr = new int[100];
    static int index = 0;

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

        System.out.println(search(67));
        System.out.println(search(52));

        System.out.println(get(5));
        System.out.println(get(19));
        System.out.println(get(2));

        show();
    }

    static void insert(int data) {
        arr[index++] = data;
    }

    static boolean search(int data) {

        for(int i = 0; i < index; i++) {
            if(arr[i] == data) return true;
        }

        return false;
    }

    static int get(int curr) {
        return index > curr ? arr[curr] : -1;
    }

    static void show() {
        for(int i = 0; i < index; i++) {
            System.out.print(arr[i] + " -> ");
        }
    }
}
