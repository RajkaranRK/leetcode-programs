package com.rk.leetcode.interview.dp.memoization;


import java.util.HashMap;
import java.util.Map;

public class StairPossibleWay {

    public static void main(String[] args) {
        int count = climbStair(1000,new HashMap<>());
        System.out.println(count);
    }


    private static int climbStair(int n, Map<Integer,Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n==0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        int count = climbStair(n-1,memo) + climbStair(n-2,memo);
        memo.put(n,count);
        return count;
    }
}
