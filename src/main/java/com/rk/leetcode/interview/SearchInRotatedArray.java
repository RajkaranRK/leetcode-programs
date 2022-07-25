package com.rk.leetcode.interview;

public class SearchInRotatedArray {

    public static void main(String []args){
        SearchInRotatedArray rotatedArray = new SearchInRotatedArray();

        int index = rotatedArray.search(new int[]{1,3},2);
        System.out.println("index "+index);
    }

    public int search(int[] nums, int target) {
        int i =0;
        int j = nums.length-1;
        int index = -1;
        while(i<=j){
            if(nums[i]== target){
                index = i;
                break;
            }
            if(nums[j] == target){
                index = j;
                break;
            }
            i++;j--;
        }
        return index;
    }


}
