package com.leetcode.prac02;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    public void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        display(root.left);
        display(root.right);
    }
}

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        root.display(root);
        int[] res = new int[1];
        System.out.println("******");
        diameter(root, res);
        System.out.println(res[0]);
    }

    public static int diameter(Node root, int[] res) {
        if (root == null) {
            return 0;
        }
        int l = diameter(root.left, res);
        int r = diameter(root.right, res);

//        int temp = 1 + Math.max(l, r);
//        res[0] = Math.max(temp, l + r);
//        return temp;
        res[0] = Math.max(res[0], l + r);     // correctly update diameter
        return 1 + Math.max(l, r);            // return height
    }
}
