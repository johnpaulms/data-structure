package com.training;

import java.util.Stack;

/**
 * Created by JohnPaul Manohar on 9/14/2020.
 */
public class Stacks {
    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String... args) {

        push(34);
        push(65);
        push(49);
        push(52);

        System.out.println("pop : " + pop());
        System.out.println("pop : " + pop());

        push(50);
        push(23);
        push(68);

        System.out.println("peek : " + peek());

        push(27);
        push(21);
        push(95);

        System.out.println("pop : " + pop());
        System.out.println("pop : " + pop());
    }

    static void push(int data) {
        stack.push(data);
    }

    static int peek() {
        return stack.peek();
    }

    static int pop() {
        return stack.pop();
    }
}
