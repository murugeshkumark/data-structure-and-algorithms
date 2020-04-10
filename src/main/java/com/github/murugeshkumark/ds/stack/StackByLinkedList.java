package com.github.murugeshkumark.ds.stack;

import com.github.murugeshkumark.ds.linkedlist.SingleLinkedList;

public class StackByLinkedList {

    SingleLinkedList list;


    //constructor
    public StackByLinkedList() {
        list = new SingleLinkedList();
    }//end of method


    public void push(int value) {
        if (list.getHead() == null) {
            list.createSingleLinkedList(value);
        } else {
            list.insertInLinkedList(value, 0);
        }
        System.out.println("Inserted " + value + " in Stack !");
    }//end of method


    public int pop() {
        int value = -1;
        if (isEmpty()) {
            System.out.println("Stack underflow error!!");
        } else {
            value = list.getHead().getValue();
            list.deletionOfNode(0);
        }
        return value;
    }// end of method


    public boolean isEmpty() {
        return list.getHead() == null;
    }// end of method


    public int peek() {
        if (!isEmpty())
            return list.getHead().getValue();
        else {
            System.out.println("The com.github.murugeshkumark.dsa.stack is empty!!");
            return -1;
        }
    }// end of method


    public void deleteStack() {
        list.setHead(null);
    }//end of method

}//end of method
