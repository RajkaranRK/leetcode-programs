package com.rk.leetcode.test;

public class SearchInSortedArray {

    public static void main(String []args){

    }

    public static int binarySearchSortedArray(int arr[],int key){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == arr[key]){
                return mid;
            }
            //check is left sorted
            if(arr[mid] >= arr[start] || arr){

            }else{
                //else right sorted

            }
        }

    }
}
