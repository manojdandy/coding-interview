package com.prac01.algo;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));//true
        System.out.println(isPalindrome("race a car"));//false
        System.out.println(isPalindrome(" "));//true
    }

    public static boolean isPalindrome(String s) {
        String cleanedInput = s.replaceAll("[^a-zA-Z0-9]","");
        int left = 0 ;
        int right = cleanedInput.length()-1;
        System.out.println("cleaned input ::" + cleanedInput);
        while(left < right) {
            if(Character.toLowerCase(cleanedInput.charAt(left)) != Character.toLowerCase(cleanedInput.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
