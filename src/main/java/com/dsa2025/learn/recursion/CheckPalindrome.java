package com.dsa2025.learn.recursion;

public class CheckPalindrome {

    public static void main(String[] args) {
        
        String input = "madam";
        boolean status = checkPalindrome(input, 0, input.length() - 1);
        System.out.println(status);
    }

    private static boolean checkPalindrome(String input, int i, int j) {

        if (i > j) {
            return true;
        }

        if (input.charAt(i) != input.charAt(j)) {
            return false;
        }

        return checkPalindrome(input, i + 1, j - 1);
    }
}
