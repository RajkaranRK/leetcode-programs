package com.rk.leetcode.interview.leetcode_patterns.prefixsum;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class CanSubArraySum {

    public static void main(String[] args) {
        int arr[] = {9,4,0,20,3,10,5};
        int target = 9;
        log.info("Can Prefix sum exists {}",canPrefixSum(arr,target));
    }


    private static boolean canPrefixSum(int arr[],int target){
        Set<Integer> prefixSumSet = new HashSet<>();
        int prefixSum = 0;
        prefixSumSet.add(0);
        for (int i =0; i<arr.length; i++){
            prefixSum += arr[i];
            if(prefixSumSet.contains(prefixSum  - target)){
                return true;
            }
            prefixSumSet.add(prefixSum);
        }
        return false;
    }
}
