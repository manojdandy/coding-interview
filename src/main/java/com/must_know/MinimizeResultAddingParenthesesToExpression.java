package com.must_know;

public class MinimizeResultAddingParenthesesToExpression {
    public static void main(String[] args) {
        System.out.println(minimizeResult("247+38")); // "2(47+38)"
        System.out.println(minimizeResult("12+34"));//"1(2+3)4"
        System.out.println(minimizeResult("999+999"));//"(999+999)"
    }

    public static String minimizeResult(String expression) {
        int min_val = Integer.MAX_VALUE;
        String left = expression.split("\\+")[0];
        String right = expression.split("\\+")[1];
        String min_val_expression = "";

        for (int i = 0; i < left.length(); i++) {
            for (int j = 1; j <= right.length(); j++) {
                String prefix = left.substring(0,i);
                String num1 = left.substring(i);
                String suffix = right.substring(j);
                String num2 = right.substring(0,j);

               // System.out.println(String.format("%s(%s+%s)%s",prefix,num1,num2,suffix));

                int prefix_val = prefix.isEmpty() ? 1 : Integer.parseInt(prefix);
                int suffix_val = suffix.isEmpty() ? 1 : Integer.parseInt(suffix);
                int num1_val = Integer.parseInt(num1);
                int num2_val = Integer.parseInt(num2);

                int total_val = prefix_val * (num1_val + num2_val) * suffix_val;
                if(total_val < min_val) {
                    min_val = total_val;
                    min_val_expression = String.format("%s(%s+%s)%s",prefix,num1,num2,suffix);
                }
            }
        }

        return min_val_expression;
    }
}
