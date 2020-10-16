package com.training;

/**
 * Created by JohnPaul Manohar on 9/14/2020.
 */
public class MinHeap {

    static int[] arr = new int[100];
    static int currentSize = 0;

    public static void main(String... args) {

        insert(34);
        insert(65);
        insert(49);
        insert(52);
        insert(50);
        insert(23);

        show();

        System.out.println("getmin : " + getmin());

        insert(68);
        insert(27);
        insert(21);
        insert(95);


        show();

        System.out.println("extractmin : " + extractmin());

        show();

        System.out.println("extractmin : " + extractmin());

        show();

        System.out.println("getmin : " + getmin());

        insert(4);

        show();

    }

    static void insert(int data) {
        arr[currentSize] = data;

        trickleup(currentSize++);
    }

    static int getmin() {
        return arr[0];
    }

    static int extractmin() {
        int buffer = arr[0];
        arr[0] = arr[--currentSize];
        trickledown(0);

        return buffer;
    }

    static void trickledown(int index) {
        int smallChild;
        int top = arr[index];

        while (index < currentSize / 2) {
            int leftChild = (2 * index) + 1;
            int rightChild = leftChild + 1;

            if(rightChild < currentSize && arr[leftChild] < arr[rightChild])
                smallChild = leftChild;
            else
                smallChild = rightChild;

            if(top < arr[smallChild]) break;

            arr[index] = arr[smallChild];
            index = smallChild;
        }

        arr[index] = top;
    }

    static void trickleup(int index) {
        int parent = (index - 1) / 2;
        int bottom = arr[index];

        while(index > 0 && arr[parent] > bottom) {
            arr[index] = arr[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        arr[index] = bottom;
    }

    //non-standard
    static void show() {
        for(int i = 0; i < currentSize; i++) {
            System.out.print(arr[i] + " -> ");
        }
    }
}
