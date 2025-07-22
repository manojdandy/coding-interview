package com.leetcode;

public class MaximumProfit {
    public static void main(String[] args) {
        //  System.out.println(findMaxProfit(new int[] {7,1,5,3,6,4}));
        //System.out.println(findMaxProfit(new int[]{1,4,2}));
        System.out.println(findMaxProfit(new int[]{2, 1, 4}));
    }

    static int findMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int currentProfit = price - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}
