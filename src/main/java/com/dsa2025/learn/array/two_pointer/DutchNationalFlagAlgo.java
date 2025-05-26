package com.dsa2025.learn.array.two_pointer;

// https://workat.tech/problem-solving/practice/dutch-national-flag

import java.util.Arrays;

public class DutchNationalFlagAlgo {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 0, 0};
        sortTheArray(arr);
    }

    private static void sortTheArray(int[] arr) {

        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        // here we are considering like in between low and mid is sorted 0,1
        // and mid to high is unsorted, so when mid-cross high we will break.
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1){
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
