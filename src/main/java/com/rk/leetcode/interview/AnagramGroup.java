package com.rk.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramGroup {
    
    
    
    public static void main(String []args) {
        AnagramGroup anagramGroup = new AnagramGroup();
        
        
        String[]words = {"eat","tea","tan","ate","nat","bat"};
        
        List<List<String>> groups = anagramGroup.groupAnagrams(words);
        
        System.out.println(groups);
        
        
        System.out.println(anagramGroup.isAnagram("eat", "eta"));
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        if(strs.length == 1) {
            groups.add(Arrays.asList(strs[0]));
            return groups;
        }
        for(int i=0;i<strs.length;i++) {
            String first = strs[i];
            if(first == null) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(first);
            for(int j=i+1;j<strs.length; j++) {
                String second = strs[j];
                if(second == null) {
                    continue;
                }
                if(isAnagram(first, second)) {
                    group.add(second);
                    strs[j] = null;
                }
            }
            groups.add(group);
        }
        return groups;
    }
    
    
    public boolean isAnagram(String first, String second){
        if(first == null || second == null){
            return false;
        }
        if(first.length() == 0 && second.length() == 0){
            return true;
        }
        if(first.length() != second.length()){
            return false;
        }
        char ch = first.charAt(0);
        int index = second.indexOf(""+ch);
        if(index == -1){
            return false;
        }
        return isAnagram(first.substring(1), index < second.length() ? second.substring(0,index) + second.substring(index+1) : second.substring(0,index));
        
    }
    
}
