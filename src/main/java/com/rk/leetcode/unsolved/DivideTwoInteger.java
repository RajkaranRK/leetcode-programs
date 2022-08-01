package com.rk.leetcode.unsolved;

public class DivideTwoInteger {
    
    public static void main(String []args) {
        DivideTwoInteger divideTwoInteger = new DivideTwoInteger();
        int result = divideTwoInteger.divide(12, 3);
        System.out.println("Result "+result);
        
        
        System.out.println("Result "+result);
    }
    
    
    public int divide(int dividend, int divisor) {
        
        boolean sign = dividend >=0 && divisor>=0 ? true: false;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);        
        int result = 0;
        
        while(dividend - divisor >= 0) {
            int count = 0;
            while(dividend - ((divisor << 1) << count) >= 0) {
                count++;
            }
            dividend -= divisor << count;
            result += 1<<count;
        }
        return sign ? result: -result;
    }
    
    
    public int divide2(int dividend, int divisor) {    
        int result = 0;
        int temp = 0;
        boolean sign = dividend >=0 == divisor >=0 ? true : false;
        boolean isnegativeMax=false;
        if(dividend <= Integer.MIN_VALUE){
            isnegativeMax = true;
            dividend = dividend + 1;
            if(divisor==1){
                return Integer.MIN_VALUE;
            }if(divisor == -1){
                return Integer.MAX_VALUE;
            }
        }else if(dividend >= Integer.MAX_VALUE) {
            if(divisor==1){
                return Integer.MAX_VALUE;
            }else if(divisor== -1){
                return Integer.MIN_VALUE;
            }
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend >= divisor) {
            int count = 0;
            temp = divisor;
            while(dividend-(temp<<1) >=0 ) {
                count++;
                temp<<=1;
            }
            dividend -= temp;
            if(isnegativeMax){
                isnegativeMax = false;
                dividend += 1;
            }
            result = result + (1<<count);
        }
        return sign ? result:-result;
    }


}
