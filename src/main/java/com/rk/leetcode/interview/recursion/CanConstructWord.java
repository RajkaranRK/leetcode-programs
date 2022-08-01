package com.rk.leetcode.interview.recursion;

import java.util.HashMap;
import java.util.Map;

public class CanConstructWord {
    
    public static void main(String []args) {
        
        CanConstructWord canConstructWord = new CanConstructWord();
        boolean canConstruct  = canConstructWord.canConstruct("abcdef" 
                , new String[] {"ab","abc","cd","def","abcd"},new HashMap<>());
        System.out.println(canConstruct);
        
    }
    
    
    public boolean canConstruct(String targetWord,String []words, Map<String,Boolean> memo) {
        if(memo.containsKey(targetWord)) {
            return memo.get(targetWord);
        }
        if(targetWord.length() == 0) {
            return true;
        }
        for(int i=0; i<words.length;i++) {
            int index = targetWord.indexOf(words[i]);
            if(index == 0 && canConstruct(targetWord.substring(words[i].length()), words,memo)) {
                memo.put(targetWord, true);
                return true;
            }
        }
        memo.put(targetWord, false);
        return false;
    }

}
