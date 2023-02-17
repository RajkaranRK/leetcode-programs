package com.rk.leetcode.interview.dp.memoization;

import java.util.HashMap;
import java.util.Map;


/***
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 */
public class MinimumCostStairProblem {


    public static void main(String[] args) {
        int cost[] = new int[]{1,100,1,1,100,1,1,100,1};
        int n = cost.length;
        Map<Integer,Integer> memo = new HashMap<>();
        int min = Math.min(solve(cost,n-1,new HashMap<>()),solve(cost,n-2,new HashMap<>()));
        System.out.println("minimum cost "+min);
    }


    private static int solve(int cost[],int n,Map<Integer,Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n==0){
            return cost[0];
        }if(n == 1){
            return cost[1];
        }
        int minCost = cost[n] + Math.min(solve(cost,n-1,memo) ,solve(cost,n-2,memo));
        memo.put(n,minCost);
        return minCost;
    }
}
