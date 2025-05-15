package com.rk.leetcode.interview.leetcode_patterns.prefixsum;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class AllSubArraySum {

    public static void main(String[] args) {
        int arr[] = {9,4,0,20,3,10,5};
        int target = 33;
        List<List<Integer>> list = allSubArraySum(arr,target);
        log.info("how Prefix sum : {}",list);
    }

    private static List<List<Integer>> allSubArraySum(int []arr,int target){
        Map<Integer,List<Integer>> prefixMap = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        prefixMap.put(0, Arrays.asList(-1));
        int prefixSum = 0;
        for (int i =0; i<arr.length; i++){
            prefixSum += arr[i];
            int key = prefixSum - target;
            if(prefixMap.containsKey(key)){
                int finalI = i;
                prefixMap.get(key).forEach(num -> list.add(Arrays.asList(num+1, finalI)));
            }else{
                List<Integer> nums = prefixMap.getOrDefault(prefixSum,new ArrayList<>());
                nums.add(i);
                prefixMap.put(prefixSum,nums);
            }
        }
        return list;
    }
}
