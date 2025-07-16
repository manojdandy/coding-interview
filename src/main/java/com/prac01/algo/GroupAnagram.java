package com.prac01.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * # # Example:
 * # # Input: ["row", "a", "wor", "test", "ttes", "tset"]
 * # # Output: [["row", "wor"], ["a"], ["test", "ttes", "tset"]
 */
public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(List.of("row", "a", "wor", "test", "ttes", "tset")));
    }

    static List<List<String>> groupAnagrams(List<String> inputList) {
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String input : inputList) {
            int[] alphabets = new int[26];
            //int[] s2 = new int[s.length()]
            for (int i = 0; i < input.length(); i++) {
                alphabets[input.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(alphabets[i]).append("#");
            }
            String key = sb.toString();
//            List<String> temp = map.getOrDefault(sb.toString(),new ArrayList<String>());
//                    temp.add(input);
//            map.put(sb.toString(),temp);
            map.computeIfAbsent(key, __ -> new ArrayList<>()).add(input);

        }

        return new ArrayList<>(map.values());
    }


    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabets = new int[26];
        //int[] s2 = new int[s.length()]
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
            alphabets[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
