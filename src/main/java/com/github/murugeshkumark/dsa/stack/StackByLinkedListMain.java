package com.github.murugeshkumark.dsa.stack;

public class StackByLinkedListMain {

    public static void main(String[] args) {

        StackByLinkedList stack = new StackByLinkedList();

        System.out.println("Pushing 10 values into com.github.murugeshkumark.dsa.stack");
        for (int i = 1; i <= 10; i++) {
            stack.push(i * 10);
        }
        System.out.println();

        System.out.println("Peeking value");
        System.out.println(stack.peek());
        System.out.println();

        System.out.println("Poping 11 values from com.github.murugeshkumark.dsa.stack");
        for (int i = 1; i <= 11; i++) {
            System.out.println(stack.pop());
        }
        System.out.println();

    }

}