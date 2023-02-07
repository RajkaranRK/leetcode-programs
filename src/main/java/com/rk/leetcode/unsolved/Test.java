package com.rk.leetcode.unsolved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Test {
    
    public static void main(String []args) {
        System.out.println(gridTraveller(2, 3,new HashMap<>()));
        System.out.println(gridTraveller(10, 10,new HashMap<>()));
        System.out.println(gridTraveller(50, 50,new HashMap<>()));
        
        System.out.println(canSum(7, new int[]{2,3,5,6,7,4},new HashMap<>()));
        System.out.println(canSum(300, new int[]{7,14},new HashMap<>()));
        
        List<List<Integer>> lists = new ArrayList<>();
        howSum(7, new int[]{2,3,5,6,7,4},null,lists);
        System.out.println(lists);
        
        System.out.println(howSum(7,new int[] {2,3,5,6,7,4}));
        
    }
    
    
    public static long gridTraveller(int m, int n,Map<String,Long> memo) {
        if(m == 1 && n == 1) {
            return 1;
        }
        if(m == 0 || n == 0) {
            return 0;
        }
        String key = m + ","+n;
        if(!memo.containsKey(key)) {
            memo.put(key,gridTraveller(m-1, n,memo) + gridTraveller(m, n-1,memo));
        }
        return memo.get(key);
    }
    
    
    public static boolean canSum(int target, int[]numbers,Map<Integer,Boolean> memo) {
        if(memo.containsKey(target)) {
            return memo.get(target);
        }
        if(target == 0) {
            return true;
        }
        if(target < 0) {
            return false;
        }
        for(int i=0;i<numbers.length;i++) {
            if(canSum(target-numbers[i], numbers,memo)) {
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }
    
    
    public static void howSum(int target, int[]numbers,List<Integer> list, List<List<Integer>> lists) {
        if(target == 0) {
            lists.add(list);
        }
        if(target < 0) {
            return;
        }
        for(int i=0; i<numbers.length; i++) {
            List<Integer> temp = new ArrayList<>();
            if(list != null && !list.isEmpty()) {
                temp.addAll(list);
            }
            temp.add(numbers[i]);
            howSum(target-numbers[i],numbers,temp,lists);
        }
    }
    
    
    public static List<Integer> howSum(int target, int []numbers){
        if(target == 0) {
            return new ArrayList<>();
        }
        if(target < 0) {
            return null;
        }
        for(int i =0; i < numbers.length; i++) {
            List<Integer> list = howSum(target - numbers[i], numbers);
            if(list != null) {
                list.add(numbers[i]);
                return list;
            }
        }
        return null;
    }

}
