package com.dsa2025.learn.array.two_pointer;

import java.util.Stack;

// https://www.geeksforgeeks.org/the-celebrity-problem/
public class TheCelebrityProblem {

    public static void main(String[] args) {
        int[][] mat = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        System.out.println(celebrityTwoPointer(mat));
        System.out.println(celebrityStack(mat));
        System.out.println(celebrity(mat));

        // here the main thing is to find a possible candidate who can be a celebrity...
    }

    private static boolean celebrityTwoPointer(int[][] mat) {
        return Boolean.FALSE;
    }

    private static boolean celebrityStack(int[][] mat) {

        Stack<Integer> stack = new Stack<>();
        int length = mat.length;

        for (int i = 0; i < mat.length; i++) {
            stack.push(i);
        }

        // so here according to example we have candidate 0,1,2 so pushing and checking who
        // can be possible candidate...

        while (stack.size() > 1) {
            
            int a = stack.pop();
            int b = stack.pop();
            
            if (knows(mat, a, b)) {
                // if a knows b than b can be possible candidate
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        if (stack.empty()) {
            return Boolean.FALSE;
        }

        int candidate = stack.pop();

        for(int i = 0; i < length; i++) {
            // if a candidate knows i or i doesn't know a candidate, we have to return false.
            if (i != candidate && (knows(mat, candidate, i) || !knows(mat, i, candidate))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;

    }

    private static boolean knows(int[][] mat, int a, int b) {

        return mat[a][b] == 1;
    }

    private static boolean celebrity(int[][] mat) {
        int candidate = 0;

        for (int i = 1; i < mat.length; i++) {
            // here same as stack, we are checking a possible candidate
            if (knows(mat, candidate, i)) {
                // we are assuming a possible candidate as 0 and if candidate knows i then we are updating
                // the possible candidate....
                candidate = i;
            }
        }

        for (int i = 0; i < mat.length; ++i) {
            if (candidate != i) {
                if (knows(mat, candidate, i) || !knows(mat, i, candidate)) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;

    }

}
