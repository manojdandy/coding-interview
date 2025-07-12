package com.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class MissingNumber {
   static class Pair {
        List<Integer> missings;
        List<Integer> duplicates;

        public Pair(List<Integer> missings, List<Integer> duplicates) {
            this.missings = missings;
            this.duplicates = duplicates;
        }
    }
    public static void main(String[] args) {
       // System.out.println(missingNumber(new int[]{3,0,1}));
        Pair p = missingNumber(new int[]{2,3,1,8,2,3,5,1});
        System.out.println(p.duplicates); // 1,2,3
        System.out.println(p.missings); // 4,6,7
    }
    public static Pair missingNumber(int[] nums) {
        List<Integer> missings = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        for(int i = 0;i < nums.length;i++) {
            if(i != nums[i]-1)
                swap(nums,i,nums[i]-1);
        }

        for(int i=0;i< nums.length;i++) {
            if(i != nums[i]-1) {
               // return i;
                missings.add(i+1);
                duplicates.add(nums[i]);
            }
        }
        String[] strArr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(",", strArr));
        return new Pair(missings,duplicates);
    }
    static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
