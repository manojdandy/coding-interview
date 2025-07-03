package com.leetcode.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        //Input: s = "ADOBECODEBANC", t = "ABC"
       System.out.println(minWindow1("ADOBECODEBANC", "ABC"));
        //System.out.println(minWindow("TOTMTAPTAT", "TTA"));
        System.out.println("********************");
       // System.out.println(minWindow("A", "A"));
       // System.out.println("ADOBECODEBANC".substring(0,2));
    }

    public static String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int count = 0; // it tells unique characters in the target string
        List<String> list = new ArrayList<>();
        String minStr = s;
        int best = -1;
        //
        for(Character ch : t.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        count = map.size(); //

        for(int i = 0, j = 0;  j < s.length();j ++) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                int x = map.get(ch);
                if(x-1 == 0) {
                    count = count -1;
                }
                map.put(ch,x-1);
            }

            if(count ==  0) {
                list.add(s.substring(i,j+1));
                //increment i
                while(i < j) {
                    char chr = s.charAt(i);
                    if(map.containsKey(chr)) {
                        int x = map.get(chr);
                        if(x == 0) {
                            break;
                        }
                        map.put(chr,map.get(chr)+1);
                    }
                    i++;
                }
                list.add(s.substring(i,j+1));
            }

        }
        System.out.println(String.join(",",list));
        for(String str : list) {
            if(str.length() <= minStr.length()) {
                best = str.length();
                minStr = str;
            }
        }
        return best != -1?  minStr : "";
    }


    public static String minWindow1(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // --- frequency map for the target string -------------
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        int need = map.size();                 // how many distinct chars still > 0 ?

        // --- sliding-window pointers & best window -----------
        int minLen = Integer.MAX_VALUE;        // length of best window so far
        int bestL  = 0;                        // its starting index

        // -----------------------------------------------------
        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) need--;   // this char is now satisfied
            }

            // window contains all chars → try to shrink from the left
            while (need == 0) {
                // update best window before we lose validity
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    bestL  = left;
                }

                char lc = s.charAt(left++);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1); // put it back
                    if (map.get(lc) > 0) need++;  // window no longer satisfies lc
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + minLen);
    }
}
