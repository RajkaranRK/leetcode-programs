package com.rk.leetcode.interview;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubString {
    
    
    public static void main(String []args) {
        String s = "abcabcdbb";
        LongestSubString subString = new LongestSubString();
        int length = subString.getLongestSubStringLength(s);
        System.out.println("Longest sub string length "+length);

        String str = subString.getLongestSubString(s);
        System.out.println("Longest subs-string "+str);
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


    public String getLongestSubString(String s){
        String maxStr = "";
        int maxLen = 0,i=0,j=0;
        Set<Character> charSet = new LinkedHashSet<>();
        char []arr = s.toCharArray();
        while( i < arr.length){
            if(!charSet.contains(arr[i])){
                charSet.add(arr[i]);
                if(maxLen < charSet.size()){
                    maxLen = charSet.size();
                    StringBuilder builder = new StringBuilder();
                    charSet.stream().forEach(ch -> builder.append(ch));
                    maxStr = builder.toString();
                }
                i++;
            }else{
                charSet.remove(arr[j++]);
            }
        }
        System.out.println("Max Length "+maxLen);
        return maxStr;
    }
    
    

}
