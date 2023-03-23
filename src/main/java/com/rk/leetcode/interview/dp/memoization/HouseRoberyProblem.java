package com.rk.leetcode.interview.dp.memoization;


/**
 * thief are not allowed to rob the adjacent house at a time
 * @author a13400388
 *
 */
public class HouseRoberyProblem {
    
    
    public static void main(String []args) {
        int arr[] = new int[] {9,9,8,9};
        int sum = maxMoney(arr,arr.length-1,1);
        int sum2 = maxMoney(arr, arr.length-2,0);
        sum = Math.max(sum, sum2);
        System.out.println(sum);
    }
    
    
    private static int maxMoney(int arr[], int index,int end) {
        if(index == end) {
            return arr[end];
        }
        if(index < end) {
            return 0;
        }
        int v1 = maxMoney(arr,index-1,end) ;
        int v2 = maxMoney(arr,index-2,end)+ arr[index];
        return Math.max(v1, v2);
    }

}
