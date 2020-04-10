package com.github.murugeshkumark.dsa.queue;

public class CircularQueueByArray {

    int[] arr;
    int topOfQueue;
    int size;
    int start;


    public CircularQueueByArray(int size) {
        this.arr = new int[size];
        this.size = size;
        this.topOfQueue = -1;
        start = -1;
        System.out.println("Successfully created an empty com.github.murugeshkumark.dsa.queue of size: " + size);
    }//end of method


    public void enQueue(int value) {
        if (arr == null) {
            System.out.println("Array is not yet created. Please create one first.");
        } else if (isQueueFull()) {
            System.out.println("\nQueue overflow error!!");
        } else {
            initializeStartOfArray();
            if (topOfQueue + 1 == size) { //if top is already at last cell of com.github.murugeshkumark.dsa.array, then reset it to first cell
                topOfQueue = 0;
            } else {
                topOfQueue++;
            }
            arr[topOfQueue] = value;
            System.out.println("\nSuccessfully inserted " + value + " in the com.github.murugeshkumark.dsa.queue");
        }
    }//end of method


    public void initializeStartOfArray() {
        if (start == -1) {
            start = 0;
        }
    }//end of method


    public void deQueue() {
        if (isQueueEmpty()) {
            System.out.println("Queue underflow error!!");
        } else {
            System.out.println("\n---------------------------------------------");
            System.out.println("Before Dequeue..");
            printArray();
            System.out.println("\nDequeing value from Queue...");
            System.out.println("Dequeued: " + arr[start] + " from com.github.murugeshkumark.dsa.queue");
            arr[start] = 0; //initialize the unused cell to 0
            if (start == topOfQueue) { //if there is only 1 element in Queue
                start = topOfQueue = -1;
            } else if (start + 1 == size) { //if start has reached end of com.github.murugeshkumark.dsa.array, then start again from 0
                start = 0;
            } else {
                start++;
            }
        }
        System.out.println("After Dequeue..");
        printArray();
        System.out.println("---------------------------------------------");
    }//end of method


    public boolean isQueueEmpty() {
        return topOfQueue == -1;
    }//end of method


    public boolean isQueueFull() {
        //Trivial case of Queue being full
        if (topOfQueue + 1 == start) { //If we have completed a circle, then we can say that Queue is full
            return true;
        } else return (start == 0) && (topOfQueue + 1 == size);
    }//end of method


    public void peekOperation() {
        //if com.github.murugeshkumark.dsa.stack is not empty, return the value on top of com.github.murugeshkumark.dsa.stack
        if (!isQueueEmpty()) {
            System.out.println("\nPeeking value from com.github.murugeshkumark.dsa.queue...");
            System.out.println(arr[start]);
        } else {
            System.out.println("The com.github.murugeshkumark.dsa.queue is empty!!");
        }
    }//end of method


    public void deleteStack() {
        System.out.println("\n\nDeleting the entire Queue...");
        arr = null;
        System.out.println("Queue is successfully deleted !");
    }//end of method


    //Print entire com.github.murugeshkumark.dsa.array
    public void printArray() {
        System.out.println("Array now...");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println("\nStart = " + start);
        System.out.println("End = " + topOfQueue);
    }//end of method

}//end of class
