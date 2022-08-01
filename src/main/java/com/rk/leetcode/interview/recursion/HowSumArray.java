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
        int arr[] = new int[] {2,4,3};
        howSumArray.findSumCombination(7,arr,null,sets);
        sets.stream().forEach(System.out::println);

        System.out.println("*****************************************************");
        List<Integer> set =  howSumArray.findSumCombination2(7,arr,new HashMap<>());
        System.out.println(set);
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


    //method to return any existing possibility
    public List<Integer> findSumCombination2(int target, int[]numbers,Map<Integer,List<Integer>> memo){
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0){
            return new ArrayList<>();
        }
        if(target < 0 ){
            return null;
        }
        for(int i=0; i < numbers.length;i++){
            int remainder = target - numbers[i];
            List<Integer> numList = findSumCombination2(remainder, numbers,memo);
            if(numList != null){
                numList.add(numbers[i]);
                Collections.sort(numList);
                memo.put(target, numList);
                return numList;
            }

        }
        
        memo.put(target, null);
        return null;
    }

}
