package com.rk.leetcode.interview.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class AdjacentNumberSum {

    public static void main(String[] args) {
        int []arr = new int[]{9,8,1,2};
        int n = arr.length - 1;
        int max = solve(arr,n,new HashMap<>());
        System.out.println(max);
    }


    private static int solve(int []arr, int index, Map<Integer,Integer> memo){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index == 0){
            return arr[index];
        }
        if(index < 0){
            return Integer.MIN_VALUE;
        }

        int include = solve(arr,index-2,memo);
        if(include != Integer.MIN_VALUE) {
            include+= arr[index];
        }
        int exclude = solve(arr,index - 1,memo);
        int max = Math.max(include,exclude);
        memo.put(index,max);
        return max;
    }
}
