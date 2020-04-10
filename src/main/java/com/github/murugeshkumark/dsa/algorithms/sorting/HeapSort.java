package com.github.murugeshkumark.dsa.algorithms.sorting;

import com.github.murugeshkumark.dsa.heap.HeapByArray;

public class HeapSort {
    int[] arr;

    //Constructor
    public HeapSort(int[] arr) {
        this.arr = arr;
    }//end of method


    public void sort() {
        HeapByArray hba = new HeapByArray(arr.length); //We will reuse HeapByArray class to do com.github.murugeshkumark.dsa.algorithms.sorting
        for (int value : arr) { //Insert in Heap
            hba.insertInHeap(value);
        }
        for (int i = 0; i < arr.length; i++) { //Extract from Heap and insert sorted data in current Array
            arr[i] = hba.extractHeadOfHeap();
        }
    }//end of method


    public void printArray() {
        for (int value : arr) {
            System.out.print(value + "  ");
        }
    }//end of method

}//end of class