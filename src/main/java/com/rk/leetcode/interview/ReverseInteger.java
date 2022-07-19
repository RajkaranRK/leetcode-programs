package com.rk.leetcode.interview;

public class ReverseInteger {
    
    
    public static void main(String []args) {
        ReverseInteger reverse = new ReverseInteger();
        int value = reverse.reverse(1534236469);
        System.out.println(value);
       
    }
    
    
    public int reverse(int x) {
        if(x>(Math.pow(2,31)-1) || x < (-1 * Math.pow(2,31))){
            return 0;
        }
        long sum = 0;
        boolean isnegative = false;
        if(x < 0){
            x = x*-1;
            isnegative = true;
        }
        while(x > 0){
            sum = sum*10 + (x % 10);
            if(sum > Math.pow(2,31)-1) {
                sum = 0;
                break;
            }
            x = x / 10;
        }
        if(isnegative){
            return (int)sum * -1;
        }
        return (int)sum;
    }

}
