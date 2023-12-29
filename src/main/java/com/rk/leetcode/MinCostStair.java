package com.rk.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinCostStair {

    public static void main(String[] args) {
        int cost[] = new int[] {1,100,1,1,1,100,1,1,100,1};
        int ans1 = minCost(cost,0,new HashMap<>());
        int ans2 = minCost(cost,1,new HashMap<>());
        int min = Math.min(ans1,ans2);
        System.out.println(min);
    }


    private static int minCost(int []cost, int n, Map<Integer,Integer> memo){
        if(memo.containsKey(n)){
            memo.get(n);
        }
        if(n == cost.length -1){
            return cost[n];
        }
        if(n >= cost.length){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int cost1 = minCost(cost, n+1,memo);
        int cost2 = minCost(cost, n+2,memo);
        cost1 = Math.min(cost1, cost2);
        if(cost1 != Integer.MAX_VALUE){
            min = Math.min(cost1 + cost[n], min);
        }
        memo.put(n, min);
        return min;
    }
}
