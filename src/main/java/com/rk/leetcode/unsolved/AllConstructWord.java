package com.rk.leetcode.unsolved;

import java.util.ArrayList;
import java.util.List;


public class AllConstructWord {
    
    public static void main(String []args) {
        AllConstructWord allConstructWord = new AllConstructWord();
        List<List<String>> words  = allConstructWord.allContruct("abcdef" 
                , new String[] {"ab","abc","cd","def","abcd","ef"});
        
        words.stream().forEach(System.out::println);
    }
    
    
    public List<List<String>> allContruct(String target, String[]arr){
        if(target.length() == 0) {
            List<String> list = new ArrayList<>();
            List<List<String>> myList = new ArrayList<>();
            myList.add(list);
            return myList;
        }
        List<List<String>> actualWords = new ArrayList<>();
        for(int i=0; i < arr.length; i++) {
            String word = arr[i];
            if(target.indexOf(word)==0) {
                List<List<String>> words = allContruct(target.substring(word.length()),arr);
                addWordBefore(word,words,actualWords);
            }
        }
        return actualWords;
    }
    
    
    public void addWordBefore(String word, List<List<String>> words, List<List<String>> actualWords) {
        for(int i=0;i<words.size();i++) {
            words.get(i).add(0, word);
            actualWords.add(new ArrayList<>(words.get(i)));
        }
    }

}
