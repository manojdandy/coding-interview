package com.leetcode;

public class PalindromNumber {
    public static  boolean isPalindrome(int x) {
        if(x < 0)
            x = -x;

        int y = x;

        String r = "";
        while(x != 0) {
            r = r + (x % 10);
            x = x/10;
        }
        System.out.println(r);
        int rn = Integer.parseInt(r);
        System.out.println("rn == " + rn + " :: x :: " + x);
        if(rn == y)
            return  true;
        return false;
    }

    public static void main(String[] args) {
        int x = 321;
        String r = "";
        while(x != 0) {
            r = r + (x % 10);
            x = x/10;
        }
        System.out.println(r);
        System.out.println(isPalindrome(121));
    }
}
