package com.github.murugeshkumark.ds.array;

import java.util.Arrays;

public class SingleDimensionArray {
    int[] arr;


    //Constructor
    public SingleDimensionArray(int sizeOfArray) {
        arr = new int[sizeOfArray];
        Arrays.fill(arr, Integer.MIN_VALUE);
    }


    // Print the com.github.murugeshkumark.dsa.array
    public void traverseArray() {
        try {
            for (int value : arr) {
                System.out.print(value + " ");
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists !");
        }
    }


    //Insert value in the Array
    public void insert(int location, int valueToBeInserted) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToBeInserted;
                System.out.println("Successfully inserted " + valueToBeInserted + " at location: " + location);
            } else {
                System.out.println("This cell is already occupied by another value.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access com.github.murugeshkumark.dsa.array !");
            // e.printStackTrace();
        }
    }


    // Access a particular element of an com.github.murugeshkumark.dsa.array
    public void accessingCell(int cellNumber) {
        try {
            System.out.println(arr[cellNumber]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access com.github.murugeshkumark.dsa.array !");

        }
    }


    //Search for an element in the given Array
    public void searchInAnArray(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) {
                System.out.println("Value found !");
                System.out.println("Index of " + valueToSearch + " is: " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found!!");
    }


    //Delete value from given Array
    public void deleteValueFromArray(int deleteValueFromThisCell) {
        try {
            arr[deleteValueFromThisCell] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("Cant delete the value as cell# provided is not in the range of com.github.murugeshkumark.dsa.array !");
            // e.printStackTrace();
        }
    }


    //Delete the entire Array
    public void deleteThisArray() {
        arr = null;
        System.out.println("Array has been succefully deleted");
    }

}//end of class
