package com.rk.leetcode.interview;

public class RemoveDuplicateFromSortedArray {

    public static void main(String []args){
        RemoveDuplicateFromSortedArray removeDuplicateFromSortedArray = new RemoveDuplicateFromSortedArray();
        int nums[] = removeDuplicateFromSortedArray.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        for(int i=0;i< nums.length;i++){
            System.out.print(nums[i]+",");
        }
    }

    public int[] removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums;
        }
        int prev = nums[0];
        int end = 1;
        int start = 1;
        while(end < nums.length){
            if(prev == nums[end]){
                end++;
                continue;
            }else{
                nums[start] = nums[end];
                prev = nums[end];
                end++;
                start++;
            }
        }
        return nums;
    }
}
