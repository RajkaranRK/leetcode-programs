package com.rk.leetcode.interview.dp.tabulation;


/**
 * Dynamic programming approach using Tabulation
 * @author RajKaran
 *
 */
public class FibonaciSeries {
    
    public static void main(String []args) {
        FibonaciSeries fibonaciSeries = new FibonaciSeries();
        System.out.println(fibonaciSeries.fib(6));
        
    }
    
    
    public int fib(int n) {
        if(n <=0) {
            return n;
        }
        int fib[] = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=1;i<=n;i++) {
            if(i+1 <= n) {
                fib[i+1] = fib[i+1] + fib[i];
            }
            if(i+2 <= n) {
                fib[i+2] = fib[i+2] + fib[i];
            }
        }
        return fib[n];
    }

}
