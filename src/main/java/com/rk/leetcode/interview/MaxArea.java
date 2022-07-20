package com.rk.leetcode.interview;

public class MaxArea {

    public static void main(String []args){
        MaxArea maxArea = new MaxArea();
        int max = maxArea.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.print("Max Area "+max);
    }

    public int maxArea(int[] height) {
        int max = -1;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            if(height[start] < height[end]){
                max = Math.max(max,height[start] * (end-start));
                start++;
            }else{
                max = Math.max(max, height[end] * (end-start));
                end--;
            }
        }
        return max;
    }
}
