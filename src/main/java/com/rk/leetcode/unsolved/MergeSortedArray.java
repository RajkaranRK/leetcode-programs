package com.rk.leetcode.unsolved;

import java.util.Arrays;

public class MergeSortedArray {
    
    public static void main(String []args) {
       MergeSortedArray mergeSortedArray = new MergeSortedArray();
       Integer nums1[] = new Integer[] {0,0,0};
       Integer nums2[] = new Integer[] {2,5,7};
       
       mergeSortedArray.merge(nums1, 0, nums2, 3);
       
       Arrays.asList(nums1).stream().forEach(System.out::print);
       
       
    }
    
    public void merge(Integer[] nums1, int m, Integer[] nums2, int n) {
        
        int len = m + n;
        int holder = -1;
        int i =0;
        int j =0;
        
        while(i<len) {
            if(nums1[i] != 0 && holder == -1) {
                if(nums1[i] <= nums2[j]) {
                    i++;
                }else {
                    holder = nums1[i];
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
            }else {
                if(holder != -1 && (j==n || holder <= nums2[j])) {
                    int temp = nums1[i];
                    if(temp == 0 || temp > holder) {
                        nums1[i] = holder;
                        holder = (temp == 0 ? -1 : temp);
                    }
                    i++;
                }else {
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
            }
        }
        
    }
}
