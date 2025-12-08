package com.dsa2025.learn.advent.day3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Day3_Part2 {

    // Returns the largest possible 12-digit number as a string
    // formed by deleting digits but keeping order.
    private static String maxTwelveDigits(String s) {
        int k = 12;                       // required length
        int n = s.length();
        int toRemove = n - k;             // how many digits must be removed

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // While:
            // 1) there are digits on the stack
            // 2) top of stack is smaller than current digit
            // 3) we are still allowed to remove digits
            // pop smaller digits to make the number larger.
            while (!stack.isEmpty()
                    && toRemove > 0
                    && stack.peekLast() < c) {
                stack.pollLast();
                toRemove--;
            }

            stack.addLast(c);             // keep current digit
        }

        // If we still have to remove digits, remove them from the end.
        while (toRemove > 0) {
            stack.pollLast();
            toRemove--;
        }

        // Now the stack may be longer than 12 if input length <-> logic.
        // Trim from the end until we have exactly 12 digits.
        while (stack.size() > k) {
            stack.pollLast();
        }

        // Build result string from stack.
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example input from the screenshot
        String[] banks = {
                "98765432111111",
                "81111111111119",
                "2342342343243278",
                "818181911121111"
        };

        long total = 0L;
        for (String bank : banks) {
            String best = maxTwelveDigits(bank);
            long value = Long.parseLong(best);
            System.out.println("Best for " + bank + " -> " + best + " -> " + value);
            total += value;
        }

        System.out.println("Total output joltage = " + total);
    }
}
