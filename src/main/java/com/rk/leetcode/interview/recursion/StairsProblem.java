package com.rk.leetcode.interview.recursion;

public class StairsProblem {

    /**
     * program to find the distinct way to you can reach the nth stairs
     * confitions -> you can either cover 1 stair or 2 stair at a time
     * @param args
     */
    public static void main(String []args){
        System.out.println(countWays(10));
    }


    public static int countWays(int n){
        if(n==0){
            return 1;
        }
        if(n< 0){
            return 0;
        }
        return countWays(n-1) + countWays( n-2);
    }
}
