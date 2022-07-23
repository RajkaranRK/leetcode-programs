package com.rk.leetcode.interview.recursion;

public class ReplacePi {

    public static void main(String []args){
        ReplacePi replacePi = new ReplacePi();
        String finalStr = replacePi.replacePi("pippxxppiixipi");
        System.out.println(finalStr);
    }

    public String replacePi(String str){
        if(str == null || str.length()<2){
            return str;
        }
        if(str.charAt(0) == 'p' && str.charAt(1)=='i'){
            return "3.14"+replacePi(str.substring(2));
        }
        return str.charAt(0)+replacePi(str.substring(1));
    }
}
