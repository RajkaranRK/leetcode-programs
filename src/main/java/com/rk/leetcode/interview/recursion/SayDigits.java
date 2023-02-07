package com.rk.leetcode.interview.recursion;

public class SayDigits {

    public static void main(String []args){
        sayDigits(247);
    }

    public static void sayDigits(int n){
        if(n==0){
            return;
        }
        sayDigits(n/10);
        System.out.print(word(n%10) +" ");
    }

    public static String word(int n){
        switch (n){
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 0:
                return "Zero";
            default:
                return "";
        }
    }
}

//ramchandra121285
