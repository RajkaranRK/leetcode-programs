package com.rk.leetcode.interview.prefixsum;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;

@Slf4j
public class CanPrefixSum {

    public static void main(String[] args) {
        int arr[] = {9,4,0,20,3,10,5};
        int target = 9;

        log.info("prefix sum exists {} ",canPrefixSum(arr,target));

        log.info("prefix sum first {}",howPrefixSum(arr,target));


        log.info("prefix sum count {}",countPrefixSum(arr,target));


    }


    private static  boolean canPrefixSum(int arr[],int target){
        int prefixSum = 0;
        Set<Integer> dataSet = new HashSet<>();
        for(int i =0;i<arr.length; i++){
            prefixSum += arr[i];
            int key = prefixSum - target;
            if(dataSet.contains(key)){
                return true;
            }
            dataSet.add(prefixSum);
        }
        return false;
    }


    private static List<Integer> howPrefixSum(int arr[],int target){
        int prefixSum = 0;
        Map<Integer,Integer> dataMap = new HashMap<>();
        dataMap.put(0,-1);
        for(int i=0; i < arr.length; i++){
            prefixSum += arr[i];
            if(dataMap.containsKey(prefixSum - target)){
                log.info("key :{}",prefixSum-target);
                return Arrays.asList(dataMap.get(prefixSum-target)+1,i);
            }
            if(!dataMap.containsKey(prefixSum)){
                dataMap.put(prefixSum,i);
            }
        }
        return Arrays.asList(new Integer(-1),new Integer(-1));
    }


    private static int countPrefixSum(int []arr, int target){
        int prefixSum = 0;
        int count = 0;
        Map<Integer,Integer> prefixMap = new HashMap<>();
        for(int i =0;i<arr.length; i++){
            prefixSum += arr[i];
            int key = prefixSum - target;
            if(prefixSum == target){
                count++;
            }
            if(prefixMap.containsKey(key)){
                count += prefixMap.get(key);
            }
            //check whether this key is present in the map or not
            prefixMap.put(prefixSum,prefixMap.getOrDefault(prefixSum,0)+1);
        }
        return  count;
    }
}
