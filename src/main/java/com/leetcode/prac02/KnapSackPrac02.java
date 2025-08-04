package com.leetcode.prac02;

import java.util.HashMap;
import java.util.Map;

public class KnapSackPrac02 {
    public static void main(String[] args) {
        int[] weight = {3, 4, 5};
        int[] value = {30, 50, 60};
        int W = 8;
        System.out.println(knapsack(weight, value, value.length, W));
        Map<String, Integer> memo = new HashMap<>();
        System.out.println(knapsackMemo(weight, value, value.length, W, memo));
        System.out.println("***DP****");
        System.out.println(knapsackWithDP(weight, value, value.length, W));
    }

    public static int knapsackWithDP(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if(weights[i-1] <= j) {
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weights[i-1]],
                            dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static int knapsackMemo(int[] weights, int[] values, int n, int W, Map<String, Integer> memo) {
        int maxValue = -1;
        if (n == 0 || W == 0) {
            return 0;
        }
        String key = n + "," + W;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (weights[n - 1] <= W) {
            int v1 = values[n - 1] + knapsack(weights, values, n - 1, W - weights[n - 1]);
            int v2 = knapsack(weights, values, n - 1, W);
            maxValue = Math.max(v1, v2);
        } else {
            maxValue = knapsack(weights, values, n - 1, W);
        }
        memo.put(key, maxValue);
        return maxValue;
    }

    public static int knapsack(int[] weights, int[] values, int n, int W) {
        int maxValue = -1;
        if (n == 0 || W == 0) {
            return 0;
        }
        if (weights[n - 1] <= W) {
            int v1 = values[n - 1] + knapsack(weights, values, n - 1, W - weights[n - 1]);
            int v2 = knapsack(weights, values, n - 1, W);
            maxValue = Math.max(v1, v2);
        } else {
            return knapsack(weights, values, n - 1, W);
        }
        return maxValue;
    }
}
