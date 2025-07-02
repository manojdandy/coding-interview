package com.leetcode.practice;

public class StringToInteger {
    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("   -042"));
//        System.out.println(myAtoi("1337c0d3"));
//        System.out.println(myAtoi("0-1"));
//        System.out.println(myAtoi("words and 987"));
        System.out.println("min value ::" + Integer.MIN_VALUE);
        System.out.println("MAX_VALUE value ::" + Integer.MAX_VALUE);
        System.out.println("Compare ::" + (-912834723 < Integer.MIN_VALUE) );
        System.out.println(myAtoi("-91283472332"));

    }

    public static  int myAtoi(String s) {
        long digits = 0;
        int sign = 1;
        boolean firstChar = true;

        for(char ch : s.toCharArray()) {
            System.out.println("digits :: " + digits +  " :: sign  :: " + sign);
            if(ch == ' ') {
                continue;
            }

            if(ch == '-' && firstChar) {
              //  System.out.println("sign :: " + ch);
                sign = -1;
            }
            if(!Character.isDigit(ch) && (ch != '-' || !firstChar)) {
               // System.out.println("break sign :: " + ch);
                break;
            }
            if(Character.isDigit(ch)) {
                int digit = ch - '0';
                digits = digits * 10 + digit;
            }
            if(sign == 1 && digits > Integer.MAX_VALUE) {
                System.out.println("enter into max");
                return  Integer.MAX_VALUE;
            }
            if(sign == -1 && -digits < Integer.MIN_VALUE) {
                System.out.println("enter into min");
                return  Integer.MIN_VALUE;
            }
            firstChar = false;
        }

        return (int) digits * sign;

    }
}
