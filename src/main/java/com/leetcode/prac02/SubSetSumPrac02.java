package com.leetcode.prac02;

public class SubSetSumPrac02 {
    public static void main(String[] args) {
        System.out.println(subsetSum(new int[]{3, 34, 4, 12, 5, 2}, 7, 6));
        System.out.println(subsetSumWithDP(new int[]{3, 34, 4, 12, 5, 2}, 7, 6));
    }

    /**
     * @param arr
     * @param target
     * @param n:     array length
     * @return
     */
    public static boolean subsetSum(int[] arr, int target, int n) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || n == 0) {
            return false;
        }

        if (arr[n - 1] <= target) {
            int rem = target - arr[n - 1];
            return subsetSum(arr, rem, n - 1) || subsetSum(arr, target, n - 1);
        } else {
            return subsetSum(arr, target, n - 1);
        }
    }

    public static boolean subsetSumWithDP(int[] arr, int target, int n) {
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}
