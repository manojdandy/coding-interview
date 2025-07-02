package com.leetcode.window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        //Input: s = "ADOBECODEBANC", t = "ABC"
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        String minStr = s;
        int best = 0;
        //
        for(Character ch : t.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        for(int i = 0, j = 0;  j < s.length();j ++) {

        }
        return minStr;
    }

}
