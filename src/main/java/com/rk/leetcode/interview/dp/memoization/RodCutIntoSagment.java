package com.rk.leetcode.interview.dp.memoization;

public class RodCutIntoSagment {
    
    /**
     * You are given an integer ‘N’ denoting the length of the rod. 
     * You need to determine the maximum number of segments 
     * you can make of this rod provided that each segment should be of the length 'X', 'Y', or 'Z'.
     * @param args
     */
    public static void main(String []args) {
        int n = 7;
        int x = 2,y=4,z=3;
        int max = cutSagments(n, x, y, z);
        System.out.println(max);
    }
    
    private static int cutSagments(int n,int x,int y,int z) {
        if(n==0) {
            return 0;
        }
        if(n < 0) {
            return Integer.MIN_VALUE;
        }
        int x1 = cutSagments(n-x,x,y,z);
        int y1 = cutSagments(n-y, x,y, z);
        int z1 = cutSagments(n-z,x,y,z);
        if(x1 > y1 && x1 > z1) {
            return x1+1;
        }else if(y1 > x1 && y1 > z1) {
            return y1+1;
        }else {
            return z1 + 1;
        }
    }

}
