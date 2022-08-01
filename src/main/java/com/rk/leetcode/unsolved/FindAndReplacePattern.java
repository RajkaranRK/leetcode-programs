package com.rk.leetcode.unsolved;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {
    
    
    public static void main(String []args) {
        FindAndReplacePattern findAndReplacePattern = new FindAndReplacePattern();
    }
    
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        List<String> list = new ArrayList<>();
        
        int []patternChCount = charCount(pattern);
        for(int i=0; i<words.length; i++) {
            if(words[i].length() < pattern.length()) {
                continue;
            }
            int wordChCount[] = charCount(words[i]);
            if(isMatch(patternChCount,wordChCount)) {
                list.add(words[i]);
            }
        }
        return list;
        
    }
    
    
    public boolean isMatch(int[]pattern, int word[]) {
        int i=0;
        while(i<pattern.length && pattern[i] != 0) {
            if(word[i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
    
    
    public int[] charCount(String pattern) {
        if(pattern.length()==0) {
            return new int[] {};
        }
        int[] arr = new int[pattern.length()];
        int k = 0;
        int count = 1;
        char prev = pattern.charAt(0);
        for(int i=1; i<pattern.length(); i++) {
            if(prev == pattern.charAt(i)) {
                count++;
            }else {
                arr[k++] = count;
                prev = pattern.charAt(i);
                count = 1;
            }
        }
        arr[k++] = count;
        return arr;
    }
}
