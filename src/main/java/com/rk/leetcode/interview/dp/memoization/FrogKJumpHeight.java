package com.rk.leetcode.interview.dp.memoization;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrogKJumpHeight {


    public static void main(String[] args) {
        int heights[]  = {30, 10, 60, 10, 60, 50};
        int k = 4;
        int n = heights.length - 1;
        log.info("Minimum Energy required : {}",minEnergyRequired(heights,n,k));
    }

    public static int minEnergyRequired(int []heights, int n, int k){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return Math.abs(heights[0] - heights[heights.length-1]);
        }
        int min = Integer.MAX_VALUE;
        for (int i=1; i <= k; i++){
            if(n - i >= 0){
                min =  Math.min(min, Math.abs(heights[n] - heights[n-i]) + minEnergyRequired(heights,n-i,k));
            }
        }
        return min;
    }

}
