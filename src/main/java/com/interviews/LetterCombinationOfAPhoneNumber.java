package com.interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> result = new ArrayList<>();
        letterCombinations("23",0,map,result,new StringBuilder());
        System.out.println(result);
    }

    public static void letterCombinations(String digits,int index,
                                                  Map<Integer,String> map,
                                          List<String> result,
                                                  StringBuilder path) {
        if(index == digits.length()) {
            result.add(path.toString());
            return ;
        }
        System.out.println(digits.charAt(index));
        int digit = Character.getNumericValue(digits.charAt(index));
        System.out.println(digit);
        String letters = map.get(digit);
        for(char ch : letters.toCharArray()) {
            path.append(ch);
            letterCombinations(digits,index+1,map,result,path);
            path.deleteCharAt(path.length()-1);
        }

    }

}
