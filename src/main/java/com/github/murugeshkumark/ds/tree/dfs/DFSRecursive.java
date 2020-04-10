package com.github.murugeshkumark.ds.tree.dfs;

import com.github.murugeshkumark.common.node.GraphNode;

import java.util.ArrayList;

public class DFSRecursive {
    private final ArrayList<GraphNode> nodeList;


    public DFSRecursive(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }


    void dfs() {
        //if a com.github.murugeshkumark.dsa.common.node is unvisited then run com.github.murugeshkumark.dsa.tree.dfs on it
        for (GraphNode node : nodeList) {
            if (!node.isVisited())
                dfsVisit(node);
        }
    }


    //com.github.murugeshkumark.dsa.tree.dfs traversal by a source com.github.murugeshkumark.dsa.common.node
    void dfsVisit(GraphNode node) {
        //mark com.github.murugeshkumark.dsa.common.node as visited
        node.setVisited(true);
        //print the com.github.murugeshkumark.dsa.common.node
        System.out.print(node.getName() + " ");
        //for each neighbor of present com.github.murugeshkumark.dsa.common.node
        for (GraphNode neighbor : node.getNeighbors()) {
            //if neighbor is not visited
            if (!neighbor.isVisited()) {
                //recursive call to com.github.murugeshkumark.dsa.tree.dfs function
                dfsVisit(neighbor);
            }
        }
    }

    // add an undirected edge between two nodes
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i - 1);
        GraphNode second = nodeList.get(j - 1);
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
    }

}
