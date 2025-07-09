package com.leetcode;

public class SubSetSum {
    public static void main(String[] args) {
        int[] nums   = {3, 34, 4, 12, 5, 2};
        int  target1 = 9;     // 4 + 3 + 2  → true
        int  target2 = 30;    // no subset  → false

        System.out.println(subsetSum(nums,0, target1)); // true
        System.out.println(subsetSum(nums,0, target2));
    }
    public static boolean subsetSum(int[] nums,int i,int target) {
        if(target == 0) {
            return true;
        }
        if(nums.length == i || target < 0) {
            return false;
        }
        //choice1: include
        boolean res = subsetSum(nums,i+1,target - nums[i]);
        if(res) {
            return  true;
        }
        //choice:2 exclude
        boolean res1 = subsetSum(nums,i+1,target);
        return res1;
    }
}
