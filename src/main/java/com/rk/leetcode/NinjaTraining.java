package com.rk.leetcode;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NinjaTraining {


    public static void main(String[] args) {
        int points[][] ={
            {10, 50, 1},
            {5, 100, 11},
            {20, 1, 30}
        };
        int N = 3;
        log.info("Maximum point would be achieved : {}",maxPointsOfNinjaTraining(points,N-1,3));
    }


    private static int maxPointsOfNinjaTraining(int [][]points, int day, int last){

        //base case
        if(day == 0){
            int max = Integer.MIN_VALUE;
            for (int i =0; i < points[0].length; i++){
                if(i != last){
                    max = Math.max(max,points[0][i]);
                }
            }
            return max;
        }

        //check for other days apart from the last day
        int max = Integer.MIN_VALUE;
        for (int i =0 ; i < points[0].length; i++){
            if(i != last){
                max = Math.max(max, points[day][i] + maxPointsOfNinjaTraining(points,day-1, i));
            }
        }
        return max;
    }
}
