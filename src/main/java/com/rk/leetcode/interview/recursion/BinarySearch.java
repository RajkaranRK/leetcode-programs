package com.rk.leetcode.interview.recursion;

public class BinarySearch {


    public static void main(String[] args) {
        boolean isFound = binarySearch(new int[]{2,3,4,5,6,7},0,5,2);
        System.out.println("Key found : " +isFound);
    }

    private static boolean binarySearch(int []arr,int start,int end, int key){
        log(arr,start,end,key);
        if(start > end){
            return false;
        }
        int mid = (start + end) / 2;
        if(arr[mid] == key){
            return true;
        }
        if(arr[mid] > key){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        return binarySearch(arr,start,end,key);
    }

    private static void log(int arr[],int start,int end,int key){
        System.out.print("[");
        for(int i=0;i<arr.length;i++){
            System.out.print(""+arr[i]+",");
        }
        System.out.println("]");

        System.out.println("start ="+start +"end="+end+"key ="+key);
    }
}
