package com.github.murugeshkumark.problems.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConnectedComponents {

    private final Map<Integer, List<Integer>> adjacencyList;
    int[] connectionArray;
    boolean[] visted;

    public ConnectedComponents(Map<Integer, List<Integer>> adjacencyList, int noOfNodes) {
        this.adjacencyList = adjacencyList;
        visted = new boolean[noOfNodes];
        connectionArray = new int[noOfNodes];
    }

    public List<List<Integer>> connectedComponents(){

        int noOfComponents = assignConnectionId();

        List<List<Integer>> connectedComponents = new ArrayList<>();
        for(int i= 0; i<=noOfComponents;i++ ){
            List<Integer> currentCluster = new ArrayList<>();
            for(int j = 0; j<connectionArray.length;j++){
                if(connectionArray[j] == i)
                    currentCluster.add(j);
            }
            if(!currentCluster.isEmpty())
                connectedComponents.add(currentCluster);
        }

        return connectedComponents;
    }

    private int assignConnectionId() {
        int connectionId = 0;

        for(Map.Entry<Integer, List<Integer>> entry : adjacencyList.entrySet()) {
            if (!visted[entry.getKey()]) {
                dfs(entry.getKey(), connectionId++);
            }
        }

        return connectionId;
    }

    private void dfs(int value, int connectionId) {
       visted[value] = true;
       connectionArray[value] = connectionId;
       if(!adjacencyList.containsKey(value)) return;
       for(int next : adjacencyList.get(value)){
           if(!visted[next]){
               dfs(next, connectionId);
           }
       }
    }


}
