package com.rk.leetcode.interview;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FirstMissingPositiveINumber {
    
    public static void main(String []args) {
        int[] arr = new int[] {3,4,-1,1};
        FirstMissingPositiveINumber missingPositiveINumber = new FirstMissingPositiveINumber();
        int num = missingPositiveINumber.firstMissingPositive(arr);
        System.out.print(num);
    }
    
    
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numSet = new TreeSet<>();
        for(int i=0; i<nums.length;i++) {
            if(nums[i]>0 &&  nums[i] <= nums.length)
                numSet.add(nums[i]);
        }
        Iterator<Integer> iter = numSet.iterator();
        int count = 0;
        while(iter.hasNext()) {
            if(!iter.next().equals(count+1)) {
                return count+1;
            }
            count++;
        }
        return count+1;
    }

}
