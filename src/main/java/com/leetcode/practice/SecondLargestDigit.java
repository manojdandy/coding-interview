package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class SecondLargestDigit {
    public static void main(String[] args) {
        int secondLargest = secondHighest("dfa12321afd");
        System.out.println("secondLargest :: " + secondLargest);
    }

    public static int secondHighest(String s) {
        int largest = -1;
        int secondlargest = -1;

        for(char c: s.toCharArray()) {
            if(!Character.isDigit(c)) continue;;
            System.out.println("Char >>> " + c);
            int d = c-'0';
            if(d > largest) {
                secondlargest = largest;
                largest = d;
            }
        }
        return  secondlargest;
    }
}
