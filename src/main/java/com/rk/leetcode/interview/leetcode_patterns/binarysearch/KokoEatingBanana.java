package com.rk.leetcode.interview.leetcode_patterns.binarysearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KokoEatingBanana {


    public static void main(String[] args) {
        int []piles = {25,10,23,4};
        int h = 4;
        log.info("Can eat all banana with min speed of : {} bananas/hour",minEatingSpeed(piles,h));
    }


    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<piles.length; i++){
            max = Math.max(max,piles[i]);
        }
        int left = 0;
        int right = max;
        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            if(canEat(piles,mid,h) && min > mid){
                min = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return min;
    }

    public static boolean canEat(int []piles, int k, int h){
        if(k == 0) return false;
        int totalHr = 0;
        for(int i =0; i<piles.length; i++){
            totalHr += (int) Math.ceil((double)piles[i] / k);
        }
        return totalHr <= h;
    }
}
