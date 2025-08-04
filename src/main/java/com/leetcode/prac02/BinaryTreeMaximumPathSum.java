package com.leetcode.prac02;

public class BinaryTreeMaximumPathSum {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[] res = new int[1];
        maxPathSum(root, res);
        System.out.println(res[0]);
    }

    public static int maxPathSum(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0,maxPathSum(root.left, res));
        int r = Math.max(0,maxPathSum(root.right, res));
        //path through root
        int pathThroughRootVal = root.data + l + r;
        res[0] = Math.max(res[0], pathThroughRootVal);
        return root.data + Math.max(l, r);

    }
}
