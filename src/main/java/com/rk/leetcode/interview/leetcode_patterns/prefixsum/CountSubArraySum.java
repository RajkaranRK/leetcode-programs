package com.rk.leetcode.interview.leetcode_patterns.prefixsum;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class CountSubArraySum {


    public static void main(String[] args) {
        int arr[] = {9,4,0,20,3,10,5};
        int target = 20;
        int count = countSubArraySum(arr,target);
        log.info("count subarray sum : {}",count);
    }

    private static int countSubArraySum(int arr[], int target){
        Map<Integer,Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0,1);
        int count = 0;
        int prefixSum = 0;
        for (int i =0; i<arr.length; i++){
            prefixSum += arr[i];
            int key = prefixSum - target;
            if(prefixCountMap.containsKey(key)){
                count += prefixCountMap.get(key);
            }else{
                prefixCountMap.put(prefixSum, prefixCountMap.getOrDefault(prefixSum,0)+1);
            }
        }
        return count;
    }
}
