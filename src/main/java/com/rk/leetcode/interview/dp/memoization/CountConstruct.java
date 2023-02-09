package com.rk.leetcode.interview.dp.memoization;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

    public static void main(String[] args) {
        String[] words = new String[]{"ab","abc","def","abcd","cd","ef"};
        String targetWord = "abcdef";
        Map<String,Integer> memo = new HashMap<>();
        int count = countConstruct(targetWord,words,memo);
        System.out.println("Count "+count);
    }

    private static int countConstruct(String target, String[]words,Map<String,Integer> memo){
        if(memo.containsKey(target)){
            return memo.get(target);
        }
        if(target.length() == 0){
            return 1;
        }
        int count = 0;
        for(int i=0;i<words.length;i++){
            if(target.indexOf(words[i])==0){
                count += countConstruct(target.substring(words.length),words,memo);
            }
        }
        memo.put(target,count);
        return count;
    }
}
