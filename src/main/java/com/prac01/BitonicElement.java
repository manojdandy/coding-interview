package com.prac01;

public class BitonicElement {
    public static void main(String[] args) {
        System.out.println(bitonic(new int[]{1, 2, 4, 5, 7, 8, 3})); // 8
        System.out.println(bitonic(new int[]{10, 20, 30, 40, 50})); //50
        System.out.println(bitonic(new int[]{120, 100, 80, 20, 0})); //120

    }

    static int bitonic(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if((mid == 0 || nums[mid] > nums[mid-1]) &&
                    (mid == nums.length-1 || nums[mid] > nums[mid+1])) {
                return nums[mid];
            } else if (mid == 0 || nums[mid] > nums[mid-1]) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }
}
