package com.github.murugeshkumark.dsa.array;

public class TwoDimensionalArray {
    int[][] arr;

    // Constructor
    public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {
        this.arr = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }


    // Traverse the com.github.murugeshkumark.dsa.array
    public void traverseArray() {
        try {
            System.out.println("Printing the com.github.murugeshkumark.dsa.array now...");
            for (int[] ints : arr) {
                for (int col = 0; col < arr[0].length; col++) {
                    System.out.print(ints[col] + "   ");
                }
                System.out.println();
            }
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Array does not exists");
        }

    }


    // Inserting value in the Array
    public void insertValueInTheArray(int row, int col, int value) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("Successfully inserted " + value + " in the com.github.murugeshkumark.dsa.array.");
            } else {
                System.out.println("This cell is already occupied by another value.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access com.github.murugeshkumark.dsa.array !");
            // e.printStackTrace();
        }
    }


    // Accessing single value from given com.github.murugeshkumark.dsa.array
    public void accessSingleCell(int row, int col) {
        System.out.println("\nAccessing Row#" + row + ", Col#" + col + "...");
        try {
            System.out.println("Cell value is: " + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access com.github.murugeshkumark.dsa.array !");
            // e.printStackTrace();
        }
        System.out.println();
    }


    // Searching a single value from the Array
    public void searchingSingleValue(int value) {
        System.out.println("\nSearching value " + value + " in the com.github.murugeshkumark.dsa.array");
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] == value) {
                    System.out.println("Value is founud at location Row:" + row + " & Col:" + col + "\n\n");
                    return;
                }
            }
        }
        System.out.println("Value is not found in Array\n");

    }


    // Deleting a value from Array
    public void deleteValuefromArray(int deleteValueFromThisRow, int deleteValueFromThisCol) {
        System.out.println(
                "Deleting value from Row#" + deleteValueFromThisRow + " & Col#" + deleteValueFromThisCol + "...");
        try {
            System.out.println("Successfully deleted: " + arr[deleteValueFromThisRow][deleteValueFromThisCol]);
            arr[deleteValueFromThisRow][deleteValueFromThisCol] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("Cant delete the value as cell# provided is not in the range of com.github.murugeshkumark.dsa.array !");
            // e.printStackTrace();
        }
    }


    // Delete the entire Array
    public void deleteThisArray() {
        arr = null;
        System.out.println("Array has been succefully deleted");
    }

}//end of class
