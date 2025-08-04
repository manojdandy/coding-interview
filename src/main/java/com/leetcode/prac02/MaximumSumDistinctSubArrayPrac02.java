package com.leetcode.prac02;


import java.util.HashSet;
import java.util.Set;

public class MaximumSumDistinctSubArrayPrac02 {
    public static void main(String[] args) {
        //   System.out.println(maximumSubarraySum1(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        //  System.out.println(maximumSubarraySum(new int[]{1, 1, 1, 7, 8, 9}, 3));
        //  System.out.println(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        //System.out.println(maximumSubarraySum(new int[]{9, 9, 9, 1, 2, 3}, 3));
        //  System.out.println(maximumSubarraySum(new int[]{3,5},1));
        System.out.println(maximumSubarraySum1(new int[]{5, 3, 3, 1, 1}, 3));
        // System.out.println(maximumSubarraySum1(new int[]{1, 2, 2}, 2));//3
        //  System.out.println(maximumSubarraySum1(new int[]{1, 1, 1, 7, 8, 9}, 3));//24
    }

    public static long maximumSubarraySum1(int[] nums, int k) {
        long maxSum = 0;
        if (nums.length < k) {
            return maxSum;
        }
        int left = 0;
        long currSum = 0;
        Set<Integer> set = new HashSet<>();
        for (int right = 0; right < nums.length; right++) {
            int rightEle = nums[right];
            int leftEle = nums[left];
            //shrink the window
            while (set.contains(rightEle) || set.size() >= k) {
                leftEle = nums[left];
                set.remove(leftEle);
                currSum -= leftEle;
                left++;
            }
            currSum += rightEle;
            set.add(rightEle);
            if (set.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }
        long maxSum = 0;
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        long currSum = 0;
        int count = 0;
        while (right < nums.length) {
            // currSum += nums[right];
            set.add(nums[right]);
            count++;
            if (count == k) {
                System.out.println("counter ::" + count + " ::num ::" + nums[right]);
                if (set.size() == k) {
                    currSum = 0;
                    for (int num : set) {
                        currSum += num;
                    }
                    maxSum = Math.max(currSum, maxSum);
                    set.remove(nums[left]);
                }
                //currSum -= nums[left];
                left++;
                count--;
            }
            right++;
        }
        return maxSum;
    }
}
