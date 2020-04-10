package com.github.murugeshkumark.dsa.common.node;

import java.util.ArrayList;

public class NumberOfPathsNode {

    int costToReachLastCell;
    int costOfCurrentCell;
    NumberOfPathsNode rightCell;
    NumberOfPathsNode downCell;
    int numberOfWaysToComeHereFromRightOrDown = 0;
    ArrayList<Integer> NumberOfWaysSatifyingDownCell = new ArrayList<>();
    ArrayList<Integer> NumberOfWaysSatifyingRightCell = new ArrayList<>();


    //Constructor
    public NumberOfPathsNode(int costOfCurrentCell, NumberOfPathsNode rightCell, NumberOfPathsNode DownCell, int costToReachLastCell) {
        this.costOfCurrentCell = costOfCurrentCell;
        this.rightCell = rightCell;
        this.downCell = DownCell;
        this.costToReachLastCell = costToReachLastCell;
    }


    //Getting numbers of ways to reach last cell from current cell
    public int getnumberOfWaysToReachLastCellFromHere() {
        int numberOfWaysToReachLastCellFromHere = 0;
        for (Integer value : NumberOfWaysSatifyingRightCell) {
            if (value == costOfCurrentCell) {
                numberOfWaysToReachLastCellFromHere++;
            }
        }
        for (Integer integer : NumberOfWaysSatifyingDownCell) {
            if (integer == costOfCurrentCell) {
                numberOfWaysToReachLastCellFromHere++;
            }
        }
        return numberOfWaysToReachLastCellFromHere;
    }


    //Calculate number ways
    public void setNumberOfWaysToComeHereFromRightOrDown() {

        numberOfWaysToComeHereFromRightOrDown = NumberOfWaysSatifyingDownCell.size() + NumberOfWaysSatifyingRightCell.size();
        System.out.println("numberOfWaysToComeHereFromRightOrDown: " + numberOfWaysToComeHereFromRightOrDown);
        for (Integer value : NumberOfWaysSatifyingDownCell) {
            System.out.println("DownArray: " + value + "  ");
        }

        for (Integer integer : NumberOfWaysSatifyingRightCell) {
            System.out.println("RightArray: " + integer + "  ");

        }

    }


    //Calculate number of ways to come here from Right cell
    public void calculateNumberOfWaysSatifyingRightCell() {
        if (rightCell == null) {
            return;
        }

        int sizeOfRightCellsRight = rightCell.NumberOfWaysSatifyingRightCell.size();
        int sizeOfRightCellsDown = rightCell.NumberOfWaysSatifyingDownCell.size();

        for (int i = 0; i < sizeOfRightCellsRight; i++) {
            if (rightCell.NumberOfWaysSatifyingRightCell.get(i) >= rightCell.costOfCurrentCell) {
                NumberOfWaysSatifyingRightCell.add(rightCell.NumberOfWaysSatifyingRightCell.get(i) - rightCell.costOfCurrentCell);
            }
        }//end of loop

        for (int i = 0; i < sizeOfRightCellsDown; i++) {
            if (rightCell.NumberOfWaysSatifyingDownCell.get(i) >= rightCell.costOfCurrentCell) {
                NumberOfWaysSatifyingRightCell.add(rightCell.NumberOfWaysSatifyingDownCell.get(i) - rightCell.costOfCurrentCell);
            }
        }//end of loop
    }//end of method


    //Calculate number of ways to come here from Down cell
    public void calculateNumberOfWaysSatifyingDownCell() {
        if ((downCell == null) && (rightCell == null)) { //Base case for last row and col
            NumberOfWaysSatifyingDownCell.add(costToReachLastCell);
        }

        if (downCell == null) {
            return;
        }

        int sizeOfDownCellsRight = downCell.NumberOfWaysSatifyingRightCell.size();
        int sizeOfDownCellsDown = downCell.NumberOfWaysSatifyingDownCell.size();

        for (int i = 0; i < sizeOfDownCellsRight; i++) {
            if (downCell.NumberOfWaysSatifyingRightCell.get(i) >= downCell.costOfCurrentCell) {
                NumberOfWaysSatifyingDownCell.add(downCell.NumberOfWaysSatifyingRightCell.get(i) - downCell.costOfCurrentCell);
            }
        }//end of loop

        for (int i = 0; i < sizeOfDownCellsDown; i++) {
            if (downCell.NumberOfWaysSatifyingDownCell.get(i) >= downCell.costOfCurrentCell) {
                NumberOfWaysSatifyingDownCell.add(downCell.NumberOfWaysSatifyingDownCell.get(i) - downCell.costOfCurrentCell);
            }
        }//end of loop
    }//end of method

}//end of class

