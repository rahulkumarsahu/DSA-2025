package com.dsa2025.learn.recursion;

public class BasicRecursionProblems {


    public static void main(String[] args) {
        printNameNTimes(1, 5);
        System.out.println("_____________________________________________________");
        printLinearly1ToN(1, 10);
        System.out.println("_____________________________________________________");
        printLinearlyNto1(1, 10);
        System.out.println("_____________________________________________________");
        printLinear1ToNBackTracking(1, 10);
    }

    private static void printNameNTimes(int i, int n) {
        // base condition
        if (i > n) return;

        System.out.println("Hello World !!");

        printNameNTimes(i + 1, n);
    }

    private static void printLinearly1ToN(int i, int n) {

        if (i > n) return;

        System.out.println(i);

        printLinearly1ToN(i + 1, n);
    }

    private static void printLinearlyNto1(int i, int n) {

        if (n < i) return;

        System.out.println(n);

        printLinearlyNto1(i, n - 1);
    }

    private static void printLinear1ToNBackTracking(int i, int n) {

        if (n < i) return;

        printLinear1ToNBackTracking(i, n - 1);

        System.out.println(n);
    }

}
