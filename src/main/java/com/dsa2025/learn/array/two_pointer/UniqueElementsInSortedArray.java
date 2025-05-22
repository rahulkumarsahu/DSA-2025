package com.dsa2025.learn.array.two_pointer;

// https://workat.tech/problem-solving/practice/unique-elements-sorted-array
public class UniqueElementsInSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int output = removeDuplicates(arr);
        System.out.println(output);
    }

    private static int removeDuplicates(int[] arr) {
        int count = arr.length;

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // if left and right is in same place than it will make count -- that is why never i and j
            // should be in same position...
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
