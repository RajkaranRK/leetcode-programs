package com.rk.leetcode.test;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static void main(String[] args) {
        String target = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String words[] = new String[] {"e","ee","eeeeeeeee","eeeeeeeeeeeeeee","eeeeeeeeeeeeeeeeeeee"};
        Map<String,Boolean> memo = new HashMap<>();
        boolean isPossible = canConstruct(target, words,memo);
        System.out.println(isPossible ? "Yes It's possible" : "No It's not possible");
    }


    private static boolean canConstruct(String target,String []words,Map<String,Boolean> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target.length() == 0){
            return true;
        }
        for(int i = 0;i < words.length; i++){
            if(target.indexOf(words[i]) == 0){
                if(canConstruct(target.substring(words[i].length()),words,memo)){
                    memo.put(target,true);
                    return true;
                }
            }
        }
        memo.put(target,false);
        return false;
    }
}
