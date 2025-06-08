package com.biz.prac;

import java.util.List;

public class TripletSum {
    public static void main(String[] args) {
        List<List<Integer>> ls =  threeSum(new int[]{2, -2, 0, 3, -3, 5});

        for(List<Integer> i:ls) {
            for(int j:i) {
                System.out.println(j);
            }
            System.out.println();
        }

    }
    public static  List<List<Integer>> threeSum(int[] nums) {
        return null;
    }
}
