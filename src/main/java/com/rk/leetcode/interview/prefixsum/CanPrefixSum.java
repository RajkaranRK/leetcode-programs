package com.rk.leetcode.interview.prefixsum;


import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;

@Slf4j
public class CanPrefixSum {

    public static void main(String[] args) {
        int []arr = {1,2,2,3,4,2,5,6,7};
        int target = 7;

        log.info("prefix sum exists: {} ",canPrefixSum(arr,target));

        log.info("prefix sum first: {}",howPrefixSum(arr,target));


        log.info("prefix sum count: {}",countPrefixSum(arr,target));

        log.info("all prefix sum: {}",allPrefix(arr,target));


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
                return Arrays.asList(dataMap.get(prefixSum-target)+1,i);
            }
            if(!dataMap.containsKey(prefixSum)){
                dataMap.put(prefixSum,i);
            }
        }
        return Arrays.asList(-1,-1);
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


    public static List<List<Integer>> allPrefix(int []arr,int k){
        Map<Integer,List<Integer>> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        prefixSumMap.put(0,list);
        List<List<Integer>> result = new ArrayList<>();
        for (int i =0; i<arr.length; i++){
            prefixSum = prefixSum + arr[i];
            if(prefixSumMap.containsKey(prefixSum - k)){
                for (int index : prefixSumMap.get(prefixSum-k)){
                    result.add(List.of(index + 1,i));
                }
            }
            List<Integer> indexes = prefixSumMap.getOrDefault(prefixSum,new ArrayList<>());
            indexes.add(i);
            prefixSumMap.put(prefixSum,indexes);
        }
        return result;
    }

}
