package com.rk.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class JumpGame {
    
    
    
    //[5,9,3,2,1,0,2,3,3,1,0,0]
    public static void main(String []args) {
        int arr[] = new int[] {5,9,3,2,1,0,2,3,3,1,0,0};
        boolean possible = isJumpPossible(arr, 0,new HashMap<>());
        System.out.println("is possible "+possible);
    }
    
    private static boolean isJumpPossible(int []arr,int start,Map<Integer,Boolean> memo) {
        if(memo.containsKey(start)) {
            memo.get(start);
        }
        if(start == arr.length-1) {
            return true;
        }
        if(start >= arr.length) {
            return false;
        }
        if(arr[start] == 0) {
            return false;
        }
        for(int i=1; i<=arr[start]; i++) {
            if(isJumpPossible(arr, start+i,memo)) {
                memo.put(start+i,true);
                return true;
            }
        }
        memo.put(start, false);
        return false;
    }
}
