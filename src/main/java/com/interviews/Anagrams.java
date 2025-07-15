package com.interviews;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(isAnagram2( "anagram","nagaram"));//true
       // System.out.println(isAnagram( "rat","car"));//false
        //System.out.println(isAnagram( "aacc","ccac"));//false

    }

    public static boolean isAnagram2(String s, String t) {
        int[] frq = new int[26];
        for(int i = 0; i < 26 && i < s.length();i++) {
            frq[s.charAt(i) -'a']++;
            frq[t.charAt(i) -'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for(int f : frq) {
            sb.append(f).append("#");
        }

        for(int i = 0;i< 26;i++) {
            if(frq[i] != 0) {
              return false;
            }
        }
        return true;
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray()) {
            freq.put(ch,freq.getOrDefault(ch,0) + 1);
        }
        for(char ch : t.toCharArray()) {
            if(!freq.containsKey(ch)) {
                return false;
            }
            int x = freq.get(ch);
            if(x-1 == 0) {
                freq.remove(ch);
            }else {
                freq.put(ch, x - 1);
            }
        }
        return true;
    }

}
