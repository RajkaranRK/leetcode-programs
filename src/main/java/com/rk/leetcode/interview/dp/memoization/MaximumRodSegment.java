package com.rk.leetcode.interview.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class MaximumRodSegment {

    public static void main(String[] args) {
        int sum = 10000;
        int arr[] = new int[] {3,6,1};
        int maxCount = solve(arr,sum,new HashMap<>());
        System.out.println(maxCount == Integer.MIN_VALUE ? -1 : maxCount);
    }

    private static int solve(int arr[], int sum, Map<Integer,Integer> memo){
        if(memo.containsKey(sum)){
            return memo.get(sum);
        }
        if(sum == 0){
            return 0;
        }
        if(sum < 0){
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            int temp = solve(arr,sum - arr[i],memo);
            if(temp != Integer.MIN_VALUE){
                temp = temp + 1;
                if(temp > max){
                    max = temp;
                }
            }
        }
        memo.put(sum,max);
        return max;
    }
}
