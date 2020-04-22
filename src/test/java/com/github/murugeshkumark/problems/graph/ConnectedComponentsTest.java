package com.github.murugeshkumark.problems.graph;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedComponentsTest {

    @Test
    public  void testConnectedComponents(){


        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        adjacencyList.put(1, Arrays.asList(2,3,4));
        adjacencyList.put(3, Arrays.asList(1,4));
        adjacencyList.put(5, Arrays.asList(0));
        ConnectedComponents connectedComponents = new ConnectedComponents(adjacencyList,6);
        System.out.println(connectedComponents.connectedComponents());
    }

}
