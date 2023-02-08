package com.rk.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons)
 * is given below. Note that 1 does not map to any letters.
 *
 * 2 -> abc
 * 3 -> def
 * 4 -> ghi
 * 5 -> jkl
 * 6 -> mno
 * 7 -> pqrs
 * 8 -> tuv
 * 9 -> wxyz
 *
 * Exmaple :
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 */
public class PhoneLetterCombination {


    public static void main(String []args){
        List<String> sequences = new ArrayList<>();
        letterCombination("239","",0,sequences);
        sequences.forEach(System.out::println);
    }


    public static void letterCombination(String number,String sequence,int index, List<String> sequences){
        if(number.length() == index){
            sequences.add(sequence);
           return;
        }
        String word = digitMap(number.charAt(index));
        for(int i=0; i<word.length();i++) {
            letterCombination(number, sequence + word.charAt(i), index + 1, sequences);
        }
    }


    public static String digitMap(char ch){
        switch (ch){
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
