package com.dsa2025.learn.array.two_pointer;

// https://www.geeksforgeeks.org/count-pairs-with-given-sum-in-sorted-array/#expected-approach-using-two-pointer-technique-onlogn-and-on-space

import java.util.Arrays;

public class CountPairWithSumK {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 7, -1, 5};
        int target = 6;
        int countPair = countPairs(arr, target);
        System.out.println(countPair);
    }

    private static int countPairs(int[] arr, int target) {

        // sorting the array...
        Arrays.sort(arr);

        // two pointer approach...
        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while(left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                // if sum is equal...
                if (arr[left] == arr[right]) {
                    // we will check if arr[left] == arr[right] array is sorted if it is same than every element is same
                    int n = right - left;
                    count += (n * (n + 1)) / 2;
                    break;
                } else {
                    // now we will handle duplicate condition
                    // like we can have duplicate pair 1,5 2 times for that we need to check
                    // if target == sum than any duplicate is their or not for that taken a counter
                    int i = 1; int j = 1;
                    while (left < right && arr[left] == arr[left+1]) {
                        i++; // increasing the counter for duplicate
                        left++; // increasing the counter for checking more duplicate
                    }
                    while (left < right && arr[right] == arr[right-1]) {
                        j++;
                        right--;
                    }
                    count += (i * j);
                    left++;
                    right--;
                }

            } else if (sum < target) {
                // if sum is lesser than we have to increase left pointer
                left++;
            } else {
                // if sum is greater than we have to increase right pointer
                right--;
            }
        }
        return count;
    }
}
