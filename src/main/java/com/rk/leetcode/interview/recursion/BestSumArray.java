package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BestSumArray {
    
    
    /**
     * Need to work on the memoization 
     * @param args
     */
    public static void main(String []args) {
        
        BestSumArray bestSum = new BestSumArray();
        List<Integer> bestList = bestSum.findBestSum(7, new int[] {1,2,4},new HashMap<>());
        System.out.println(bestList);
        
    }
    
    
    public List<Integer> findBestSum(int targetSum, int []arr,Map<Integer, List<Integer>> memo){
        if(memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if(targetSum == 0) {
            List<Integer> myList = new ArrayList<>();
            return myList;
        }
        if(targetSum < 0) {
            return null;
        }
        List<Integer> shortestCombination = null;
        for(int i =0; i < arr.length;i++) {
            int remainder = targetSum - arr[i];
            List<Integer> numList = findBestSum(remainder , arr,memo);
            if(numList != null) {
              //created a new array so it won't effect the prev
                List<Integer> newList = new ArrayList<>(numList); 
                newList.add(arr[i]);
                if(shortestCombination == null || shortestCombination.size() > newList.size()) {
                    shortestCombination = newList;
                }
            }
        }
        memo.put(targetSum, shortestCombination);
        return shortestCombination;
    }
    

}
