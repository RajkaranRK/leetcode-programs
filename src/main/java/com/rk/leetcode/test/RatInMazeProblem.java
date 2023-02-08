package com.rk.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class RatInMazeProblem {

    public static void main(String []args){
        RatInMazeProblem ratInMazeProblem = new RatInMazeProblem();
        int [][]maze = ratInMazeProblem.getMaze();
        int [][] visited = ratInMazeProblem.visited();
        List<String> paths = new ArrayList<>();
        ratInMazeProblem.solveMaze(maze,visited,0, 0,maze.length,"",paths);
        paths.forEach(System.out::println);
    }

    private void solveMaze(int maze[][],int [][]visited,int x,int y,int n, String path, List<String> paths){
        if(x == n-1 && y == n-1){
            paths.add(path);
            return;
        }
        if(x >= n || y >=n || x < 0 || y  < 0 || maze[x][y] == 0 || visited[x][y] == 1){
            return;
        }else{
            visited[x][y] = 1;
        }
        solveMaze(maze,visited,x+1,y,n,path+"D",paths);
        solveMaze(maze,visited,x-1,y,n,path+"U",paths);
        solveMaze(maze,visited,x,y+1,n,path+"R",paths);
        solveMaze(maze,visited,x,y-1,n,path+"L",paths);
        visited[x][y] = 0;
    }


    public int[][] getMaze(){
        return new int[][] {
                {1,1,1,0,0},
                {1,1,1,0,0,},
                {0,0,1,0,0},
                {0,0,1,1,0},
                {0,0,0,1,1}
        };
    }
 //DRDRDRDR
    private int[][] visited(){
        return new int[][] {
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };
    }


}
