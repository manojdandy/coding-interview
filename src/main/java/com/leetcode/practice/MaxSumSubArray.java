package com.leetcode.practice;

public class MaxSumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for(int i=1;i < nums.length;i++) {
            currentSum = Math.max(nums[i],currentSum+nums[i]);
            maxSum = Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}
