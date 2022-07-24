package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class PossibleSubStringWithASCII {


    public static void main(String []args){
        PossibleSubStringWithASCII ascii = new PossibleSubStringWithASCII();
        List<String> list = new ArrayList<>();
        ascii.subSeq("AB","",list);
        System.out.println(list);
    }

    public void subSeq(String s, String ans, List<String> list){
        if(s.length() == 0){
            list.add(ans);
            return;
        }
        subSeq(s.substring(1),ans,list);
        subSeq(s.substring(1),ans+s.charAt(0),list);
        int code = s.charAt(0);
        subSeq(s.substring(1),ans+code,list);
    }
}
