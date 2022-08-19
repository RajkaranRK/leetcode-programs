package com.rk.leetcode.interview.dp.memoization;


/**
 * In this we have to find that whether the solution of the array is exists or  not
 * i.e. boolean value true / false
 * i.e. targetSum should be equals to any combination from the array
 */

import java.util.HashMap;

/**
 * It's considered as all the element should be non-negative
 */
public class CanArraySum {


    public static void main(String []args){
        CanArraySum canArraySum = new CanArraySum();
        boolean isExists = canArraySum.isSumExists(7, new int[]{2,2,2,2,2,2,2,2},new HashMap<Integer,Boolean>());
        System.out.print(isExists);
    }


    public boolean isSumExists(int targetSum, int[] numbers, HashMap<Integer,Boolean>memo){
        if(memo.containsKey(targetSum)){
           return memo.get(targetSum);
        }
        if(targetSum == 0){
            return true;
        }
        if(targetSum < 0){
            return false;
        }
        for(int i=0;i<numbers.length;i++){
            int sub = targetSum - numbers[i];
            if(isSumExists(sub,numbers,memo)){
                memo.put(targetSum,true);
                return true;
            }
        }
        memo.put(targetSum,false);
        return false;
    }
}
