package com.github.murugeshkumark.ds.graph.dijkstra;

import com.github.murugeshkumark.common.node.WeightedNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PathFindingByDijkstra {
    ArrayList<WeightedNode> nodeList;


    //Constructor
    public PathFindingByDijkstra(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }


    //Dijkstra from a Source Node
    void dijkstra(WeightedNode node) {
        node.setDistance(0); //This will make sure that we start from this vertex in priority com.github.murugeshkumark.dsa.queue as distance is min
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode presentNode = queue.remove(); //remove com.github.murugeshkumark.dsa.common.node with minimum distance from com.github.murugeshkumark.dsa.queue
            for (WeightedNode neighbor : presentNode.getNeighbors()) { //for each neighbor
                if (queue.contains(neighbor)) { //if neighbor is not visited
                    // if 'known distance' of neighbor is greater than new path then,
                    // update 'distance' of neighbor
                    // and also new parent as presentNode
                    if (neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
                        neighbor.setDistance((presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)));
                        neighbor.setParent(presentNode);
                        //Refresh the Priority Queue
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }//end of if block
                }//end of if block
            }//end of for loop
        }//end of while loop


        //print table of com.github.murugeshkumark.dsa.common.node with minimum distance and shortest path from source
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }//end of method


    private static void pathPrint(WeightedNode node) {
        if (node.getParent() != null) {
            pathPrint(node.getParent());
            System.out.print("->" + node);
        } else
            System.out.print(node);
    }//end of method


    // add a weighted directed edge between two nodes
    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i - 1);
        WeightedNode second = nodeList.get(j - 1);
        first.getNeighbors().add(second);
        first.getWeightMap().put(second, d);
    }//end of method

}//end of class



