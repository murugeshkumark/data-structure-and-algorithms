package com.github.murugeshkumark.algorithms.sorting;

import com.github.murugeshkumark.node.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    ArrayList<GraphNode> nodeList;


    //Constructor
    public TopologicalSort(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }


    void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList) { // if a com.github.murugeshkumark.dsa.common.node is unvisited then run topologicalSort on it
            if (!node.isVisited())
                topologicalVisit(node, stack);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getName() + " ");
        }
    }


    // Topological visit by a source com.github.murugeshkumark.dsa.common.node
    void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : node.getNeighbors()) {    //if neighbor is not visited then recursive call to it
            if (!neighbor.isVisited()) {
                topologicalVisit(neighbor, stack);
            }
        }
        node.setVisited(true);
        stack.push(node);
    } // end of method


    // add a directed edge between two nodes
    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i - 1);
        GraphNode second = nodeList.get(j - 1);
        first.getNeighbors().add(second);
    } // end of method

}//end of class