package com.leetcode.window;

import org.apache.spark.sql.sources.In;

import java.util.HashMap;
import java.util.Map;

public class MaxDistinctWindowSum2 {
    public static void main(String[] args) {
        int[] nums = {9,9,9,1,2,3};//{2,5,1,8,9,10,10,10};
        int k = 3;
        System.out.println(maxSumSubArray(nums, k));
    }

    private static long maxSumSubArray(int[] nums, int k) {
      long best = 0;
      Map<Integer,Integer> map = new HashMap<>();
      long sum = 0;
      int duplicates = 0;
      for(int i = 0, j = 0; j < nums.length ; j++) {
          sum += nums[j];
          duplicates +=  add(map,nums[j]);
        if(j -i + 1 == k) {
            if(duplicates == 0) {
                best = Math.max(best,sum);
            }
            sum -= nums[i];
            duplicates += remove(map,nums[i++]);
        }
      }
      return best;
    }

   static int add(Map<Integer,Integer> map,int key) {
        int x = map.getOrDefault(key,0) + 1;
        map.put(key,x);
        if(x > 1) {
            return 1;
        }else {
            return 0;
        }
    }

   static int remove(Map<Integer,Integer> map,int key) {
        int c = map.get(key);
        if(c == 1) {
            map.remove(key);
        }else {
            map.put(key, c-1);
        }
        if(c > 1) {
            return -1;
        }else {
            return 0;
        }
    }
}
