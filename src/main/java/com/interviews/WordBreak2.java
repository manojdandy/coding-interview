package com.interviews;

import java.util.*;

public class WordBreak2 {
    public static void main(String[] args) {
            //Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
        //Output: ["cats and dog","cat sand dog"]
        System.out.println(wordBreak("catsanddog",Arrays.asList("cat","cats","and","sand","dog")));

    }

    static List<String> finalResult = new ArrayList<>();
    public static List<String> helper(String s, List<String> wordDict, int start, Set<String> current) {
        if (start == s.length()) {
            finalResult.add(String.join(" ", current));
            return finalResult;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);
            if (wordDict.contains(word)) {
                current.add(word);
                helper(s, wordDict, i, current);  // move to i, not start + 1
                current.remove(current.size() - 1);  // backtrack
               // current.re
            }
        }

        return finalResult;
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        helper(s,wordDict,0,new HashSet<>());
        System.out.println("word break result ::" + finalResult);
        return null;
    }

    private static List<String> helper(String s, List<String> wordDict, int start, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> result = new ArrayList<>();

        if (start == s.length()) {
            result.add(""); // base case: add empty sentence
            return result;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String word = s.substring(start, i);

            if (wordDict.contains(word)) {
                List<String> subSentences = helper(s, wordDict, i, memo);

                for (String sub : subSentences) {
                    result.add(word + (sub.isEmpty() ? "" : " " + sub));
                }
            }
        }

        memo.put(start, result); // store result for this start index
        return result;
    }
}
