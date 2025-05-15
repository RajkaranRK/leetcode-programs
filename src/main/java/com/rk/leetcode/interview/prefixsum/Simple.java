package com.rk.leetcode.interview.prefixsum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Simple {


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int l = 2;
        int r = 4;
        log.info("sum from {} to {} index is : {}",l,r,prefixSum(arr,l,r));
    }


    private static int prefixSum(int arr[],int l,int r){
        if(arr.length > 1){
            int prev = arr[0];
            for (int i = 1; i < arr.length; i++){
                arr[i] = prev + arr[i];
                prev = arr[i];
            }
        }
        if(l == 0){
            return arr[r];
        }else{
            return arr[r] - arr[l-1];
        }
    }
}
