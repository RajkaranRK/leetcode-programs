package com.rk.leetcode.interview;

public class WildCharacterPatternMatching {
    
    
    public static void main(String []args) {
        WildCharacterPatternMatching patternMatching = new WildCharacterPatternMatching();
        boolean isMatch = patternMatching.isMatch("aa", "*");
        System.out.println(isMatch);
    }
    
    
    public boolean isMatch(String s, String p) {
        boolean T[][] = new boolean[s.length()+1][p.length()+1];
        T[0][0] = true;
        
        //filling the first condition
        for(int i=0 ;i<s.length();i++){
            T[i+1][0] = false;
        }
        
        if(p.length() >0){
            char prev = p.charAt(0);
            for(int j=0; j< p.length(); j++) {
                if(p.charAt(j)=='*' && prev == p.charAt(j)) {
                    T[0][j+1] = true;
                }else {
                    T[0][j+1] = false;
                    break;
                }
                prev = p.charAt(j);
            }
        }
        
        
        for(int i=0;i<s.length(); i++){
            char sch = s.charAt(i);
            for(int j=0; j<p.length(); j++){
                char pch = p.charAt(j);
                if(sch == pch || pch == '?'){
                    T[i+1][j+1] = T[i][j];
                }else if(pch == '*'){
                    T[i+1][j+1] = T[i + 1][j] || T[i][j+1];
                }else{
                    T[i+1][j+1] = false;
                }
            }
        }
        return T[s.length()][p.length()];
    }

}
