package com.biz.common.questions;



//import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class DuplicateDetection {
    public static void main(String[] args) {
        System.out.println(isDuplicate(new int[]{1,2,3}));
        System.out.println(isDuplicate(new int[]{1,2,3,1}));
        //assertEquals(true,isDuplicate(new int[]{1,2,3}),"the array contains duplicate");

    }

    private static boolean isDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int a : arr) {
            if(set.contains(a)) {
                return true;
            }
            set.add(a);
        }
        return false;
    }

}

