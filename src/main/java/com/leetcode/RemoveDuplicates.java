package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        List<String> numsList = Arrays.stream(nums1).mapToObj(a -> String.valueOf(a)).collect(Collectors.toList());
        System.out.println(String.join(",",numsList));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 1;
        int right = 1;

        for(;right< nums.length;right++) {
            if(nums[right] != nums[right-1]) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
