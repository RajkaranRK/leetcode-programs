package com.rk.leetcode.test;

import java.util.*;

public class AllSum {

    public static void main(String []args){
        Set<List<Integer>> allSums = new HashSet<>();
        findAllSum(7,new int[]{2,3,4,7,1},null,allSums);
        allSums.forEach(System.out::println);
        allSums.clear();
        System.out.println("**************************");
        findAllSum2(7,new int[]{2,3,4,7,1},null,allSums);
        allSums.forEach(System.out::println);
    }


    private static void findAllSum(int targetSum, int []arr, List<Integer> combination, Set<List<Integer>> allSums){
        if(targetSum == 0){
            allSums.add(combination);
            return;
        }
        if(targetSum < 0){
            return;
        }
        for(int i=0; i<arr.length; i++){
            List<Integer> list = new ArrayList<>();
            if(combination != null){
                list.addAll(combination);
            }
            list.add(arr[i]);
            list.sort((e1,e2)->e1.compareTo(e2));
            findAllSum(targetSum - arr[i], arr, list,allSums);
        }
    }


    public static void findAllSum2(int target, int []arr, List<Integer> combination, Set<List<Integer>> allSums){
        if(target == 0){
            Collections.sort(combination);
            allSums.add(combination);
            return;
        }
        if(target < 0){
            return;
        }
        for(int i=0;i<arr.length;i++){
            List<Integer> nums = new ArrayList<>();
            if(combination != null){
                nums.addAll(combination);
            }
            nums.add(arr[i]);
            findAllSum2(target-arr[i], arr,nums,allSums);
        }
    }
}
