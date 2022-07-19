package com.rk.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    
    
    public static void main(String []args) {
        String s = "abcabcdbb";
        LongestSubString subString = new LongestSubString();
        int length = subString.getLongestSubStringLength(s);
        System.out.println("Longest sub string length "+length);
        
    }
    
    
    public int getLongestSubStringLength(String s) {
        int max = 0;
        int end = 0;
        int start = 0;
        Set<Character> charSet = new HashSet<>();
        
        while(end < s.length()) {
            Character ch = s.charAt(end);
            if(!charSet.contains(ch)) {
                charSet.add(ch);
                end++;
                max = Math.max(charSet.size(), max);
            }else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }
    
    

}
