package com.prac01.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MissingAndRepetative {
    public static void main(String[] args) {
        List<Integer> list =missingAndDup( new int[] {3,1,3});
        System.out.println(list); //3,2
    }
    static List<Integer> missingAndDup(int[] nums) {
        List<Integer> list = new LinkedList<>();
        //right position of an element is arr[i]-1
        for (int i = 0;i<nums.length;i++) {
            if(i != nums[i]-1 && nums[i] != nums[i]-1) {
                swap(nums,i,nums[i]-1);
            }
        }
        System.out.println("temp ::" + Arrays.asList(nums));
        for (int i = 0;i<nums.length;i++) {
            if(i != nums[i]-1) {
                //duplcate
                list.add(nums[i]);
                //missing
                list.add(i+1);
            }
        }
        return list;
    }

    static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
