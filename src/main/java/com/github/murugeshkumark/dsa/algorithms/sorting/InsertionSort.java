package com.github.murugeshkumark.dsa.algorithms.sorting;

public class InsertionSort {

    static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int tmp = A[i], j = i;
            while (j > 0 && A[j - 1] > tmp) {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = tmp;
        }//end of for loop
    }//end of method


    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + "  ");
        }
    }//end of method

}//end of class