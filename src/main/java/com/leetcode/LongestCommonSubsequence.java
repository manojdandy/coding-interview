package com.leetcode;


import java.util.*;

class Pair {
    int n, m;

    public Pair(int n, int m) {
        this.n = n;
        this.m = m;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return n == pair.n && m == pair.m;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, m);
    }
}

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        boolean[][] visited = new boolean[10][5];

        System.out.println(visited[0].length);
        System.out.println(visited.length);
        System.out.println("*******");
        Set<Pair> pairs = new HashSet<>();
        pairs.add(new Pair(10, 5));
        pairs.add(new Pair(10, 5));
        System.out.println(pairs.size());
        System.out.println("**************");
        System.out.println(longestCommonSubsequence("abcde", "ace"));//3
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        Map<Pair, Integer> memo = new HashMap<>();
        //return helper(text1,text2,text1.length(),text2.length());
        // return helperWithMem(text1,text2,text1.length(),text2.length(),memo);
        return helperWithDP(text1, text2, text1.length(), text2.length());
    }

    public static int helper(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return 1 + helper(text1, text2, n - 1, m - 1);
        } else {
            return Math.max(helper(text1, text2, n, m - 1),
                    helper(text1, text2, n - 1, m));
        }
    }


    public static int helperWithMem(String text1, String text2, int n, int m, Map<Pair, Integer> memo) {
        if (n == 0 || m == 0)
            return 0;
        Pair pair = new Pair(n, m);
        if (memo.containsKey(new Pair(n, m))) {
            return memo.get(new Pair(n, m));
        }
        int res = 0;
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            res = 1 + helperWithMem(text1, text2, n - 1, m - 1, memo);
        } else {
            res = Math.max(helperWithMem(text1, text2, n, m - 1, memo),
                    helperWithMem(text1, text2, n - 1, m, memo));
        }
        memo.put(pair, res);
        return res;
    }

    public static int helperWithDP(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j], dp[i][j - 1]
                    );
                }
            }
        }

        return dp[n][m];
    }
}
