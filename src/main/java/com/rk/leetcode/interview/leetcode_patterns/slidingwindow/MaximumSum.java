package com.rk.leetcode.interview.leetcode_patterns.slidingwindow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaximumSum {


    public static void main(String[] args) {
        int arr[] = {9,4,0,20,3,10,5};
        int k = 3;
        int max = maximumSlidingSum(arr,k);
        log.info("maximum : {}",max);
    }


    private static int maximumSlidingSum(int []arr,int k){
        int max = 0;
        for (int i=0; i<k; i++){
            max += arr[i];
        }
        int j = k;
        int i = 1;
        int sum = max;
        while(j<arr.length){
            sum = sum + arr[j] - arr[i-1];
            i++;
            j++;
            max = Math.max(sum,max);
        }
        return max;
    }
}
