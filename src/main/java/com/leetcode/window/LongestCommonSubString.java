package com.leetcode.window;

public class LongestCommonSubString {
    public static void main(String[] args) {
        //"acdde", "ace" 2
        //continuos logest common string
        String s = "acdde";
        String t = "ace";
        System.out.println(lcs(s,t,s.length(),t.length(),0));
    }
    static int lcs(String s,String t,int n,int m,int result) {
        if (n == 0 || m == 0) {
            return result;
        }

        int res = result;

        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            res = lcs(s, t, n - 1, m - 1, result + 1);
        } else {
            // Only reset count in mismatch case
            int skipS = lcs(s, t, n - 1, m, 0);
            int skipT = lcs(s, t, n, m - 1, 0);
            res = Math.max(res, Math.max(skipS, skipT));
        }

        return res;
    }
}
