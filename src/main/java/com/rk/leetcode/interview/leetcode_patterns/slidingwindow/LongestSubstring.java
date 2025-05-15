package com.rk.leetcode.interview.leetcode_patterns.slidingwindow;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class LongestSubstring {

    public static void main(String[] args) {
        String str = "abcabcdbb";
        log.info("Longest substring length :{}",longestSubstring(str));
    }


    private static int longestSubstring(String str){
        int count = 0;
        int i =0;
        int j = 0;
        Set<Character> charSet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        while(i < str.length()){
            char ch = str.charAt(i);
            if(!charSet.contains(ch)){
                charSet.add(ch);
                i++;
                max = Math.max(charSet.size(),max);
            }else{
                charSet.remove(str.charAt(j));
                j++;
            }
        }
        return max;
    }
}
