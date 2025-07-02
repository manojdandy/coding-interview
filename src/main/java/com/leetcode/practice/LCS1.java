package com.leetcode.practice;

import org.apache.spark.sql.sources.In;

import java.util.HashMap;
import java.util.Map;

public class LCS1 {
    public static void main(String[] args) {
        System.out.println(String.valueOf('h'));
        String input = "abbaccccd"; // length of longest common substring of two character
        //output : 5 (acccc,ccccd)
    }
    public int lcs(String input) {
        if(input == null || input.isEmpty()) return 0;
        int left = 0;
        int best = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for(int right=0;right < input.length();right++) {
            char ch = input.charAt(right);
            freq.put(ch,freq.getOrDefault(ch,0) + 1);
            //shrink window until it has <= two character
            while (freq.size() > 2) {
                char leftchar = input.charAt(left++);
                int cnt = freq.get(leftchar) - 1;
                if(cnt == 0) {
                    freq.remove(leftchar);
                }
            }
            best = Math.max(best,right-left+1);
        }
        return best;
    }
}
