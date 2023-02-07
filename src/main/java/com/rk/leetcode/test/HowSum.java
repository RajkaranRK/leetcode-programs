package com.rk.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class HowSum {


    public static void main(String[] args) {
        List<Integer> list = howSum(7,new int[]{2,3});
        list.forEach(System.out::println);
    }

    private static List<Integer> howSum(int target, int []arr){
        if(target < 0){
            return null;
        }
        if(target == 0){
            return new ArrayList<>();
        }
        for(int i=0;i<arr.length;i++){
            int reminder = target - arr[i];
            List<Integer> list = howSum(reminder,arr);
            if(list != null){
                list.add(arr[i]);
                return list;
            }
        }
        return null;
    }
}