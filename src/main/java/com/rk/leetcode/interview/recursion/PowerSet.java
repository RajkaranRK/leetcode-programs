package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {



    public static void main(String []args){
        List<List<Integer>> powerSet = new ArrayList<>();
        int arr[] = new int[]{1,2,3};
        powerSet(arr,new ArrayList<>(),0,powerSet);
        powerSet.forEach(System.out::println);
    }


    private static void powerSet(int []arr, List<Integer> subset, int index, List<List<Integer>> powerSet){
        if(index == arr.length){
            powerSet.add(subset);
            return;
        }
        powerSet(arr,new ArrayList<>(subset),index+1,powerSet);
        List<Integer> includeSet = new ArrayList<>();
        includeSet.addAll(subset);
        includeSet.add(arr[index]);
        powerSet(arr,includeSet,index+1,powerSet);
    }
}
