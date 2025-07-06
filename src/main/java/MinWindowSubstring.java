import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    /**
     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
     *
     * Example 1:
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     *
     * Constraints:
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     *
     */

// Core logic to find the minimum window substring
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        String bestLenth = "";
        int best = Integer.MAX_VALUE;
       // int minLen
        int start = 0;
        int count = 0; // unique number of characters
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        count = map.size();
        for(int i= 0, j = 0; j < s.length();j++) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                int x = map.get(ch);
                if(x-1 == 0) {
                    count--;
                }
                map.put(ch,x-1);
            }
            //optimize solution
            while (count == 0) {
                // got a solution
                if(best > j - i + 1) {
                    best = j - i +1;
                    start = i;
                }
                char lch = s.charAt(i++);
                if(map.containsKey(lch)) {
                    int x1 = map.get(lch);
                    if(x1+1 > 0) {
                        count++;
                    }
                    map.put(lch,map.get(lch) + 1);

                }

            }

        }
        System.out.println("start :: " + start + " :: best :: " + best);
        return s.substring(start,start+best);
    }

    // Run method to expose functionality
    public void run(String s, String t) {

        String result = minWindow(s, t);
        System.out.println("Minimum window substring: \"" + result + "\"");
    }

    // Main method with sample tests
    public static void main(String[] args) {
        MinWindowSubstring solver = new MinWindowSubstring();

        // Test cases
        solver.run("ADOBECODEBANC", "ABC"); // Output: "BANC"
        solver.run("a", "a");               // Output: "a"
        solver.run("a", "aa");              // Output: ""
        /**
         * s = "aaflslflsldkabcaaa"
         * t = "aaa"
         * Expected: "caaa"
         */
        solver.run("aaflslflsldkabcaaa", "aaa");//aaa
        /**
         * s = "xxaxxbxxcxxbxxa"
         * t = "abc"
         * Expected: "axxbxxc"  // small window with all three
         */
        solver.run("xxaxxbxxcxxbxxa", "abc");//axxbxxc
    }
}
