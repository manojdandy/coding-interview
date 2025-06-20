package com.biz.graph;

import java.util.ArrayList;

class ListNode {
    ListNode prev;
    ListNode next;
    int data;

    public ListNode() {
        this.prev = null;
        this.next = null;
    }

    public ListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    //inset at beginning
    public  ListNode insertAtBeginning(ListNode head,int data) {
        ListNode newNode = new ListNode(data);
        newNode.next =head;
        if(head != null) {
            head.prev = newNode;
        }

        return  newNode;
    }
    // Print the linked list (for debugging)
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class Graph {
    private ArrayList<Integer> vertices;
    private int vertexCount = 0;
    private ListNode[] edges;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        vertices = new ArrayList<Integer>();
        edges = new ListNode[vertexCount];
        for(int i = 0;i < vertexCount;i++) {
            vertices.add(i);
            edges[i] = new ListNode();
        }
    }

    public void addEdge(int source,int destination) {
        int i = vertices.indexOf(source);
        int j = vertices.indexOf(destination);

        if(i != -1 || j != -1) {
            edges[i].insertAtBeginning(edges[i],destination);
            edges[i].insertAtBeginning(edges[i],source);
        }
    }

    public void printGraph() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print("Vertex " + vertices.get(i) + ": ");
            ListNode.printList(edges[i]);
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }

}
