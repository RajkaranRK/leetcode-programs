package com.rk.leetcode.interview;

public class RomanToInteger {

    public static void main(String []args){
        RomanToInteger romanToInteger = new RomanToInteger();
        int roman = romanToInteger.romanToInt("MCMXCIV");
        System.out.println(roman);
    }

    public int romanToInt(String s) {
        int i = 0;
        int n = s.length();
        int sum = 0;
        while( i < n){
            char ch = s.charAt(i);
            int firstInt = getInt(ch);
            int secondInt = 0;
            if(i+1 < n){
                secondInt = getInt(s.charAt(i+1));
            }
            if(firstInt < secondInt){
                sum = sum + (secondInt - firstInt);
                i++;
            }else{
                sum = sum + firstInt;
            }
            i++;
        }
        return sum;
    }

    public int getInt(char x){
        switch (x){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
}
