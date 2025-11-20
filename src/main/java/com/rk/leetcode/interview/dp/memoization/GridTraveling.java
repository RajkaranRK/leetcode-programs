package com.rk.leetcode.interview.dp.memoization;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class GridTraveling {

    public static void main(String[] args) {
        int [][]costs = {
                {1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}
        };
        int max = Integer.MIN_VALUE;
        for (int i =0; i < costs[0].length; i++){
            max = Math.max(max,maximumPath3Direction(costs,0,i));
        }
        log.info("Maximum costs for traveling in 3 direction : {}",max);
    }

    public static int maximumPath3Direction(int [][]costs, int i, int j){
        if(i >= costs.length || j >= costs[0].length || i < 0 || j < 0){
            return Integer.MIN_VALUE;
        }
        if(i == costs.length - 1){
            return costs[i][j];
        }
        int first = maximumPath3Direction(costs,i+1,j);
        int second = maximumPath3Direction(costs,i+1, j+1);
        int third = maximumPath3Direction(costs,i+1, j-1);
        return costs[i][j] + Math.max(Math.max(first,second),third);
    }
}
