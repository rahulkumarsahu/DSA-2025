package com.dsa2025.learn.array.two_pointer;

import java.util.ArrayList;
import java.util.List;

// https://workat.tech/problem-solving/practice/k-subarray-sum
public class KSubArraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,6,2,4,7,8};
        int window = 3;
        List<Integer> result = kSubArraySum(arr, window);
        result.forEach(System.out::println);
    }

    private static List<Integer> kSubArraySum(int[] arr, int window) {
        int i = 0;
        int j = 0;
        List<Integer> output = new ArrayList<>();
        int sum = 0;

        while (j < arr.length) {

            sum += arr[j];

            if (j - i + 1 == window) {
                output.add(sum);
                sum -= arr[i];
                i++;
            }

            j++;
        }

        return output;
    }
}
