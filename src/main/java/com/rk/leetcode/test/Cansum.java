package com.rk.leetcode.test;

import java.util.HashMap;
import java.util.Map;

public class Cansum {

    public static void main(String []args){
        System.out.println(canSum(300,new int[]{7,14},new HashMap<>()));
    }

    private static boolean canSum(int target, int[]arr, Map<Integer,Boolean> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target < 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        for(int i=0; i<arr.length;i++){
            if(canSum(target-arr[i],arr,memo)){
                memo.put(target,true);
                return true;
            }
        }
        memo.put(target,false);
        return false;
    }
}
