package com.prac01.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

public class LCS {
    public static void main(String[] args) {
        //text1 = "abcde", text2 = "ace"
        System.out.println(longestCommonSubsequence("abcde", "ace"));//3
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        //return helper(text1, text2, text1.length(), text2.length());
        // return helper(text1, text2, text1.length(), text2.length(), new HashMap<>());
        return helperWithDP(text1, text2, text1.length(), text2.length());
    }

    public static int helper(String s, String t, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        int res = 0;
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            res = 1 + helper(s, t, n - 1, m - 1);
        } else {
            res = Math.max(helper(s, t, n - 1, m), helper(s, t, n, m - 1));
        }
        return res;
    }

    public static int helper(String s, String t, int n, int m, Map<Pair, Integer> memo) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (memo.containsKey(new Pair(n, m))) {
            return memo.get(new Pair(n, m));
        }
        int res;
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            res = 1 + helper(s, t, n - 1, m - 1, memo);
        } else {
            res = Math.max(helper(s, t, n - 1, m, memo), helper(s, t, n, m - 1, memo));
        }
        memo.put(new Pair(n, m), res);
        return res;
    }

    public static int helperWithDP(String s, String t, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }
        return dp[n][m];
    }
}
