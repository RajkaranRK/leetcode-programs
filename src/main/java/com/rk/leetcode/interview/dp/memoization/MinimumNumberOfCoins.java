package com.rk.leetcode.interview.dp.memoization;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * You have given array of coins and sum
 * you've to find out the minimum possible numbers of coins can be used to make the existing sum
 */
public class MinimumNumberOfCoins {


    public static void main(String[] args) {

        int coins[] = new int[]{3,6,1};
        int sum = 7;
        int min = minimumCoins(coins,sum,new HashMap<>());
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }


    private static int minimumCoins(int []coins, int sum, Map<Integer,Integer> memo){
        if(memo.containsKey(sum)){
            return memo.get(sum);
        }
        if(sum == 0){
            return 0;
        }
        if(sum < 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for(int i =0; i<coins.length; i++){
            int tempMin = minimumCoins(coins,sum - coins[i],memo);
            if(min > tempMin && tempMin != -1){
                min = tempMin;
                min += 1;
            }
        }
        memo.put(sum,min);
        return min;
    }
}
