package com.rk.leetcode.interview.leetcode_patterns.binarysearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchInUnknownArraySize {



    public static void main(String[] args) {
        ArrayReader arrayReader = new ArrayReader(new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170});

        int target = 100;

        //binary search;
        int index = binarySearch(arrayReader,target);
        log.info("Value {} found at index : {}", target,index);
    }


    private static int binarySearch(ArrayReader arrayReader, int target){
        int low = 0;
        int high = 1;
        while(target > arrayReader.getValue(high)){
            low = high;
            high = high * 2;
        }
        log.info("low :{} and high:{} range calculated ",low,high);

        while(low <= high){
            int mid = ( low + high ) / 2;
            if(arrayReader.getValue(mid) == target){
                return mid;
            }
            if(arrayReader.getValue(mid) < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }


    public static class ArrayReader {
        private int arr[];

        public ArrayReader(int []arr){
            this.arr = arr;
        }

        public int getValue(int index){
            if(index >= arr.length){
                return Integer.MAX_VALUE;
            }
            return arr[index];
        }
    }
}
