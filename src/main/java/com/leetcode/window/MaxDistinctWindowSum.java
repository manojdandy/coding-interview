package com.leetcode.window;

import java.util.HashMap;
import java.util.Map;

public class MaxDistinctWindowSum {

    /**
     * Returns the maximum sum of any length-size sub-array whose elements are all distinct.
     * If no such window exists, returns 0.
     *
     * Time  : O(n)          – every element enters + leaves the window once
     * Space : O(min(size, n)) for the frequency map
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        if (k <= 0 || k > nums.length) return 0;

        Map<Integer, Integer> freq = new HashMap<>(k * 2); // value -> count
        int duplicates = 0;   // how many distinct values currently have count ≥ 2?
        long sum = 0;
        long best = 0;

        /* -------- initialise the first window -------- */
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            duplicates += add(freq, nums[i]); // add() returns +1 if this made a dup
        }
        if (duplicates == 0) best = sum;

        /* -------- slide the window through the array -------- */
        for (int left = 0, right = k; right < nums.length; left++, right++) {

            /* remove element exiting on the left */
            sum -= nums[left];
            duplicates += remove(freq, nums[left]); // -1 if duplicate resolved

            /* add element entering on the right */
            sum += nums[right];
            duplicates += add(freq, nums[right]);   // +1 if it became duplicate

            /* check if current window is all-distinct */
            if (duplicates == 0) best = Math.max(best, sum);
        }
        return best;
    }

    /* ---------- helper methods to keep duplicate count accurate ---------- */

    /** @return +1 if adding x makes its count exactly 2 (a new duplicate), else 0 */
    private static int add(Map<Integer,Integer> freq, int x) {
        int c = freq.getOrDefault(x, 0);
        freq.put(x, c + 1);
        return (c + 1 == 2) ? 1 : 0;
    }

    /** @return -1 if removing x drops its count from 2 → 1 (duplicate resolved), else 0 */
    private static int remove(Map<Integer,Integer> freq, int x) {
        int c = freq.get(x);
        if (c == 1) freq.remove(x);
        else freq.put(x, c - 1);
        return (c == 2) ? -1 : 0;
    }

    /* ---------------- demo ---------------- */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 5, 3};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));   // 12  (window [3,2,4,5] not valid; best is [2,4,5] -> 11)
    }
}

