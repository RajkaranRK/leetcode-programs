package com.rk.leetcode.interview.recursion;

public class SortedArray {


    public static void main(String[] args) {
        boolean isSorted = isSorted(new int[]{2,3,4,1},0);
        System.out.println("Arrays is Sorted : ? "+isSorted);
    }


    private static boolean isSorted(int arr[],int start){
        if(arr.length == 0 || arr.length == start+1){
            return true;
        }
        if(arr[start] > arr[start+1]){
            return false;
        }else{
            boolean isSorted = isSorted(arr,start+1);
            return isSorted;
        }
    }
}
