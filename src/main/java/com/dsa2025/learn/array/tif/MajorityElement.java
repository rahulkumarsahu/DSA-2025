package com.dsa2025.learn.array.tif;

import java.util.Arrays;

//import java.util.Arrays;
// https://leetcode.com/problems/majority-element/description/
public class MajorityElement {


    public static void main(String[] args) {

        int[] arr = new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5};
        // N/2 -> only one majority
        int output = majorityElement(arr, arr.length);
        // N/3 -> only two majority element
        //int[] data = majorityElementTwo(arr);
        System.out.println(output);
        //System.out.println(Arrays.toString(data));

    }

    /**
     * Boyer-Moore Majority Voting Algorithm
     * The Boyer-Moore Majority Voting Algorithm is a simple way to find the element that appears more than half the time
     * in a list, if such an element exists. It works in two steps. First, it tries to find a "candidate" for the majority
     * by going through the list and keeping a count. If the current number is the same as the candidate, it increases the
     * count; if it’s different, it decreases the count. When the count becomes zero, it picks the current number as the
     * new candidate. After this first pass, the algorithm does a second pass to check if the candidate actually appears
     * more than half the time. This method is fast and uses very little memory, making it efficient.
     * Why this works:
           1. If a number is the majority (appears more than half the time), then every time it matches the candidate,
              the count goes up.
           2. When other numbers appear, they cancel out the count.
           3. But since the majority element appears more than all others combined, it survives this canceling process
              and remains the final candidate by the end of the first pass.
     * @param arr array
     * @param length Array length
     * @return int
     */
    private static int majorityElement(int[] arr, int length) {

        int candidate = arr[0];
        int votingCount = 1;

        for(int element: arr) {

            if (element == candidate) {
                votingCount++;
            } else {
                votingCount--;
            }

            if (votingCount == 0) {
                candidate = element;
                votingCount = 1;
            }
        }
        votingCount = 0;
        for (int element: arr) {
            if (element == candidate) {
                votingCount++;
            }
        }

        if (votingCount >= length/2) {
            return candidate;
        } else {
            return -1;
        }

    }
}
