package com.leetcode.practice;

public class Prac01 {
    public static void main(String[] args) {
        System.out.println(" available CPU ::: " + Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
    }
}
