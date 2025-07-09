package com.leetcode;

public class KnapsackMatrix {
    public static void main(String[] args) {
        int[] weight = {3, 4, 5};
        int[] value  = {30, 50, 60};
        int   W      = 8;
        int n = weight.length;


        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = dp[i - 1][j];                 // skip
                if (weight[i - 1] <= j) {                // can take
                    int take = value[i - 1] + dp[i - 1][j - weight[i - 1]];
                    dp[i][j] = Math.max(dp[i][j], take);
                }
            }
        }
        printMatrix(dp);

    }
    static void printMatrix(int[][] dp) {
        for(int i=0;i<dp.length;i++) {
            for(int j=0;j < dp[0].length;j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
    }
}
