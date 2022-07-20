package com.rk.leetcode.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumProblem {

    public static void main(String []args){
        TwoSumProblem sumProblem = new TwoSumProblem();
        int []indexes = sumProblem.twoSum(new int[]{2,7,11,15},17);
        System.out.println(indexes[0] + " "+indexes[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numberMap = new HashMap<>();
        int indexes[] = new int[]{-1,-1};
        for(int i =0; i<nums.length; i++){
            int sum = target - nums[i];
            if(numberMap.containsKey(sum)){
                indexes[0] = i;
                indexes[1] = numberMap.get(sum);
                break;
            }else{
                numberMap.put(nums[i], i);
            }
        }
        return indexes;
    }
}
