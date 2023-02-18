package com.rk.leetcode.interview;


public class CountAndSay {


    public static void main(String []args){
        int n = 4;
        String sayWord = say(n);
        System.out.println(sayWord);
    }


    private static String say(int n){
        if(n == 1){
            return "1";
        }if(n==2){
            return "11";
        }
        String digitStr = say(n-1);
        return count(digitStr);
    }


    private static String count(String digits){
        char[] arr = digits.toCharArray();
        StringBuilder builder = new StringBuilder();
        int count = 1;
        int i = 0;
        int prev = arr[i] - '0';
        i++;
        while( i < arr.length){
            if(prev == arr[i]-'0'){
                count++;
            }else{
                builder.append(count).append(prev);
                prev = arr[i] - '0';
                count = 1;
            }
            i++;
        }
        builder.append(count).append(prev);
        return builder.toString();
    }
}
