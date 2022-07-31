package com.rk.leetcode.interview.recursion;

import java.util.*;

/**
 * This problem is used to take the input of targetSum and array of numbers
 * where we have to find all the possible sub-array having sum
 */
public class HowSumArray {

    public static void main(String []args){
        HowSumArray howSumArray = new HowSumArray();
        Set<List<Integer>> sets = new HashSet<>();
        howSumArray.findSumCombination(7,new int[]{2,4},null,sets);
        sets.stream().forEach(System.out::println);
    }


    public void findSumCombination(int target, int[]numbers,List<Integer> combination,Set<List<Integer>> sets){
        if(target == 0){
            sets.add(combination);
            return;
        }
        if(target < 0 ){
            return;
        }
        for(int i=0; i < numbers.length;i++){
            int remainder = target - numbers[i];
            List<Integer> nums = new ArrayList<>();
            if(combination !=null){
                for(Integer num: combination){
                    nums.add(num);
                }
            }
            nums.add(numbers[i]);
            Collections.sort(nums);
            findSumCombination(remainder, numbers,nums, sets);
        }
    }
}
