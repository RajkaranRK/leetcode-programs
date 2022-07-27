package com.rk.leetcode.interview;

public class Power {

    public static void main(String []args){
        Power power = new Power();
        double pow = power.myPow(2,Integer. MIN_VALUE);
        System.out.println(pow);
    }


    public double myPow(double x, int n) {
        if(n == 0 || x == 1 || x == -1){
            if(x==-1 && n % 2 == 1){
                return  -1;
            }
            return 1;
        }
        if(n<0){
            double pow =  n % 2 == 0 ? myPow(x*x,-(n/2)) : x*myPow(x*x,-(n/2));
            return 1/pow;
        }else{
            return n % 2 == 0 ? myPow(x*x,n/2): x * myPow(x*x,n/2);
        }
    }
}
