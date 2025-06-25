package com.biz.graph;

import java.util.*;

public class DFSGraph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjList = null; // Adjacency list

    // Constructor
    public DFSGraph(int v) {
        vertices = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add edge (undirected graph)
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    // DFS utility function
    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // DFS traversal from a given start vertex
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS starting from vertex " + start + ": ");
        dfsUtil(start, visited);
        System.out.println();
    }

    // Main method to test the graph
    public static void main(String[] args) {
        DFSGraph graph = new DFSGraph(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.DFS(0); // Start DFS from vertex 0
    }
}
