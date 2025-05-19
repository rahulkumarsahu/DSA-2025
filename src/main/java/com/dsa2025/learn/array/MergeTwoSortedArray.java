package com.dsa2025.learn.array;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 4};
        int[] arr2 = new int[]{2, 4, 5, 5};

        List<Integer> result = mergeSortedArrays(arr1, arr2);
        result.forEach(System.out::println);
    }

    private static List<Integer> mergeSortedArrays(int[] arr1, int[] arr2) {
        int one = 0;
        int two = 0;
        List<Integer> result = new ArrayList<>();

        while (one < arr1.length && two < arr2.length) {

            if (arr1[one] == arr2[two]) {
                result.add(arr1[one]);
                result.add(arr2[two]);
                one++;
                two++;
            } else if (arr1[one] < arr2[two]) {
                result.add(arr1[one]);
                one++;
            } else {
                result.add(arr2[two]);
                two++;
            }
        }

        while (one < arr1.length){
            result.add(arr1[one]);
            one++;
        }

        while (two < arr2.length) {
            result.add(arr2[two]);
            two++;
        }

        return result;
    }
}
