package com.rk.leetcode.interview.dp.memoization;

public class CoinExchangeProblem {


    public static void main(String []args){
        CoinExchangeProblem coinExchangeProblem = new CoinExchangeProblem();
        int coins[] = new int[]{1,2,3};
        int sum = 4;
        int count = coinExchangeProblem.countPossibleWay(coins,sum);
        System.out.println("No of all possible ways "+count);


        count = coinExchangeProblem.countDistinctWay(coins,coins.length - 1, sum);
        System.out.println("Number of distinct way "+count);
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
}
