package com.rk.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LetterCombination {

    public static void main(String []args){
        LetterCombination combination = new LetterCombination();
        List<String> combinations = combination.letterCombinations("234");
        System.out.println(combinations);
    }

    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> mapping = new ArrayList<>();
        for(int i =0; i< chars.length; i++){
            mapping.add(letterCombination(chars[i]));
        }
        List<String> combinations = new ArrayList<>();
        for(int i=0; i<mapping.get(0).length(); i++){
            List<String> list = new ArrayList<>();
            char ch = mapping.get(0).charAt(i);
            for(int j=1; j<mapping.size();j++) {
                    String word = mapping.get(j);
                    for (int k = 0; k < word.length(); k++) {
                        if(!list.isEmpty() && list.size()>k){
                            list.set(k,list.get(k)+word.charAt(k));
                        }else{
                            list.add(k,""+ch+word.charAt(k));
                        }
                    }
                }
                combinations.addAll(list);
            }
        return combinations;
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
