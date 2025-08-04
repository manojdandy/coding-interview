package com.leetcode.dp;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        System.out.println(mcm(new int[]{2, 1, 3, 4}, 1, 3));
    }

    public static int mcm(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = mcm(arr, i, k) + mcm(arr, k + 1, j) +
                    arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, temp);
        }
        return min;
    }
}
