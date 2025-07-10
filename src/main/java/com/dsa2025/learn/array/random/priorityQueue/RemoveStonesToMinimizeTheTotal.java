package com.dsa2025.learn.array.random.priorityQueue;

//https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/?envType=problem-list-v2&envId=array

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public static void main(String[] args) {
        int[] piles = new int[]{5,4,9};
        int k = 2;
        int result = minStoneSum(piles, k);
        System.out.println(result);
    }

    /**
     * So basically let's take an example [4,3,6,7] k = 3
     * So 7 is bigger, so we will perform our first operation [4,3,6,3.5 -> 4]
     * again we perform the second operation [4,3,3,4]
     * again we perform the third operation [2,3,3,4]
     * @param piles represents the number of stones in the ith pile
     * @param k an integer k. Choose any piles[i] and remove ceil(piles[i] / 2) stones from it.
     *          That you can apply the operation on the same pile more than once.
     * @return Return the minimum possible total number of stones remaining after applying the k operations.
     */
    private static int minStoneSum(int[] piles, int k) {
        // Use max heap to always get the pile with most stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Calculate a total sum while building heap
        int totalSum = 0;
        for (int pile : piles) {
            maxHeap.offer(pile);
            totalSum += pile;
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            Integer maxPile = maxHeap.poll();
            if (maxPile != null) {
                int removedStones = maxPile / 2;  // This is floor(maxPile / 2)
                int remainingStones = maxPile - removedStones;  // This gives us ceil(maxPile / 2)

                // Update a total sum by subtracting removed stones
                totalSum -= removedStones;

                // Add the remaining stones back to heap
                maxHeap.offer(remainingStones);
            } else {
                break;
            }
        }
        return totalSum;
    }
}
