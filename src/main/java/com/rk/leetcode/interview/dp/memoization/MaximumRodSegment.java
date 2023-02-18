package com.rk.leetcode.interview.dp.memoization;

public class MaximumRodSegment {

    public static void main(String[] args) {
        int sum = 7;
        int arr[] = new int[] {3,6,3};
        int maxCount = solve(arr,sum);
        System.out.println(maxCount == Integer.MIN_VALUE ? -1 : maxCount);
    }

    private static int solve(int arr[],int sum){
        if(sum == 0){
            return 0;
        }
        if(sum < 0){
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){
            int temp = solve(arr,sum - arr[i]);
            if(temp != Integer.MIN_VALUE){
                temp = temp + 1;
                if(temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }
}
