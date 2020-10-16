package com.training;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JohnPaul Manohar on 9/14/2020.
 */
public class Queues {

    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String... args) {

        enqueue(34);
        enqueue(65);
        enqueue(49);
        enqueue(52);

        System.out.println("dequeue : " + dequeue());
        System.out.println("dequeue : " + dequeue());

        enqueue(50);
        enqueue(23);
        enqueue(68);

        System.out.println("peek : " + peek());

        enqueue(27);
        enqueue(21);
        enqueue(95);

        System.out.println("dequeue : " + dequeue());
        System.out.println("dequeue : " + dequeue());

    }

    static void enqueue(int data) {
        queue.add(data);
    }

    static int dequeue() {
        return queue.poll();
    }

    static int peek() {
        return queue.peek();
    }
}
