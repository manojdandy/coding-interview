package com.leetcode.window;

public class LargestSumSubArraySizeK {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5,1,1,9,1};
        System.out.println(maxSubArray(nums1,7));
        System.out.println(maxSubArray(new int[]{2,2,1,1,1,1},4));
    }
    //optimize
    public static  int maxSubArrayOpt(int[] nums,int size) {
        int best = -1;

        return best;
    }
    public static  int maxSubArray(int[] nums,int size) {
        int best = 0;
        for(int i=0;i < nums.length;i++) {
            int cnt = 0;
            int sum = 0;
            for(int j = i; j < nums.length;j++) {
                cnt++;
                sum += nums[j];
                if(sum == size) {
                    best = Math.max(best,cnt);
                    break;
                }
            }
        }
        return best;
    }
}
