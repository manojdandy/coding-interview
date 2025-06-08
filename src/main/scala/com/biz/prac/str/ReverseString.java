package com.biz.prac.str;

public class ReverseString {
    public static void main(String[] args) {
       String s = "the sky  is blue";
        String[] sp = s.split(" ");
        for(String s1 : sp) {
            System.out.println(s1);
        }
        System.out.println(reverseWord("the sky  is         blue".split(" ")));
    }
    static String reverseWord(String[] ch) {
        StringBuilder sb = new StringBuilder();
        for(int i=ch.length-1;i >=0;i--) {
            if(ch[i].length() == 0) {
                continue;
            }
            sb.append(ch[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    static String reverse(char[] ch) {
        StringBuilder sb = new StringBuilder();
        for(int i=ch.length-1;i >=0;i--) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}
