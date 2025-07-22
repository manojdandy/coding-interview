package com.prac01.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // permutations("abc", 0, new StringBuilder(), list);
        permutationsBackTracking ("abc".toCharArray(), 0, "", list);
        System.out.println(String.join(",", list));
        list = new ArrayList<>();
        System.out.println(String.join(",", list));
    }

    static void permutations(String s, int start, StringBuilder path, List<String> list) {
        if (s.length() == 0) {
            list.add(path.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                String newInput = s.substring(0, i) + s.substring(i + 1);
                path.append(s.charAt(i));
                set.add(s.charAt(i));
                permutations(newInput, start + 1, path, list);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    static void permutationsBackTracking(char[] s, int start, String path, List<String> list) {
        if (start == s.length - 1) {
            list.add(String.valueOf(s));
            return;
        }

        for (int i = start; i < s.length; i++) {
            swap(s, start, i);
            permutationsBackTracking(s, start + 1, String.valueOf(s), list);
            swap(s,i,start);
        }
    }

    static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
