package com.rk.leetcode.test;

import java.util.Arrays;

public class RemoveDuplicateFromArray {


    public static void main(String []args){
        int arr[] = new int[]{1,1,2,3,3,4,5,5,6,7,7};
        printArray(arr);
        removeDuplicate(arr);
        printArray(arr);
        "raj".substring(0,5);
    }


    private static void printArray(int arr[]){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        System.out.println("]");
    }
    private static void removeDuplicate(int arr[]){
        if(arr.length == 0 || arr.length == 1){
            return;
        }
        int currentIndex = 1;
        int prevIndex = 1;
        int prev = arr[0];
        while(currentIndex < arr.length){
            if(prev != arr[currentIndex]){
                arr[prevIndex] = arr[currentIndex];
                prev = arr[currentIndex];
                prevIndex++;
            }
            currentIndex++;
        }
    }
}
