package com.rk.leetcode.interview.leetcode_patterns.binarysearch;

import lombok.extern.slf4j.Slf4j;

/**
 * You are given an integer array position where each element represents the location of a stall on a number line.
 * You are also given an integer m, which represents the number of cows you need to place.
 *
 * You want to place all m cows in the stalls such that the minimum distance between any two cows is maximized.
 */
@Slf4j
public class AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9}; // sorted
        int k = 3; // cows

        log.info("Max distance :{}",aggressiveCows(stalls,k));
    }


    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        int low = 1; // minimum possible distance
        int high = stalls[n - 1] - stalls[0]; // maximum possible distance
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid;   // feasible → store it
                low = mid + 1;  // try for bigger distance
            } else {
                high = mid - 1; // not feasible → try smaller distance
            }
        }

        return result;
    }

    // ✅ Helper method to check if we can place k cows with at least `dist` apart
    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1; // first cow placed at stalls[0]
        int lastPos = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= dist) {
                count++;
                lastPos = stalls[i];
                if (count == k) return true;
            }
        }
        return false;
    }
}
