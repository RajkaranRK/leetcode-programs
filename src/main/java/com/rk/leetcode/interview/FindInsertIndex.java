package com.rk.leetcode.interview;

public class FindInsertIndex {
    
    
    
    public static void main(String []args) {
        
        
        FindInsertIndex findInsertIndex = new FindInsertIndex();
        int index = findInsertIndex.searchInsert(new int[] {1,3,5}, 0);
        System.out.println(index);
        
    }
    
    

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while( l < r ) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

}
