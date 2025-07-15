package com.interviews;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,2,3},3)); //2
        System.out.println(subarraySum(new int[]{1,1,1},2)); //2
    }

    public static int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        return -1;
    }
}
