package com.leetcode;

public class Search2DMatrix {
    public static void main(String[] args) {
        //matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
        System.out.println(searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}},8));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m-1;

        while (i >= 0 && i < n && j >=0 && j < m) {
            if(matrix[i][j] == target) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}
