package com.rk.leetcode.interview.recursion;

public class BubbleSort {


    public static void main(String[] args) {
        int arr[] = new int[]{9,3,1,5,0,2};
        sort(arr,arr.length - 1);
        for (int i =0 ;i<arr.length; i++){
            System.out.print(""+arr[i]+",");
        }
    }


    private static void sort(int arr[], int end){
        if(end == 0 || end == 1){
            return;
        }
        for(int i=0; i < end; i++){
            if(arr[i] > arr[i+1]){
                swap(arr,i,i+1);
            }
            sort(arr,end-1);
        }
    }

    private static void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
