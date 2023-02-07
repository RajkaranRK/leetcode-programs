package com.rk.leetcode.interview;

public class StringToInteger {
    public static void main(String []args){
        StringToInteger toInteger = new StringToInteger();
        int number = toInteger.myAtoi("-91283472332");
        System.out.println("number "+number);
    }
    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if(s.length() == 0){
            return 0;
        }
        int ans = 0;
        int i = 0;
        boolean overflow = false;
        if(s.charAt(i)=='-' || s.charAt(i) == '+'){
            i++;
        }
        while(i < n){
            if(s.charAt(i) >= 48 && s.charAt(i)<=57){
                int newAns = ans * 10 + s.charAt(i++) - '0';
                if(Integer.MAX_VALUE/10 < ans || newAns < ans){
                    overflow = true;
                    break;
                }
                ans = newAns;
            }else{
                break;
            }
        }
        if(overflow){
            return s.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return s.charAt(0) == '-' ? ans * -1 : ans;
    }


    public static int convertToInt(String str){
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        int i = 0;
        if(str.charAt(i) == '-' || str.charAt(i) == '+'){
            i++;
        }
        int ans = 0;
        boolean overflow = false;
        while(i < str.length()){
            if(str.charAt(i) >= 48 && str.charAt(i)<=57){
                int newAns = ans*10 + (str.charAt(i) - '0');
                if(Integer.MAX_VALUE /  10 < ans || newAns < ans){
                    overflow = true;
                    break;
                }
                ans = newAns;
                i++;
            }else{
                break;
            }
        }
        if(overflow){
            return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return str.charAt(0) == '-' ? ans* -1 : ans;
    }
}
