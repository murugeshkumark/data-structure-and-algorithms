package com.github.murugeshkumark.ds.graph.mst;

import com.github.murugeshkumark.ds.graph.graphUtil.UndirectedEdge;
import com.github.murugeshkumark.common.node.WeightedNode;

import java.util.ArrayList;
import java.util.Comparator;

public class Kruskal {
    ArrayList<WeightedNode> nodeList;
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }


    // Kruskal algo
    void kruskal() {
        // make disjoint sets for each com.github.murugeshkumark.dsa.common.node
        DisjointSet.makeSet(nodeList);

        // sort the edges in ascending order
        Comparator<UndirectedEdge> comparator = Comparator.comparingInt(UndirectedEdge::getWeight);
        edgeList.sort(comparator);

        int cost = 0;
        for (UndirectedEdge edge : edgeList) {
            WeightedNode first = edge.getFirst();
            WeightedNode second = edge.getSecond();
            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
                DisjointSet.union(first, second);
                cost += edge.getWeight();
                System.out.println("Taken " + edge);
            }
        }

        System.out.println("\nTotal cost of MST: " + cost);
    }


    // add a weighted undirected edge between two nodes
    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex - 1), nodeList.get(secondIndex - 1), weight);
        WeightedNode first = edge.getFirst();
        WeightedNode second = edge.getSecond();
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
        first.getWeightMap().put(second, weight);
        second.getWeightMap().put(first, weight);
        edgeList.add(edge);
    }
}
