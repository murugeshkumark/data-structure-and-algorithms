package com.github.murugeshkumark.ds.graph.dfs;

import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

    private final Map<Integer, List<Integer>> adjacencyList;
    private boolean[] visited;

    public DepthFirstSearch(Map<Integer, List<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.visited = new boolean[adjacencyList.size()];
    }

    void dfs(int node){
        if(visited[node]) return;
        visited[node] = true;
        List<Integer> neighbours = adjacencyList.get(node);
        for(int next : neighbours){
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

}
