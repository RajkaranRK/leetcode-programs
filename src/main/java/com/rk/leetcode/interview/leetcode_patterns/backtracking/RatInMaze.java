package com.rk.leetcode.interview.leetcode_patterns.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatInMaze {

    public static void main(String[] args) {
        int maze[][] = {
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        List<String> paths = new ArrayList<>();
        Map<String, Boolean> tracker = new HashMap<>();
        findPaths(maze, 0,0,"",paths,tracker);
        paths.forEach(System.out::println);
    }


    private static void findPaths(int [][]maze, int row, int col, String path, List<String> paths,Map<String,Boolean> tracker){
        String key = row + ":" + col;
        boolean isCovered = tracker.getOrDefault(key, false);
        if(row < 0 || col < 0 || row >= maze.length || col >= maze.length || isCovered || maze[row][col] == 0){
            return;
        }
        if(row == maze.length - 1 && col == maze.length - 1){
            paths.add(path);
        }
        tracker.put(key,true);
        findPaths(maze,row + 1, col,path + "D", paths, tracker);
        findPaths(maze,row - 1, col,path + "U", paths, tracker);
        findPaths(maze, row, col + 1,path + "R", paths, tracker);
        findPaths(maze,row, col - 1 ,path + "L", paths, tracker);
        tracker.put(key,false);
    }


}
