package com.leetcode.dp;

public class ScrambledString {
    public static void main(String[] args) {
        String temp = "great";
        String temp2 = "eatgr";
        int i = 2;
        int n = temp.length();//5
        //first part of string compare with last part of string 2
        String apart1 = temp.substring(0, i);
        String bpart2 = temp2.substring(n - i, n);
        //compare last part of string1 to first part of string2
        String apart2 = temp.substring(i, n);
        String bpart1 = temp2.substring(0, i);
        //System.out.println(temp.substring(0, 2));
        System.out.println(isScramble("great","eatgr"));
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            //without swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            //with swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i))
                    && isScramble(s1.substring(i), s2.substring(0,i))) {
                return true;
            }
        }

        return false;
    }

}
