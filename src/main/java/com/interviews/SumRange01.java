package com.interviews;

import java.util.ArrayList;
import java.util.List;

public class SumRange01 {
    public static void main(String[] args) {
        //A = [1,2,3,5,6,9] and 2-d array B = [[0,3],[1,2]] Output = [11, 5]

        System.out.println(sumRange(new int[]{1,2,3,5,6,9},new int[][]{{0,3},{1,2}}));

    }
    public static List<Integer> sumRange(int[] nums,int[][] range) {
        int[] prefixSum = new int[nums.length];
        List<Integer> result = new ArrayList<>();
        prefixSum[0] = nums[0];
        for(int i=1;i < nums.length;i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }

        for(int[] query : range) {
            int start = query[0];
            int end = query[1];
            if(start == 0) {
                result.add(prefixSum[end]);
            }else {
                result.add(prefixSum[end]-prefixSum[start-1]);
            }
        }
        return result;
    }
}
