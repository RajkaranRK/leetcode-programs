package com.rk.leetcode.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {

    public static void main(String []args){
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> sumList = threeSum.threeSum(new int []{-1,0,1,2,-1,-4,-2,-3,3,0,4});
        System.out.println(sumList);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i< nums.length; i++){
            int lo = i + 1;
            int hi = nums.length - 1;
            int sum = -nums[i];
            while(lo < hi){
                if(nums[lo] + nums[hi] == sum){
                    list.add(Arrays.asList(nums[lo],nums[hi],-sum));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi-i]) hi--;
                    lo++;
                    hi--;
                }else if(nums[lo] + nums[hi] < sum){
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    lo++;
                }else {
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    hi--;
                }
            }
        }
        return list;
    }

}
