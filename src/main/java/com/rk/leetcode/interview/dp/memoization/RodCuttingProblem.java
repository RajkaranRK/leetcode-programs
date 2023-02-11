package com.rk.leetcode.interview.dp.memoization;

public class RodCuttingProblem {

    public static void main(String []args){
        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem();
        int []rod = new int[] {1,2,3,4,5,6,7,8};
        int []price = new int[] {1,5,8,9,10,17,17,20};
        int max = rodCuttingProblem.findMaxProfit(rod,price,0,8);
        System.out.println("Maximum profit "+max);
    }


    private int findMaxProfit(int []rod,int []price, int profit,int rodLength){
        if(rodLength == 0){
            return  profit;
        }
        if(rodLength < 0){
            return 0;
        }
        int max = 0;
        for(int i=0; i<rod.length;i++){
            int p = findMaxProfit(rod,price,profit+price[i],rodLength-rod[i]);
            if( p > max){
                max = p;
            }
        }
        return max;
    }
}
