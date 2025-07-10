package com.leetcode.practice;

import java.util.*;

public class TopoLogical {
    public static void main(String[] args) {
        int V = 6;
        //int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
       int[][] edges = {{2,3}, {3,1}, {4,0}, {4,1}, {5,0}, {5,2}};
        //[[2,3], [3,1], [4,0], [4,1], [5,0], [5,2]]
//        List<Integer>[] adj = constructadj(V,edges);
//        for(List<Integer> list : adj) {
//            System.out.println(list);
//        }
        int[] result = topologicalSort(V,edges);
        for (int v:result) {
            System.out.print(v +",");
        }
    }

    // We mainly take input graph as a set of edges. This function is
    // mainly a utility function to convert the edges to an adjacency
    // list
    static List<Integer>[] constructadj(int V, int[][] edges) {
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }

        return adj;
    }

    public static int[] topologicalSort(int V,int[][] edges) {
        int[] result = new int[V];
        int[] indegress = new int[V];
        List<Integer>[] adjList = constructadj(V,edges);
       for(int i=0;i< V;i++) {
           for(int neighber : adjList[i]) {
               indegress[neighber]++;
           }
       }
       Queue<Integer> queue = new LinkedList<>();
       int index = 0;

       for(int i=0;i < V;i++) {
           if(indegress[i]==0) {
               queue.offer(i);
           }
       }

       while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;
            for(int neighber:adjList[node]) {
                indegress[neighber]--;
                if(indegress[neighber] == 0) {
                    queue.offer(neighber);
                }
            }
       }
        return result;
    }


}
