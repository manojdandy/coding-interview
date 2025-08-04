package com.leetcode.prac02;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossiblePathPrac02 {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        int[] paths = new int[1];
        backtracking(grid, 3, 3, 0, 0,paths);
        System.out.println(paths[0]);
    }

    public static void backtracking(int[][] grid, int n, int m, int i, int j,int[] paths) {
        if (i == n - 1 && j == m - 1) {
            paths[0]++;
            return;
        }
        if (i < n) {
            backtracking(grid, n, m, i + 1, j,paths);
        }
        if (j < m) {
            backtracking(grid, n, m, i, j + 1,paths);
        }
    }


    public static void backtrackingAllPaths(int[][] grid, int n, int m, int i, int j,
                                            List<String> currentPath, List<List<String>> allPaths) {
        // Out of bounds check
        if (i >= n || j >= m) return;

        // Add current position to path
        currentPath.add("(" + i + "," + j + ")");

        // If reached destination, add a copy of the current path
        if (i == n - 1 && j == m - 1) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            // Move down
            backtrackingAllPaths(grid, n, m, i + 1, j, currentPath, allPaths);
            // Move right
            backtrackingAllPaths(grid, n, m, i, j + 1, currentPath, allPaths);
        }

        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}
