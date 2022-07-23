package com.rk.leetcode.interview.recursion;

public class MoveAllXToEnd {


    public static void main(String []args){
        MoveAllXToEnd move = new MoveAllXToEnd();
        String finalStr = move.moveAllX("helxbrotxhxerx",'x');
        System.out.println(finalStr);
    }

    public String moveAllX(String str,char ch){
        if(str==null || str.length()==0){
            return str;
        }
        if(str.charAt(0) == ch){
            return moveAllX(str.substring(1),ch)+ch;
        }else{
            return str.charAt(0)+moveAllX(str.substring(1),ch);
        }
    }
}
