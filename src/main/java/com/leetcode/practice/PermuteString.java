package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {
    public static void main(String[] args) {
        boolean[] chars = new boolean[26];
        System.out.println(chars[0]);
        List<String> perms = new ArrayList<>();
        System.out.println("**");
        //
       permute("abc","");
    }

    static  void permute(String ip,String op) {
        if(ip.length() == 0) {
            System.out.println(op);
            return;
        }
        for(int i = 0; i < ip.length();i++) {
            char ch = ip.charAt(i);
            String ros = ip.substring(0,i) + ip.substring(i+1);
            permute(ros,op+ch);
        }
    }
}
