package com.rk.leetcode.interview;

public class LastAndFirstPosition {


    public static void main(String []args){
        LastAndFirstPosition lastAndFirstPosition = new LastAndFirstPosition();
        int indexes[] = lastAndFirstPosition.searchRange(new int[]{1}, 1);
        System.out.println("{"+indexes[0]+","+indexes[1]+"}");

        indexes = lastAndFirstPosition.searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println("{"+indexes[0]+","+indexes[1]+"}");

    }

    public int[] searchRange(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int mid = -1;
        int []indexes = new int[]{-1,-1};
        while(l<=r && (indexes[0] == -1 || indexes[1] == -1)){

            if(nums[l] != target){
                l++;
            }else{
                indexes[0] = l;
            }
            if(nums[r] != target){
                r--;
            }
            else{
                indexes[1] = r;
            }
        }
        if(indexes[0] != -1 && indexes[1] == -1){
            indexes[1] = indexes[0];
        }else if(indexes[1] != -1 && indexes[0] == -1){
            indexes[0] = indexes[1];
        }
        return indexes;
    }


}
