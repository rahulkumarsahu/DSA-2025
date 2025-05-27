package com.dsa2025.learn.array.two_pointer;

// https://workat.tech/problem-solving/practice/dutch-national-flag

import java.util.Arrays;
//https://excalidraw.com/#json=8VBsZM5FUOyaGELqvsj1k,4v62HkSj_oqye_w3wPl6LA
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
        // dutch algo says like mid points encounter 0,1,2 and
        // 0 ------> low - 1 -> 0
        // low ------> mid - 1 -> 1
        // mid ------> high -> unsorted 0,1,2
        // high + 1 -----> n - 1 -> 2
        // before low everything should be 0 and from low to mid everything should be 1
        // similarly for 2 ...
        // so here what we will do when mid = 0 so we will swap and mid and low increment...
        // why because mid should point to 1 and low - 1 should be 0 that is why
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1){
                // mid should point to 1 according to algo.....
                mid++;
            } else {
                //
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
