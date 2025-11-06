package com.rk.leetcode.interview.dp.memoization;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * You’re given an array height[] of size n, where height[i] represents the height of the i-th stone.
 * A frog starts on stone 0 and wants to reach stone n-1.
 *
 * From stone i, it can:
 * 	•	jump to stone i + 1, or
 * 	•	jump to stone i + 2
 *
 * The energy cost of a jump from stone i to stone j is:
 *
 * |height[j] - height[i]|
 *
 * Find the minimum total energy required to reach the last stone.
 */
@Slf4j
public class FrogJumpHeight {

    public static void main(String[] args) {
        int []heights = {30, 10, 60, 10, 60, 50};
        int n = heights.length - 1;
        log.info("Minimum energy required :{} ",frogJumpMinEnergy(heights,n,new HashMap<>()));
    }

    public static int frogJumpMinEnergy(int []heights, int n, Map<Integer,Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return Math.abs(heights[1] - heights[0]);
        }
        int oneStep = frogJumpMinEnergy(heights, n-1,memo) + Math.abs(heights[n] - heights[n-1]);
        int twoStep = frogJumpMinEnergy(heights,n-2,memo) + Math.abs(heights[n] - heights[n-2]);
        int min =  Math.min(oneStep,twoStep);
        memo.put(n,min);
        return min;
    }
}
