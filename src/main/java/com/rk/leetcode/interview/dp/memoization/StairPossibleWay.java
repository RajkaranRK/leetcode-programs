package com.rk.leetcode.interview.dp.memoization;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class StairPossibleWay {

    public static void main(String[] args) {
        int n = 1000;
        log.info("Climb stairs : {}",climbStairs(n,new HashMap<>()));
        log.info("Climb Stairs : {}",climbStairs(n));
    }

    public static int climbStairs(int n, Map<Integer,Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if( n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int result =  climbStairs(n-1,memo) + climbStairs(n-2,memo);
        memo.put(n,result);
        return result;
    }

    public static int climbStairs(int n){
        int memo[] = new int[n+1];
        Arrays.fill(memo,-1);
        memo[0] = 1;
        memo[1] = 1;
        for (int i=2; i<=n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}
