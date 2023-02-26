package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
    
    
    
    public static void main(String []args) {
        ArrayPermutation permutation = new ArrayPermutation();
        
        List<List<Integer>> permuations = permutation.permute(new int[] {1,2,3});
        
        permuations.forEach(System.out::println);
    }
    
    
    
    public List<List<Integer>> permute(int []nums){
        List<Integer> list = new ArrayList<>();
        for(int i =0; i<nums.length;i++) {
            list.add(nums[i]);
        }
        List<List<Integer>> permuations = new ArrayList<>();
        permute(list,null,permuations,0);
        return permuations;
    }
    
    
    public void permute(List<Integer> nums,List<Integer> list,List<List<Integer>> permutations,int index) {
        if(index == nums.size()) {
            permutations.add(list);
            return;
        }
        for(int i=index; i < nums.size(); i++) {
            List<Integer> swapList = swap(nums, list, index, i);
            permute(nums, swapList, permutations, index+1);            
        }
    }
    
    
    private List<Integer> swap(List<Integer> nums,List<Integer> list , int i ,int j){
        List<Integer> swapList = new ArrayList<>(list == null ? nums: list);
        int temp = swapList.get(i);
        swapList.set(i, swapList.get(j));
        swapList.set(j, temp);
       return swapList;
    }
    
    
    

}
