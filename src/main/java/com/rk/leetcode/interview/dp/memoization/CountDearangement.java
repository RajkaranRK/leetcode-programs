package com.rk.leetcode.interview.dp.memoization;

/**
 * [0,1,2] -> [1,2,0], [2,0,1]
 *
 * find number of de-arangement would be possible to arrange the element
 * so that no such element will comes to it's place
 */
public class CountDearangement {

    public static void main(String[] args) {
        System.out.println(count(4));
    }

    public static int count(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1; //[0,1] -> [1,0]
        }
        return (n-1) * (count(n-1) + count(n-2)); // count(n-2) -> when the number is swap //count(n-1) when i haven't swap the number only number place
    }
}
