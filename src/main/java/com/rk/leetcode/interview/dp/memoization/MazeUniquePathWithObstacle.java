package com.rk.leetcode.interview.dp.memoization;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MazeUniquePathWithObstacle {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        log.info("Total path exists in the maze with obstacle :{}", mazePath(grid,m,n));
    }


    private static int mazePath(int [][]maze, int m,int n){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0 || maze[m][n] == 1){
            return 0;
        }
        return mazePath(maze,m - 1, n) + mazePath(maze, m , n-1 );
    }
}
