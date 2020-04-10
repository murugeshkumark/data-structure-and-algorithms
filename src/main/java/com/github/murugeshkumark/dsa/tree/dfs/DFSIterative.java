package com.github.murugeshkumark.dsa.tree.dfs;

import com.github.murugeshkumark.dsa.node.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

public class DFSIterative {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();


	public DFSIterative(ArrayList<GraphNode> nodeList) {
		
		this.nodeList = nodeList;
	}
	
	
	void dfs() {
		//if a com.github.murugeshkumark.dsa.node is unvisited then run com.github.murugeshkumark.dsa.tree.dfs on it
		for(GraphNode node: nodeList) {
			if(!node.isVisited())
				dfsVisit(node);
		}
	}
	
	
	//com.github.murugeshkumark.dsa.tree.dfs traversal by a source com.github.murugeshkumark.dsa.node
	void dfsVisit(GraphNode node) {
		//make an empty com.github.murugeshkumark.dsa.stack
		Stack<GraphNode>stack = new Stack<>();
		//add source com.github.murugeshkumark.dsa.node to com.github.murugeshkumark.dsa.stack
		stack.push(node);
		//while com.github.murugeshkumark.dsa.queue is not empty
		while(!stack.isEmpty()) {
			//pop a com.github.murugeshkumark.dsa.node from com.github.murugeshkumark.dsa.stack
			GraphNode presentNode = stack.pop();
			//mark com.github.murugeshkumark.dsa.node as visited
			presentNode.setVisited(true);
			//print the com.github.murugeshkumark.dsa.node
			System.out.print(presentNode.getName()+" ");
			//for each neighbor of present com.github.murugeshkumark.dsa.node
			for(GraphNode neighbor: presentNode.getNeighbors()) {
				//if neighbor is not visited then add it to com.github.murugeshkumark.dsa.queue
				if(!neighbor.isVisited()) {
				
					stack.add(neighbor);
					neighbor.setVisited(true);
				}
			}
		
		}
	}
	
	
	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i-1);
		GraphNode second = nodeList.get(j-1);
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
	}
	
}