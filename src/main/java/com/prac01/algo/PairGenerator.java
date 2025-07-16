package com.prac01.algo;

import java.util.ArrayList;
import java.util.List;

public class PairGenerator {
    public static void main(String[] args) {
        //paris_code = ['*#%$', '2345678']
        //sample scooter code from above inputs are - '*2', '*3', '*4','*5','*6','*7','*8','#2','#3','#4','#5' and so on.
        List<String> result = new ArrayList<>();
        String[] paris_code = new String[] {"*#%$", "2345678"};
        helper(paris_code,0,result,new StringBuilder());
        System.out.println(result);
    }

    static void helper(String[] codes, int index, List<String> result,StringBuilder path) {
        if(codes.length == index) {
            result.add(path.toString());
            return;
        }
        for(int i = 0;i< codes[index].length();i++) {
            path.append(codes[index].charAt(i));
            helper(codes,index+1,result,path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
