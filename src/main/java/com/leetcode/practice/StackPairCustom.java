package com.leetcode.practice;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

class Pair<U,V> {
    public final U first;
    public  final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
public class StackPairCustom {
    public static void main(String[] args) {
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        Stack<Map.Entry<Integer,Integer>> stack1 = new Stack<>();
        stack1.push(new AbstractMap.SimpleEntry<>(1,100));
        stack1.push(new AbstractMap.SimpleEntry<>(1,100));
        System.out.println(stack1.size());

        stack.push(new Pair<>(1,100));
        stack.push(new Pair<>(2,200));
        Pair<Integer,Integer> p = stack.peek();
        System.out.println(p);
    }
}
