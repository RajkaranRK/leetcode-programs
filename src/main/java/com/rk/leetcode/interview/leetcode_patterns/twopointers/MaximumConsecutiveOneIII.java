package com.rk.leetcode.interview.leetcode_patterns.twopointers;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaximumConsecutiveOneIII {


    public static void main(String[] args) {
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int count = countOne(arr,k);
        log.info("Consecutive One's : {}",count);
    }


    private static  int countOne(int []arr,int k){
        int i = 0;
        int j = 0;
        int zeroCount = 0;
        int max = 0;
        int temp = 0;
        while( i <arr.length){
            if(arr[i] == 0  && zeroCount < k){ //zero with less than k
                zeroCount++;
                temp++;
                i++;
            }else if (arr[i] != 0){ //not zero
                temp++;
                i++;
            }else {
                if(arr[j] == 0){
                    zeroCount--;
                }
                temp--;
                j++;
            }
            max = Math.max(temp,max);
        }

        return max;
    }


}
