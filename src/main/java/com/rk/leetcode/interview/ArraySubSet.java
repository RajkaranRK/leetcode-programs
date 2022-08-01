package com.rk.leetcode.interview;

import java.util.*;

public class ArraySubSet {

    public static void main(String []args){
        ArraySubSet arraySubSet = new ArraySubSet();
        int count = arraySubSet.countDistinctSet(new int[]{625,4,2,5,25,1,49,9,16,7,2,4});
        System.out.print(count);
    }


    public int countDistinctSet(int []arr){
        Set<Integer> numSet = new TreeSet<>();
        Set<List<Integer>> sets = new HashSet<>();
        for(int i=0;i<arr.length; i++){
            int n = arr[i];
            if(numSet.contains(n*n)){
                numSet.add(n);
                numSet.remove(n*n);
                sets.add(Arrays.asList(n,n*n));
                //check if this number is further exists in
            }else{
                numSet.add(n);
            }
        }

        for(int i=0; i<arr.length;i++){
            addIfPresent(sets,arr[i]);
        }
        sets.stream().forEach(System.out::println);
        return sets.size();
    }

    public void addIfPresent(Set<List<Integer>> sets,int n){
        Set<List<Integer>> newSet = new HashSet<>();
        for(List<Integer> list : sets){
            for(int i=0; i<list.size(); i++){
                if((list.get(i) == n*n || list.get(i)*list.get(i) == n) && !list.contains(n)){
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(n);
                    Collections.sort(newList);
                    newSet.add(newList);
                }
            }
        }
        sets.addAll(newSet);
    }
}
