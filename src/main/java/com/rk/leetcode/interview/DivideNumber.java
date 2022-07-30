package com.rk.leetcode.interview;

public class DivideNumber {


    public static void main(String []args){
        DivideNumber divideNumber = new DivideNumber();
        int result = divideNumber.divide(15,3);
        System.out.println("result="+result);
        System.out.println(1<<31);
    }

    public int divide(int dividend, int divisor) {
        int result = 0;
        int temp = 0;
        boolean sign = dividend >=0 == divisor >=0 ? true : false;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return  Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == 1) return  Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == -1) return Integer.MIN_VALUE;
        if(dividend == Integer.MAX_VALUE && divisor == 1) return  Integer.MAX_VALUE;
        if(divisor == Integer.MIN_VALUE && dividend == Integer.MAX_VALUE) return 0;
        if(divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE) return 1;
        if(divisor == Integer.MAX_VALUE && dividend == Integer.MAX_VALUE) return 1;
        if(divisor == Integer.MAX_VALUE && dividend == Integer.MIN_VALUE) return -1;
        if(dividend >=0 && dividend<Integer.MAX_VALUE) {
            if((divisor>0 && divisor>dividend) || (divisor<0 && -divisor>dividend)){
                return 0;
            }
        }
        while(dividend >= divisor) {
            int count = 0;
            temp = divisor;
            while(dividend-(temp<<1) >=0 ) {
                count++;
                temp<<=1;
            }
            dividend -= temp;
            result = result + (1<<count);
        }
        return sign ? result:-result;
    }
}
