package com.rk.leetcode.interview.recursion;


/**
 * This program will remove only the adjacent duplicate char
 */
public class RemoveRepeatedCharacter {

    public static void main(String []args){
        RemoveRepeatedCharacter removeRepeatedCharacter = new RemoveRepeatedCharacter();
        String str = removeRepeatedCharacter.removeRepeatedChar("aaaaabbbccfcdde","");
        System.out.println(str);
    }


    public String removeRepeatedChar(String str,String unique){
        if(str==null || str.length()<=1){
            return str;
        }else if(str.charAt(0)==str.charAt(1)){
            return removeRepeatedChar(str.substring(1),unique);
        }else{
            return str.charAt(0)+removeRepeatedChar(str.substring(1),"");
        }
    }
}
