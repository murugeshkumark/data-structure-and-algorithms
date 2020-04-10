package com.github.murugeshkumark.dsa.algorithms.sorting;

public class BubbleSort {

    void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) //run from first cell to last cell
            for (int j = 0; j < n - i - 1; j++) //run from first cell to "last cell - iteration"
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }//end of method


    /* Prints the com.github.murugeshkumark.dsa.array */
    void printArray(int[] arr) {
        int n = arr.length;
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

}// end of class