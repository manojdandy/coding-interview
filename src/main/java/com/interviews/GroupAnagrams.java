package com.interviews;
import  java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> list = groupAnagrams2(new String[] {"eat","tea","tan","ate","nat","bat"});
        System.out.println(list);
    }
    public static  List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, __ -> new ArrayList<>()).add(word);
//            if(map.containsKey(sorted)) {
//              map.get(sorted).add(word);
//            }else  {
//                List<String> list = new ArrayList<>();
//                list.add(word);
//                map.put(sorted,list);
//            }

        }

        return new ArrayList<>(map.values());
    }

    public static  List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String word : strs) {
            int[] frq = new int[26];
            for(int i  = 0; i < 26;i++) {
                frq[word.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int f : frq) {
                sb.append(f).append("#");
            }
            map.computeIfAbsent(sb.toString(), __ -> new ArrayList<>()).add(word);


        }

        return new ArrayList<>(map.values());
    }

    public static boolean isAnagram(String s,String t) {
        int[] frq = new int[26];
        for(int i = 0; i < 26;i++) {
            frq[s.charAt(i) - 'a']++;
            frq[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26;i++) {
            if(frq[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
