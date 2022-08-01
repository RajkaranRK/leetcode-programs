package com.rk.leetcode.sorting;

import java.util.stream.IntStream;

public class SelectionSort {
    
    
    public static void main(String []args) {
        int arr[] = new int[] {7,1,3,2,5,6,4};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        IntStream.range(0, arr.length).forEach(i->System.out.print(arr[i]+","));
    }
    
    
    public void sort(int []arr) {
        for(int i =0; i<arr.length; i++) {
            int max = arr[i];
            int j=i+1;
            int maxIndex = -1;
            System.out.println("************************");
            while(j<arr.length) {
                if(max > arr[j]) {
                    maxIndex = j;
                    max = arr[j];
                }    
                j++;
            }
            if(maxIndex != -1) {
                
                //now swap the element 
                System.out.println("swap()"+arr[i]+","+arr[maxIndex]);
                swap(arr,i,maxIndex);
            }
            System.out.println("************************");
        }
    }
    
    public void swap(int[] arr, int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
