package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class PossibleSubString {

    public static void main(String []args){
        PossibleSubString possibleSubString = new PossibleSubString();
        List<String> subStrings = new ArrayList<>();
        possibleSubString.subSeq("ABC","",subStrings);
        System.out.println(subStrings);
    }


    public void subSeq(String s, String ans, List<String> subStrings){
        if(s.length()==0){
            subStrings.add(ans);
            return;
        }else{
            subSeq(s.substring(1),ans,subStrings);
            subSeq(s.substring(1),ans+s.charAt(0),subStrings);
        }
    }
}
