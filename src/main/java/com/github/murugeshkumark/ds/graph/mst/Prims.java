package com.github.murugeshkumark.ds.graph.mst;

import com.github.murugeshkumark.node.WeightedNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {

    ArrayList<WeightedNode> nodeList;

    //Constructor
    public Prims(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }//end of method


    // Prim's algorithm from source com.github.murugeshkumark.dsa.common.node
    void prims(WeightedNode node) {
        for (WeightedNode weightedNode : nodeList) {
            weightedNode.setDistance(Integer.MAX_VALUE);
        }
        node.setDistance(0); // Setting '0' distance for Source Vertex


        System.out.println("I am waiting");
        try {
            Thread.sleep(100 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        PriorityQueue<WeightedNode> queue = new PriorityQueue<>(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode presentNode = queue.remove(); // Remove vertex which has min distance


            for (WeightedNode neighbor : presentNode.getNeighbors()) {
                if (queue.contains(neighbor)) {//If vertex is not processed, only then enter in if-else
                    //If known weight of this �adjacent vertex� is more than current edge,
                    //then update �adjacent vertex�s� distance and parent
                    if (neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
                        neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
                        neighbor.setParent(presentNode);
                        queue.remove(neighbor); // Refresh the priority com.github.murugeshkumark.dsa.queue
                        queue.add(neighbor);
                    }//end of if-else
                }//end of if-else
            }//end of for loop
        }//end of while loop

        int cost = 0;
        // print table of com.github.murugeshkumark.dsa.common.node with minimum distance and shortest path from source
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getDistance() + ", Parent: " + nodeToCheck.getParent());
            cost = cost + nodeToCheck.getDistance();
        }//end of for loop

        System.out.println("\nTotal cost of MST: " + cost);
    }//end of method


    // add a weighted undirected edge between two nodes
    public void addWeightedUndirectedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i - 1);
        WeightedNode second = nodeList.get(j - 1);
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
        first.getWeightMap().put(second, d);
        second.getWeightMap().put(first, d);
    }//end of method

}
