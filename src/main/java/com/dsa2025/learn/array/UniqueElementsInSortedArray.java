package com.dsa2025.learn.array;

// https://workat.tech/problem-solving/practice/unique-elements-sorted-array
public class UniqueElementsInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int output = removeDuplicates(arr);
        System.out.println(output);
    }

    private static int removeDuplicates(int[] arr) {
        int count = arr.length;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            while(left != right && arr[left] == arr[left + 1]) {
                left++;
                count--;
            }

            while(left != right && arr[right] == arr[right - 1]) {
                right--;
                count--;
            }

            left++;
            right--;
        }
        return count;
    }
}
