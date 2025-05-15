package com.rk.leetcode.interview.leetcode_patterns.prefixsum;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HowSubArraySum {


    public static void main(String[] args) {
        int arr[] = {8,4,0,20,3,10,5};
        int target = 33;
        List<Integer> list = howPrefixSum(arr,target);
        log.info("how Prefix sum : {}",list);
    }

    private static List<Integer> howPrefixSum(int arr[],int target){
        Map<Integer,Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,-1);
        int prefixSum = 0;
        for (int i =0; i<arr.length; i++){
            prefixSum += arr[i];
            int key = prefixSum - target;
            if(prefixMap.containsKey(key)){
                return Arrays.asList(prefixMap.get(key)+1,i);
            }else{
                prefixMap.put(prefixSum,i);
            }
        }
        return Arrays.asList(-1,-1);
    }
}
