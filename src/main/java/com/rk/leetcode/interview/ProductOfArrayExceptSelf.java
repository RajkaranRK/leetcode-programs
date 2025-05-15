package com.rk.leetcode.interview;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ProductOfArrayExceptSelf {


    public static void main(String[] args) {
        int []arr = {2,3,4,5};
        productOfArrayExceptSelf(arr);
        productOfArrayExceptSelf2(arr);
    }

    private static void productOfArrayExceptSelf(int []arr){
        int []prefix = new int[arr.length];
        int []suffix = new int[arr.length];
        //calculate the prefix of the array
        prefix[0] = 1;
        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1] * arr[i-1];
        }
        suffix[arr.length-1] = 1;
        for (int i=arr.length-2; i >=0; i--){
            suffix[i] = suffix[i+1] * arr[i+1];
        }
        for (int i=0;i<arr.length;i++){
            prefix[i] = prefix[i]*suffix[i];
        }
        //Arrays.stream(prefix).boxed().forEach(System.out::println);
        //Arrays.stream(suffix).boxed().forEach(System.out::println);
    }


    private static void productOfArrayExceptSelf2(int []arr){
        int []product = new int[arr.length];
        //calculate the prefix of the array
        product[0] = 1;
        for(int i=1;i<arr.length;i++){
            product[i] = product[i-1] * arr[i-1];
        }
        int suffix = 1;
        for (int i=arr.length-2; i >=0; i--){
            suffix = suffix * arr[i+1];
            product[i] = product[i] * suffix;
        }
        Arrays.stream(product).boxed().forEach(System.out::println);
    }
}
