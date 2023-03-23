package com.rk.leetcode.interview.dp.memoization;

public class MaximumSumOfNonAdjacent {
    
    
    public static void main(String []args) {
        int arr[] = new int[] {9,9,8,9};
        int sum = maximumSum(arr,arr.length-1,1);
        int sum2 = maximumSum(arr, arr.length-2,0);
        sum = Math.max(sum, sum2);
        System.out.println(sum);
    }
    
    
    private static int maximumSum(int arr[], int index,int end) {
        if(index == end) {
            return arr[end];
        }
        if(index < end) {
            return 0;
        }
        int v1 = maximumSum(arr,index-1,end) ;
        int v2 = maximumSum(arr,index-2,end)+ arr[index];
        return Math.max(v1, v2);
    }

}
