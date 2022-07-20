package com.rk.leetcode.interview;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 */
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
