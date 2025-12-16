package com.dsa2025.learn.recursion;

import com.dsa2025.learn.LearnApplication;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseAnArray(arr, 0,arr.length - 1);
        LearnApplication.print(arr);
    }

    private static void reverseAnArray(int[] arr, int i, int j) {

        if (i > j) {
            return;
        }

        LearnApplication.swap(arr, i, j);

        reverseAnArray(arr, i + 1, j - 1);

    }
}
