package com.rk.leetcode.interview.leetcode_patterns.binarysearch;

import lombok.extern.slf4j.Slf4j;

/**
 * You are given an m x n 2-D integer array matrix and an integer target.
 *
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 *
 * Can you write a solution that runs in O(log(m * n)) time?
 */
@Slf4j
public class SearchIn2DMatrix {


    public static void main(String[] args) {
        int [][]matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 3;
        log.info("target :{} found in matrix :{}",target,searchMatrix(matrix,target));

        log.info("target :{} found in 2d-matrix : {}",target,searchIn2DMatrix(matrix,target));
    }


    /**
     * in this approach i'm treating the whole matrix a m*n 1D array
     * and row and col is finding based on divide and modulo operation i.e. (/,%) respectively
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = (matrix.length * matrix[0].length) - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            log.info("mid :{},row:{},col:{}",mid,row,col);
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }


    public static boolean searchIn2DMatrix(int [][]matrix, int target){
        int top = 0;
        int n = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        while( top <= bottom){
            int mid = (top+bottom) / 2;
            if(target > matrix[mid][n]){
                top = mid + 1; //id target is greater then last element then it's lies in below array
            }else if(target < matrix[mid][0]){
                bottom = bottom - 1; //if target smaller then the first element then it's lies on above array
            }else{
                //target is not either bigger then last element and not smaller then first element
                // that means either it should be in this current row or not at all
                int row = mid; //row is already known
                //now i have to find the column only
                int left = 0;
                int right = n;
                while(left <= right){
                    int col = (left + right) / 2;
                    if(matrix[row][col] == target){
                        return true;
                    }
                    if(matrix[row][col] > target){
                        right = col - 1;
                    }else{
                        left = col + 1;
                    }
                }
            }
        }
        return false;
    }

}
