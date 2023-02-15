package com.rk.leetcode.test;

import java.util.*;

public class SumSubset {


    public static void main(String []args){
        int arr[] = {1,2,3};
        Set<List<Integer>> powerSet = new HashSet<>();
        sumSubset(arr,7,new ArrayList<>(), powerSet);
        powerSet.forEach(System.out::println);
        System.out.println("Count "+powerSet.size());

        System.out.println("**************************");
        int count = sumPowerSet(arr,7,0);
        System.out.println("Count "+count);

        powerSet.clear();
        List<List<Integer>> powerSet2 = new ArrayList<>();
        sumPowerSet(arr,7,0,new ArrayList<>(),powerSet2);
        powerSet2.forEach(System.out::println);
    }


    private static void sumSubset(int []arr, int sum, List<Integer> subset, Set<List<Integer>> powerSet){
        if(sum == 0){
            subset.sort((e1,e2)->e1.compareTo(e2));
            powerSet.add(subset);
            return;
        }
        if(sum < 0){
            return;
        }
        for(int i =0; i<arr.length; i++){
            List<Integer> list = new ArrayList<>();
            if(!subset.isEmpty()){
                list.addAll(subset);
            }
            list.add(arr[i]);
            sumSubset(arr,sum - arr[i], list,powerSet);
        }
    }


    public static int sumPowerSet(int arr[], int sum,int index){
        if(sum == 0){
            return 1;
        }
        if(sum < 0 || arr.length == index){
            return 0;
        }
        return  sumPowerSet(arr,sum, index + 1) + sumPowerSet(arr,sum - arr[index], index);
    }

    public static void sumPowerSet(int arr[], int sum, int index,List<Integer> subset, List<List<Integer>> powerSet){
        if(sum == 0){
            powerSet.add(subset);
            return;
        }
        if(sum < 0 || index == arr.length){
            return;
        }
        sumPowerSet(arr,sum,index+1,new ArrayList<>(subset),powerSet);
        List<Integer> list = new ArrayList<>();
        if(!subset.isEmpty()){
            list.addAll(subset);
        }
        list.add(arr[index]);
        sumPowerSet(arr,sum - arr[index],index,list,powerSet);
    }
}
