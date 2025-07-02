package com.leetcode.practice;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nextGreaterToRight(nums)));
        // Output: [5, 10, 10, -1, -1]
    }
    /**
     * Returns an array in which each position holds the nearest strictly
     * greater element to the *right* of the original element, or -1 if none.
     *
     * Example:  [4, 5, 2, 10, 8]  →  [5, 10, 10, -1, -1]
     */
    public static int[] nextGreaterToRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();           // will hold indices

        // Traverse from right → left
        for (int i = n - 1; i >= 0; i--) {

            // Pop all smaller or equal elements; they are not “greater”
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : arr[st.peek()];

            st.push(i);  // current index may be “greater” for elements to its left
        }
        return result;
    }
}
