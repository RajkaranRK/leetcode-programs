package com.rk.leetcode.interview.leetcode_patterns.slidingwindow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinimumSum {

    public static void main(String[] args) {
        int arr[] = {9,4,0,20,3,10,5};
        int k = 3;
        int min = minimumSlidingSum(arr,k);
        log.info("minimum : {}",min);
    }

    private static  int minimumSlidingSum(int []arr, int k){
        if(arr.length < k){
            return -1;
        }
        int sum = 0;
        for (int i=0; i<k;i++){
            sum += arr[i];
        }
        int min = sum;
        int i = 1;
        int j = k;
        while(j<arr.length){
            sum = sum + arr[j] - arr[i-1];
            min = Math.min(sum,min);
            j++;
            i++;
        }
        return min;
    }
}
