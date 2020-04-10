package com.github.murugeshkumark.algorithms.greedyAlgorithms;

import java.util.ArrayList;

public class ActivitySelectionMain {

    public static void main(String[] args) {
        //Create an ArrayList to store all activities
        ArrayList<Activity> activityList = new ArrayList<>();

        //Insert activities in Arraylist
        activityList.add(new Activity("A1", 0, 6));
        activityList.add(new Activity("A2", 3, 4));
        activityList.add(new Activity("A3", 1, 2));
        activityList.add(new Activity("A4", 5, 8));
        activityList.add(new Activity("A5", 5, 7));
        activityList.add(new Activity("A6", 8, 9));

        //Print user entered data
        System.out.println("User provided Schedule:");
        for (Activity activity : activityList) {
            System.out.println(activity.toString());
        }

        //Perform calculation on activities
        ActivitiySelection.activitySelection(activityList);

    }//end of method
}//end of class