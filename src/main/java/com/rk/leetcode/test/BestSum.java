package com.rk.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class BestSum {


    public static void main(String []args){
        List<Integer> bestSum = findBestSum(7, new int[] {2,3,4,7});
        System.out.println(bestSum);
    }

    private static List<Integer> findBestSum(int targetSum, int []arr){
        if(targetSum == 0){
            return new ArrayList<>();
        }
        if(targetSum < 0){
            return null;
        }
        List<Integer> shortestCombination = null;
        for(int i=0;i<arr.length; i++){
            List<Integer> list = findBestSum(targetSum - arr[i], arr);
            if(list != null){
                list.add(arr[i]);
                if(shortestCombination == null || shortestCombination.size() > list.size()){
                    shortestCombination = list;
                }
            }
        }
        return shortestCombination;
    }
}
