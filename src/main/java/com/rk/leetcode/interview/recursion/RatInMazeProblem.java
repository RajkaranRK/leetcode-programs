package com.rk.leetcode.interview.recursion;

public class RatInMazeProblem {
    
    
    public static void main(String []args) {
        RatInMazeProblem ratInMazeProblem = new RatInMazeProblem();
        int [][]maze = ratInMazeProblem.getMaze();
        int [][]path = new int[maze.length][maze.length];
        
        System.out.println("Maze");
        ratInMazeProblem.printMatrix(maze, maze.length);
        
        System.out.println("Previous Path");
        ratInMazeProblem.printMatrix(path, path.length);
        
       
        ratInMazeProblem.isPathExists(maze, 0, 0, maze.length, path);
        System.out.println("After Path");
        ratInMazeProblem.printMatrix(path, path.length);
        
    }
    
    public void printMatrix(int[][]a,int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public int[][] getMaze(){
        return new int[][] {
            {1,1,1,0,0},
            {1,1,0,0,0,},
            {0,1,1,0,0},
            {0,0,1,1,0},
            {0,0,0,1,1}
        };
    }
    
    
    public boolean isPathExists(int maze[][], int x,int y,int n,int [][]path) {
        if(x==n-1 && y == n-1) {
            return true;
        }
        if(isSafe(maze, x, y, n)) {
            path[x][y] = 1;
            if(isPathExists(maze, x+1, y, n, path)) {
                return true;
            }
            if(isPathExists(maze, x, y+1, n, path)) {
                return true;
            }
            path[x][y] = 0;
            return false;
        }
        return false;
    }
    
    public boolean isSafe(int maze[][],int x,int y,int n) {
        return x < n && y<n && maze[x][y] == 1;
    }

}
