package com.leetcode.window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumSumSubArraySizeK {
    public static void main(String[] args) {
       // System.out.println(maxSumSubArray(new int[] {2,5,1,8,9,10,10,10},3));
       // System.out.println(maxSumSubArrayOpt(new int[] {2,5,1,8,9,10,10,10},3));
        System.out.println(maxSumSubArrayDistinct(new int[] {2,5,1,8,9,10,10,10},3));
    }

    public static int maxSumSubArrayDistinct1(int[] nums,int size) {
        int best = 0;
        int sum = 0;
        List<Integer> tempList =  new ArrayList<>();
        for(int i=0;i < size;i++) {
            sum += nums[i];
            tempList.add(nums[i]);
        }
        if(isDistinct(tempList)) {
            best = sum;
        }
        for(int i = 1, j = size ; j < nums.length; i++,j++) {
            sum -= nums[i-1];
            sum += nums[j];
            tempList.remove(0);
            tempList.add(nums[j]);
            if(isDistinct(tempList)) {
                best = Math.max(best,sum);
            }
        }
        return best;
    }

    public static boolean isDistinct(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        return set.size() == list.size();
    }

    public static int maxSumSubArrayDistinct(int[] nums,int size) {
        int best = 0;
        int sum = 0;
        List<List<Integer>> subArrays = new ArrayList<>();

        List<Integer> tempList =  new ArrayList<>();
        for(int i=0;i < size;i++) {
            sum += nums[i];
            tempList.add(nums[i]);
        }
        subArrays.add(new ArrayList<>(tempList));
       // tempList.clear();
        best = sum;
        for(int i = 1, j = size ; j < nums.length; i++,j++) {
            sum -= nums[i-1];
            sum += nums[j];

            tempList.remove(0);
            tempList.add(nums[j]);
            if(isDistinct(tempList)) {
                best = Math.max(best,sum);
                subArrays.add(new ArrayList<>(tempList));
            }
        }
        return best;
    }


    public static int maxSumSubArrayOpt(int[] nums,int size) {
        int best = 0;
        int sum = 0;
        //List<List<Integer>> subArrays = new ArrayList<>();
        //List<int[]> subArrays = new ArrayList<>();

        for(int i=0;i < size;i++) {
            sum += nums[i];
        }
        best = sum;
        for(int i = 1, j = size ; j < nums.length; i++,j++) {
            sum -= nums[i-1];
            sum += nums[j];
            best = Math.max(best,sum);
        }
        return best;
    }
    public static int maxSumSubArray(int[] nums,int size) {
        int best = 0;
        for(int i = 0; i < nums.length;i++) {
            int sum = 0;
            for(int j = i ; j < i +3 && j < nums.length;j++) {
                sum += nums[j];
            }
            best = Math.max(best,sum);
        }
        return  best;
    }
}
