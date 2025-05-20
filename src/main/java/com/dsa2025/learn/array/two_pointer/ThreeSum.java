package com.dsa2025.learn.array.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 0, -1, -2};

        List<List<Integer>> result = threeSum(arr);

        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        // here what we have to do is i will be at 0 and j will be at 1 and k will be at len - 1
        // then if sum of i,j,k is > 0 than we have to reduce the value move the k
        // if it is < 0 then we have to increase j
        // once we got one output than we have to avoid duplicate for all the i,j,k except first time i duplicate will be ignore...

        // i will move 0 to len
        for(int i = 0; i < arr.length; i++) {
            List<Integer> out = new ArrayList<>();
            int j = i + 1;
            int k = arr.length - 1;
            // avoid duplicate i
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    out.add(arr[i]);
                    out.add(arr[j]);
                    out.add(arr[k]);
                    result.add(out);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }

                    while (j < k && arr[k] == arr[k - 1]) {
                        k--;
                    }
                }
            }

        }

        return result;
    }
}
