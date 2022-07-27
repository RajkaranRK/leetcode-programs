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
        
        num = missingPositiveINumber.firstMissingPositive2(arr);
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
    
    
    public int firstMissingPositive2(int nums[]) {
        //mark the element
        boolean one = false;
        for(int i=0; i<nums.length;i++) {
            if(nums[i] == 1) {
                one = true;
            }
            if(nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if(!one) {
            return 1;
        }
        for(int i=0;i<nums.length;i++) {
            int index = Math.abs(nums[i]);
            nums[index-1] = -Math.abs(nums[index-1]); 
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                return i+1;
            }
        }
        return nums.length+1;
    }

}
