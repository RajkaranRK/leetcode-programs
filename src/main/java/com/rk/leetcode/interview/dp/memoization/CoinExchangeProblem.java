package com.rk.leetcode.interview.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CoinExchangeProblem {


    public static void main(String []args){
        CoinExchangeProblem coinExchangeProblem = new CoinExchangeProblem();
        int coins[] = new int[]{1,2,3};
        int sum = 4;
        int count = coinExchangeProblem.countPossibleWay(coins,sum);
        System.out.println("No of all possible ways "+count);


        count = coinExchangeProblem.countDistinctWay(coins,coins.length - 1, sum);
        System.out.println("Number of distinct way "+count);
        
        count = coinExchangeProblem.findMinimumCoinsUsed(coins, 7 ,new HashMap<>());
        System.out.println(count);
    }


    public int countPossibleWay(int coins[], int sum){
        if(sum == 0){
            return 1;
        }
        if(sum < 0){
            return  0;
        }
        int count = 0;
        for(int i=0;i<coins.length; i++){
            count = count + countPossibleWay(coins,sum - coins[i]);
        }
        return count;
    }


    public int countDistinctWay(int []coins, int index, int sum){
        if(sum == 0){
            return  1;
        }
        if(sum < 0){
            return 0;
        }
        if( index < 0){
            return 0;
        }
        int count = countDistinctWay(coins,index-1, sum)
                + countDistinctWay(coins,index, sum - coins[index]);
        return count;
    }
    
    
    public int findMinimumCoinsUsed(int coins[],int amount, Map<Integer,Integer> memo) {
        System.out.println(memo);
        if(memo.containsKey(amount)){
            return memo.get(amount);
        }
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i < coins.length; i++){
            int temp = findMinimumCoinsUsed(coins,amount - coins[i],memo);
            if(temp != Integer.MAX_VALUE && min > temp){
                min = temp+1;
            }
        }
        memo.put(amount,min);
        return min;
    }
}
