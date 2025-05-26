package com.dsa2025.learn.array.two_pointer;

import java.util.Arrays;

public class KDiffPairs {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 3, 4, 4, 4, 5, 5, 5};
        int target = 2;
        int result = kDiffPairs(arr, target);
        System.out.println(result);
    }

    private static int kDiffPairs(int[] arr, int target) {
        int i = 0; int j = 1;
        int count = 0;

        Arrays.sort(arr);

        while (j < arr.length) {

            int diff = arr[j] - arr[i];

            if (diff == target) {
                i++; j++;
                count++;
                // To remove duplicate we will move j...
                while (j < arr.length && arr[j] == arr[j-1]) j++;
            } else if (diff < target) {
                // as array is sorted if diff is less than target than we have to increase the diff.
                // so we have to increase the j to max the diff because i point min and j point max
                j++;
            } else {
                i++;
                // if i and j matches we have to increase j than only we will be able to check further elements
                if (i == j) j++;
            }
        }
        return count;
    }
}
