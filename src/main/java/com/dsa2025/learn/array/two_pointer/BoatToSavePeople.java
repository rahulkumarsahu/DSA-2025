package com.dsa2025.learn.array.two_pointer;

import java.util.Arrays;

//https://leetcode.com/problems/boats-to-save-people/?envType=problem-list-v2&envId=two-pointers
public class BoatToSavePeople {

    public static void main(String[] args) {
        int limit = 3;
        int[] people = new int[]{};
        int result = numRescueBoats(people, limit);
        System.out.println(result);
    }

    private static int numRescueBoats(int[] people, int limit) {
        int result = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while(left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            result++;
            right--;
        }
        return result;
    }
}
