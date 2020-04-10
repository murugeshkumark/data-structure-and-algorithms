package com.github.murugeshkumark.ds.tree.bfs;

import com.github.murugeshkumark.ds.common.node.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSByLinkedList {

    ArrayList<GraphNode> nodeList;


    //Constructor
    public BFSByLinkedList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }//end of method


    //BFS Algorithm
    void bfs() {
        //if a com.github.murugeshkumark.dsa.common.node is unvisited then run com.github.murugeshkumark.dsa.tree.bfs on it
        for (GraphNode node : nodeList) {
            if (!node.isVisited())
                bfsVisit(node);
        }
    }//end of method


    //BFS internal method
    void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node); //add source com.github.murugeshkumark.dsa.common.node to com.github.murugeshkumark.dsa.queue
        while (!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.print(presentNode.getName() + " ");
            for (GraphNode neighbor : presentNode.getNeighbors()) { //for each neighbor of present com.github.murugeshkumark.dsa.common.node
                if (!neighbor.isVisited()) { //if neighbor is not visited then add it to com.github.murugeshkumark.dsa.queue
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }//end of for loop
        }//end of while loop
    }//end of method


    // Add an undirected edge between two nodes
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i - 1);
        GraphNode second = nodeList.get(j - 1);
        first.getNeighbors().add(second);//Neighbour of first is second. Store it.
        second.getNeighbors().add(first);//Neighbour of second is first. Store it.
    }//end of method

}//end of class
