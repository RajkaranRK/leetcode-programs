package com.rk.leetcode.interview;

public class ArrayMedian {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i =0,j=0;
        int arr[] = new int[nums1.length+nums2.length];
        int k = 0;
        while(i<nums1.length || j<nums2.length){
            if(i>nums1.length-1){
                arr[k] = nums2[j];
                j++;
            }else if(j >nums2.length-1){
                arr[k] = nums1[i];
                i++;
            }else {
                if(nums1[i] < nums2[j]){
                    arr[k] = nums1[i];
                    i++;
                }else{
                    arr[k] = nums2[j];
                    j++;
                }
            }
            k++;
        }
        if(arr.length %2 == 0){
            return (double) (arr[arr.length/2] + arr[(arr.length/2)-1]) / 2;
        }else{
            return (double) arr[arr.length/2];
        }
    }
    
    
    public static void main(String []args) {
        ArrayMedian median = new ArrayMedian();
        System.out.println(median.findMedianSortedArrays(new int[] {1,3,4}, new int[] {2,5,7}));
    }
}
