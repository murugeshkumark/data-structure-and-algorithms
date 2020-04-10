package com.github.murugeshkumark.algorithms.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Comparator;

public class FractionalKnapsack {


    static void knapSack(ArrayList<FractionalKnapsackItem> items, int capacity) {
        // Sort items by descending ratio of value/ weight
        //Implement Comparator interface and specify which variable('Ratio') of user defined class should the 'compare' method work on.
        //This needs to be done because this will be required in Sort method
        Comparator<FractionalKnapsackItem> comparator = Comparator.comparingDouble(FractionalKnapsackItem::getRatio);


        //Sort all the objects stored in the Arraylist by 'Ratio' variable
        items.sort(comparator);


        //Run greedy algo
        int usedCapacity = 0;
        double totalValue = 0;
        for (FractionalKnapsackItem item : items) {
            //if full consumption possible then consume it
            if (usedCapacity + item.getWeight() <= capacity) {
                usedCapacity += item.getWeight();
                System.out.println("Taken: " + item);
                totalValue += item.getValue();
            } else {
                //else consume fractionally
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio() * usedWeight;
                System.out.println("Taken: " + "item index = " + item.getIndex() + ",obtained value = " + value + ",used weight = " + usedWeight + ", ratio = " + item.getRatio()
                        + "]");
                usedCapacity += usedWeight;
                totalValue += value;
            }
            //if capacity is full then break
            if (usedCapacity == capacity) break;
        }
        //print finally obtained value
        System.out.println("\nTotal value obtained: " + totalValue);
    }//end of method

}//end of class
