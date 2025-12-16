package com.dsa2025.learn.recursion;

public class Fibonacci {
    // the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
    //                        0  1  1  2  3  5  8  13  21  34 55 89
    public static void main(String[] args) {
        System.out.print(0 + " " + 1 + " ");
        fibonacci(0, 1, 10);
        System.out.println("_____________________________________________________");
        int sum = fibonacci1(10);
        System.out.println(sum);
        System.out.println("_____________________________________________________");
        int sum1 = fibonacci2(10);
        System.out.println(sum1);
    }

    private static int fibonacci2(int n) {

        if (n <= 1) {
            return n;
        }
       int first = fibonacci2(n - 1);
       int last = fibonacci2(n - 2);

        return first + last;
    }

    private static int fibonacci1(int n) {

        if (n <= 1) {
            return n;
        }
        // to get fibonacci we should know 9 and 8 and for 9 -> 8 7 -> and so on.....
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

    private static void fibonacci(int i, int j, int n) {

        if (n < 1) {
            return;
        }

        int next = i + j;
        System.out.print(next + " ");

        fibonacci(j, next, n - 1);
    }
}
