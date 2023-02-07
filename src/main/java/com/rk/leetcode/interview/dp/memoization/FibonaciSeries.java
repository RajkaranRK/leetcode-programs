package com.rk.leetcode.interview.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class FibonaciSeries {


    public static void main(String []args){
        System.out.println(fib(7,new HashMap<>()));
        System.out.println(fib(10,new HashMap<>()));
        System.out.println(fib(50,new HashMap<>()));
    }

    private static long fib(int n, Map<Integer,Long> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        if(n<=2){
            memo.put(n,1L);
            return 1;
        }
            long cal = fib(n-1,memo) + fib(n-2,memo);
            memo.put(n, cal);
            return cal;
        }//12586269025
}
