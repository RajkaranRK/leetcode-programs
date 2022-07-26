package com.rk.leetcode.interview;


/**
 * There is a robot on an m x n grid.
 * The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */
public class FindUniquePath {

    public static void main(String []args){
        FindUniquePath uniquePath = new FindUniquePath();
        int paths = uniquePath.uniquePaths(3,7);
        System.out.println("Total path Exists "+paths);
    }
    public int uniquePaths(int m, int n) {
        int cal[][] = new int[m+1][n+1];
        return findPath(1,1,m,n,cal);
    }

    public int findPath(int x,  int y, int m,int n,int[][]cal){
        if(x==m && y == n){
            return 1;
        }
        int l = 0;
        int o = 0;

        if(x<m){
            if(cal[x+1][y]!=0){
                l= cal[x+1][y];
            }else{
                l = findPath(x+1,y,m,n,cal);
                cal[x+1][y] = l;
            }
        }
        if(y<n){
            if(cal[x][y+1] != 0){
                o = cal[x][y+1];
            }else{
                o = findPath(x,y+1,m,n,cal);
                cal[x][y+1] = o;
            }
        }
        return l+o;
    }
}
