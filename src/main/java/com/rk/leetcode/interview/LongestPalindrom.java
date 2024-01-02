package com.rk.leetcode.interview;


public class LongestPalindrom {

    public static void main(String []args){
        LongestPalindrom palindrom = new LongestPalindrom();
        String palindromStr = palindrom.longestPalindrome("babad");
        System.out.println("Palindrom string "+palindromStr);

        palindromStr = palindrom.longestPalindrome("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        System.out.println("Palindrom string "+palindromStr);
    }

    private  String longestPalindrome(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        int i = 0;
        String maxStr = "";
        while(i < str.length()){
            for(int j=str.length()-1; j > i; j--){
                if(str.charAt(i) == str.charAt(j)){
                    String source = str.substring(i,j+1);
                    if(source.length() > maxStr.length() && isPalindrome(source)){
                        maxStr = source;
                    }
                }
            }
            if(str.length() == maxStr.length()){
                break;
            }
            i++;
        }
        return maxStr;
    }

    private boolean isPalindrome(String str){
        for(int i = 0, j=str.length()-1; i<str.length()/2; i++, j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
