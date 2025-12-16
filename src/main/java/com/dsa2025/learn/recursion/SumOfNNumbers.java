package com.dsa2025.learn.recursion;

public class SumOfNNumbers {

    public static void main(String[] args) {

        int sum = sumOfNNumbers(1, 10, 0);
        System.out.println(sum);
        System.out.println("_____________________________________________________");
        sumOfNNumbers1(10, 0);
        System.out.println("_____________________________________________________");
        int sum2 = sumOfNNumbers2(10);
        System.out.println(sum2);
        System.out.println("_____________________________________________________");
    }

    private static int sumOfNNumbers2(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sumOfNNumbers2(n - 1);
        // suppose  N is 3 than f(3) = 3 + f(2), f(2) = 2 + f(1) ......
    }

    private static void sumOfNNumbers1(int n, int sum) {

        if (n < 1) {
            System.out.println(sum);
            return;
        }

        sumOfNNumbers1(n - 1, sum + n);
    }

    private static int sumOfNNumbers(int i, int n, int sum) {

        if (i > n) {
            return sum;
        }

        sum += i++;

        sum = sumOfNNumbers(i, n, sum);

        return sum;
    }
}
