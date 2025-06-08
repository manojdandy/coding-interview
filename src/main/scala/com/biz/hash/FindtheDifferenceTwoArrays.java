package com.biz.hash;

import java.util.*;


public class FindtheDifferenceTwoArrays {
    public static void main(String[] args) {
        findDifference(new int[] {1,2,3,3},new int[]{1,1,2,2});
    }
    static List<List<Integer>> findDifferences(int[] num1,int[] num2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        return null;
    }
    public static  List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> arr1 = new HashSet<>(); // Missing in arr1
        Set<Integer> arr2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int n : nums1) {
            arr1.add(n);
        }
        for(int n : nums2) {
            arr2.add(n);
        }

        for(int n:nums1) {
            if(list1.contains(n)) {
                continue;
            }
            if(!arr2.contains(n)) {
                   list1.add(n);
            }
        }
        for(int n:nums2) {
            if(!arr1.contains(n)) {
                list2.add(n);
            }
        }

        result.add(list1);
        result.add(list2);
        return  result;

    }
}
