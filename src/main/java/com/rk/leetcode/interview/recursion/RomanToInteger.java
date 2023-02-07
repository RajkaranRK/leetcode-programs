package com.rk.leetcode.interview.recursion;

public class RomanToInteger {
    
    public static void main(String []args) {
        RomanToInteger romanToInt = new RomanToInteger();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
    }
    
    public int romanToInt(String s){
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return romanMap(s.charAt(0));
        }
        int first = romanMap(s.charAt(0));
        int second = romanMap(s.charAt(1));
        if((first == 1 && (second == 5 || second == 10))
         || (first == 10 && (second == 50 || second == 100))
         || (first == 100 && (second == 500 || second == 1000))
         ){
             int sum = second - first;
             return sum + romanToInt(s.substring(2));
         }else{
             return first + romanToInt(s.substring(1));
         }
    }


    private int romanMap(char ch){
        switch(ch){
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
            default:
            return -1 ;
        }
    }

}
