package com.rk.leetcode.test;

public class SearchInSortedArray {

    public static void main(String []args){
        int arr[] = new int[] {2,4,5,6,7,0,1};
        int key = 0;
        int index = binarySearchSortedArray(arr, key);
        System.out.println("Found " + index);
    }

    public static int binarySearchSortedArray(int arr[],int key){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            }
            //check is left sorted
            if(arr[mid] > arr[start]){
                if(key >= arr[start] && key < arr[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else{
                //else right sorted
                if(key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
