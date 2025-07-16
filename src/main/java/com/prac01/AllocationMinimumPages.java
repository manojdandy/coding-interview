package com.prac01;

public class AllocationMinimumPages {
    public static void main(String[] args) {
        System.out.println(allocation(new int[]{12, 34, 67, 90},2)); //113
        System.out.println(allocation(new int[]{15, 17, 20},5)); // -1
        System.out.println(allocation(new int[] {22, 23, 67},1));//112
    }

    public static int allocation(int[] nums,int k) {
        if(k > nums.length) {
            return -1;
        }
        int start = 0;
        int res = -1;
        for (int i = 0;i< nums.length;i++) {
            start = Math.max(start,nums[i]);
        }
        int end = 0;
        for (int i = 0;i< nums.length;i++) {
            end += nums[i];
        }
        while (start <= end) {
            int mid = start + (end-start)/2;
            if(isValid(nums,k,mid)) {
                res = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return res;
    }

    private static boolean isValid(int[] nums, int k,int maxPage) {
        int student = 1;
        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            sum += nums[i];
            if(sum > maxPage) {
                student++;
                sum = nums[i];
            }
            if (student > k)
                return false;
        }
        return true;
    }
}
