package com.leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int max = 0;

        return null;
    }
    public static void helper(String s,int start) {
        if(start == s.length()) {
            return;
        }

    }
    public static boolean isPalindrome(String s) {
        if(s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
