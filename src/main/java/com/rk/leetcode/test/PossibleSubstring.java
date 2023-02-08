package com.rk.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class PossibleSubstring {


    public static void main(String []args){
        List<String> subsets = new ArrayList<>();
        findAllSubset("ABC","",0,subsets);
        subsets.forEach(System.out::println);
    }


    public static void findAllSubset(String source,String subset, int index, List<String> subsets){
        if(index == source.length()){
            subsets.add(subset);
            return;
        }
        findAllSubset(source,subset,index+1,subsets);
        findAllSubset(source,subset+source.charAt(index),index+1,subsets);
    }
}
