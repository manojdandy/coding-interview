package com.leetcode.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        //Input: s = "ADOBECODEBANC", t = "ABC"
       // System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        //System.out.println(minWindow("TOTMTAPTAT", "TTA"));
        System.out.println("********************");
        System.out.println(minWindow("A", "A"));
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

}
