package com.rk.leetcode.interview.recursion;

import java.util.Arrays;

public class MergeSort {

    public static void main(String []args){
        int arr[] = new int[]{38,27,43,3,9,82,10};
        System.out.println("Before sorting ");
        printArray(arr,0,arr.length);
        mergeSort(arr,0,arr.length-1);

        System.out.println("After Sorting");
        printArray(arr,0,arr.length);
    }


    private static void printArray(int []arr,int start,int end){
        System.out.print("[");
        for(int i=start;i<end;i++){
            System.out.print(""+arr[i]+",");
        }
        System.out.println("]");
    }

    private static void mergeSort(int arr[], int start,int end){
        if(start >= end){
            return;
        }
        int mid = ( start + end ) / 2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }


    private static void merge(int arr[],int start,int mid,int end){
        System.out.println("Array before merge");
        printArray(arr,start,end+1);
        int len1 = mid - start + 1;
        int len2 = end - mid;
        int []first = new int[len1];
        int []second = new int[len2];
        int k = start;
        for(int i=0; i<len1;i++){
            first[i] = arr[k++];
        }
        k = mid + 1;
        for(int i=0; i<len2;i++){
            second[i] = arr[k++];
        }
        System.out.println("First Array");
        printArray(first,0,len1);
        System.out.println("Second Array");
        printArray(second,0,len2);
        int index1 = 0;
        int index2 = 0;
        int mainIndex = start;
        while(index1 < len1 && index2 < len2){
            if(first[index1] <= second[index2]){
                arr[mainIndex] = first[index1++];
            }else{
                arr[mainIndex] = second[index2++];
            }
            mainIndex++;
        }
        while(index1 < len1){
            arr[mainIndex++] = first[index1++];
        }
        while(index2 < len2){
            arr[mainIndex++] = second[index2++];
        }
        System.out.println("Array After merge");
        printArray(arr,start,end+1);
    }
}
