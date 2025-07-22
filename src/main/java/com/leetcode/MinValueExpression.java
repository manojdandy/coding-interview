package com.leetcode;

public class MinValueExpression {
    public static void main(String[] args) {
//        System.out.println(minimizeResult("112+422")); // Output: 108
//        System.out.println(minimizeResult("55+55"));   // Output: 110
//        System.out.println(minimizeResult("741+2"));   // Try this as well
        System.out.println(minimizeResult1("112+422"));
    }

    public static int minimizeResult1(String expression) {
        int min_Val = Integer.MAX_VALUE;
        String[] parts = expression.split("\\+");
        String left = parts[0];
        String right = parts[1];
        System.out.println("left ::" + left + " :: right ::" +right);
        for(int i = 0; i < left.length();i++ ) {
            for(int j = 1; j <= right.length();j++) {
                String prefix = left.substring(0,i);
                String a = left.substring(i);
                String b = right.substring(0,j);
                String suffix = right.substring(j);
                System.out.println("a :: " + a + " :: b ::" + b);
                System.out.println("prefix ::" + prefix + " :: suffix ::" + suffix);
                 int prefixVal = prefix.isEmpty() ? 1 : Integer.parseInt(prefix);
                 int suffixVal = suffix.isEmpty() ? 1 : Integer.parseInt(suffix);
                 int a_val = Integer.parseInt(a);
                 int b_val = Integer.parseInt(b);
                 int value = prefixVal * (a_val + b_val) * suffixVal;
                 min_Val = Math.min(min_Val,value);
                // prefix * (a+b) * suffix

            }
        }

        return min_Val;
    }









    public static int minimizeResult(String expression) {
        String[] parts = expression.split("\\+");
        String left = parts[0];
        String right = parts[1];
        int minValue = Integer.MAX_VALUE;

        // Try all positions to put '(' in left and ')' in right
        for (int i = 0; i < left.length(); i++) {
            for (int j = 1; j <= right.length(); j++) {
                String prefix = left.substring(0, i);
                String A = left.substring(i);
                String B = right.substring(0, j);
                String suffix = right.substring(j);

                int prefixVal = prefix.isEmpty() ? 1 : Integer.parseInt(prefix);
                int suffixVal = suffix.isEmpty() ? 1 : Integer.parseInt(suffix);
                int aVal = Integer.parseInt(A);
                int bVal = Integer.parseInt(B);

                int total = prefixVal * (aVal + bVal) * suffixVal;
                minValue = Math.min(minValue, total);
            }
        }
        return minValue;
    }


}
