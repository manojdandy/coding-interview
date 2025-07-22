package com.prac01.algo;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(maximumSwap(2736,1)); //7236
        //System.out.println(maximumSwap(9973));
    }

    public static int maximumSwap(int num,int k) {
        int max_num_position = 0;
        String num_str = String.valueOf(num);
        int max_element = Character.getNumericValue(num_str.charAt(0));
        System.out.println(max_element);

        for (int i = 1; i < num_str.length(); i++) {
            if (Character.getNumericValue(num_str.charAt(i)) > max_element) {
                max_element = Character.getNumericValue(num_str.charAt(i));
                max_num_position = i;
            }
        }
        System.out.println("max_num_position :: " + max_num_position);
        return num;
    }


    

    public void swap(char[] chrs, int i, int j) {
        char temp = chrs[i];
        chrs[i] = chrs[j];
        chrs[j] = temp;

    }


    public static int maximumSwap2(int num) {
        int max_num_position = 0;
        String num_str = String.valueOf(num);
        int max_element = Character.getNumericValue(num_str.charAt(0));
        System.out.println(max_element);

        for (int i = 1; i < num_str.length(); i++) {
            if (Character.getNumericValue(num_str.charAt(i)) > max_element) {
                max_element = Character.getNumericValue(num_str.charAt(i));
                max_num_position = i;
            }
        }
        System.out.println("max_num_position :: " + max_num_position);
        return num;
    }
}
