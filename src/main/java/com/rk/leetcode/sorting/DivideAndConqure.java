package com.rk.leetcode.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DivideAndConqure {


    public static void main(String []args){
        DivideAndConqure divideAndConqure = new DivideAndConqure();
        int arr[] = new int[]{4,3,1};
        divideAndConqure.sort(arr);
        IntStream.range(0,arr.length).forEach(index -> System.out.print(arr[index]+","));
    }


    public void sort(int []arr){
        sort(arr,0, arr.length-1);
    }


    public void sort(int arr[], int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        System.out.println("mid "+mid);
        System.out.println("left "+left+ "mid "+mid);
        sort(arr,left,mid);
        System.out.println("mid+1 "+(mid+1)+ "right "+right);
        sort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }


    public void merge(int arr[] , int left ,int mid, int right){
        int n = mid - left + 1;
        int m = right - mid;
        int L[] = new int[n];
        int R[] = new int[m];

        //temp left sub array
        for(int i=0; i<n; i++){
            L[i] = arr[left + i];
        }

        //temp right sub array
        for(int j=0; j<m ;j++){
            R[j] = arr[mid+1+j];
        }

        int i = 0, j= 0; //left and right sub array starting point
        int k = left;
        while (i<n && j<m){
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //now to put the remaning one
        while(i < n){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<m) {
            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.println("Merge Array");
        IntStream.range(0,right+1).forEach(index -> System.out.print(arr[index]+","));
        System.out.println();
    }


}
