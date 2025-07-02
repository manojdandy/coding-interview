package com.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final Map<Integer,Node> map = new HashMap<>();
    private  int capacity = 0;
    private final Node head = new Node(0, 0);
    private final Node tail = new Node(0, 0);

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);           // {1=1}
        cache.put(2, 2);           // {2=2, 1=1}
        System.out.println(cache.get(1)); // 1
        cache.put(3, 3);           // evicts key 2 → {3=3, 1=1}
        System.out.println(cache.get(2)); // -1
        cache.put(4, 4);           // evicts key 1 → {4=4, 3=3}
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    static class Node {
        int key,val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
   // insert node at head
    private void addNode(Node node) {
        map.put(node.key,node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    //remove node
    private void removeNode(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveNodeFront(Node node) {
        removeNode(node);
        addNode(node);

    }
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveNodeFront(node);
        return node.val;
    }

    public void put(int key,int val) {
        Node node = map.get(key);
        if(node == null) {
            if(map.size() == capacity)
                removeNode(tail.prev);
            addNode(new Node(key,val));
        }else {
            node.val = val;
            moveNodeFront(new Node(key,val));
        }
    }
}
