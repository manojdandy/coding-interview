package com.concepts.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        //hello(4);
        //System.out.println(sumOfDigits(123));
        printStar(1, 5);
        System.out.println("***********");
        printStarInverted( 5);
    }

    public static void hello(int n) {
        if (n == 0) {
            return;
        }

        hello(n - 1);
        System.out.println("hello ::" + n);
    }

    static int sumOfDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int lastDigit = num % 10;
        int remainingDigit = num / 10;
        System.out.println("remianing ::" + remainingDigit + " :: last ::" + lastDigit);
        return sumOfDigits(remainingDigit) + lastDigit;
    }

    static void printStar(int start, int end) {
        if (start == end) {
            return;
        }

        for (int i = 1; i <= start; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        printStar(start + 1, end);

    }

    static void printStarInverted(int end) {
        if (end == 0) {
            return;
        }
        //System.out.println("start ::" + start + " :: end ::" + end);
        for (int i = 1; i <= end; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        printStarInverted(end - 1);

    }
}
