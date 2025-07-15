package com.interviews;

import java.util.ArrayList;
import java.util.List;

public class ScooterCodeGenerator {
    public static void main(String[] args) {
        //paris_code = ['*#%$', '2345678']
        List<String> result = new ArrayList<>();
        String[] pairs_code = new String[]{"*#%$","2345678"};
        backtrack(pairs_code,2,0,result,new StringBuilder());
        System.out.println(result);
        String[] uk_code = new String[] {"abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz", "-/", "012"};
        System.out.println("********uk code");
        result.clear();
        backtrack(uk_code,10,0,result,new StringBuilder());
        System.out.println(result); //'aa-0', 'aa-1', 'aa-2','aa/0','aa/1','aa/2','ab-0','ab-1','ab-2' and so on.
    }
    public static void backtrack(String[] pairsCode,int count,int index,List<String> result,StringBuilder path) {
        if(pairsCode.length == index ) {
            result.add(path.toString());
            return;
        }
        for(char ch:pairsCode[index].toCharArray()) {
            path.append(ch);
            //backtrack
            backtrack(pairsCode,count,index+1,result,path);
            path.deleteCharAt(path.length()-1);
            if(result.size() >= count) {
                return;
            }
        }
    }
}
