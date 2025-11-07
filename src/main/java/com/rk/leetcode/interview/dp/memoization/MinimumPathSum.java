package com.rk.leetcode.interview.dp.memoization;

import lombok.extern.slf4j.Slf4j;

/**
 * A ninja is training in a rectangular land represented by a grid of size n × m.
 * Each cell in the grid contains a number that represents the energy cost to step on that cell.
 *
 * The ninja starts from the top-left cell (0, 0) and wants to reach the bottom-right cell (n-1, m-1).
 * From any cell, the ninja can only move:
 * 	•	Down (to cell (i+1, j)), or
 * 	•	Right (to cell (i, j+1)).
 *
 * Your task is to find the minimum total energy the ninja requires to reach the destination.
 */

@Slf4j
public class MinimumPathSum {

    public static void main(String[] args) {
        int [][]energy = {
                {5, 9, 6, 3},
                {4, 7, 2, 8},
                {1, 6, 10, 4}
        };
        int m = energy.length-1;
        int n = energy[0].length-1;
        log.info("minimum energy required to reach to last : {}",minimumPathSum(energy,m,n));
    }

    public static int minimumPathSum(int [][]energy, int m, int n ){
        if(m == 0 && n == 0){
            return energy[0][0];
        }
        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }
        return Math.min(minimumPathSum(energy,m-1,n), minimumPathSum(energy,m,n-1))
                + energy[m][n];
    }
}
