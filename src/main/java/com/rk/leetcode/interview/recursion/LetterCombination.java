package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination {

    public static void main(String[] args) {
        LetterCombination combination = new LetterCombination();
        List<String> combinations = combination.letterCombinations("234");
        System.out.println(combinations);
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        keyPad(digits, "", combinations);
        return combinations;
    }

    public void keyPad(String s, String ans, List<String> combinations){
        if(s.length() == 0){
            combinations.add(ans);
            return;
        }
        char ch = s.charAt(0);
        String code = letterCombination(ch);
        String ros = s.substring(1);
        for(int i=0 ;i < code.length(); i++){
            keyPad(ros,ans+code.charAt(i),combinations);
        }
    }
    public String letterCombination(char x){
        switch (x){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }
}
