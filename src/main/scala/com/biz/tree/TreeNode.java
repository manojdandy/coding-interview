package com.biz.tree;

public class TreeNode {
    int val;
    TreeNode root;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
       
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public void insert(int data) {
        if(root == null) {
            root = new TreeNode(data);
        } else if (root.val <= data) {
            root = root.right;
            insert(data);
        }else {
            root = root.left;
            insert(data);
        }
    }
}
