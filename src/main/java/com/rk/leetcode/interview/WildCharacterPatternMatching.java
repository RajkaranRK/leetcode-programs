package com.rk.leetcode.interview;

public class WildCharacterPatternMatching {
    
    
    public static void main(String []args) {
        WildCharacterPatternMatching patternMatching = new WildCharacterPatternMatching();
        boolean isMatch = patternMatching.isMatch("abcdef", "a?c*f");
        System.out.println(isMatch);
    }
    
    
    public boolean isMatch(String s, String p) {
        boolean T[][] = new boolean[s.length()+1][p.length()+1];
        for(int i=0; i<s.length();i++) {
            for(int j=0;j<p.length();j++) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    T[i][j] = true;
                }
            }
        }
        
        return false;
        
    }

}
