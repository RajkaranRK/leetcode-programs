package com.rk.leetcode.interview;

//https://www.youtube.com/watch?v=1ZGJzvkcLsA - Explanation video 
public class SprialMatrixClockWise {
    
    
    public static void main(String []args) {
        
        int[][] matrix = new int [][] {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        
        printClockwiseSpiral(matrix);
        
    }
    
    
    private static void printClockwiseSpiral(int[][] matrix) {
        int top = 0;
        int down = matrix.length-1;
        int left =0;
        int right = matrix[0].length-1;
        int dir = 0;
        //possible - direction
        //0 -> means -> left -> right 
        //1 -> means -> top -> down;
        //2 -> right -> left
        //3 -> bottom -> top
        while(left <= right && top<=down) {
            if(dir == 0) {
                for(int i =left; i <= right; i++) {
                    System.out.print(matrix[top][i]+",");
                }
                top += 1;
            }
            else if(dir == 1) {
                for(int i=top; i <= down; i++) {
                    System.out.print(matrix[i][right]+",");
                }
                right -= 1;
            }else if(dir == 2) {
                for(int i = right; i >=left; i--) {
                    System.out.print(matrix[down][i]+",");
                }
                down -= 1;
            }else if(dir == 3) {
                for(int i =down; i>=top; i--) {
                    System.out.print(matrix[i][left]+",");
                }
                left+=1;
            }
            dir = (dir + 1) % 4;
        }
        
        
    }

}
