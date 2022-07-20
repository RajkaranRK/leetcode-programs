package com.rk.leetcode.interview;

public class RegularExpressionMatch {

    public boolean isMatch(String s, String p) {
        if(s.equals(p) || p.equals(".*")){
            return true;
        }
        int j = 0;
        for(int i=0; i<s.length();){
            if(p.charAt(j) == '.'){

            }
        }

        return false;
    }
}
