package com.rk.leetcode.interview;


public class LongestPalindrom {

    public static void main(String []args){
        LongestPalindrom palindrom = new LongestPalindrom();
        String palindromStr = palindrom.longestPalindrome("babad");
        System.out.println("Palindrom string "+palindromStr);

        palindromStr = palindrom.longestPalindrome("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        System.out.println("Palindrom string "+palindromStr);
    }

    public String longestPalindrome(String s) {
        String maxStr = "";
        int i =0;
        while(i<s.length()){
            char startCh = s.charAt(i);
            for(int j= s.length()-1; j >= i; j--){
                if(startCh == s.charAt(j)){
                    String str = s.substring(i,j+1);
                    if(isPalindrom(str) && str.length() > maxStr.length()){
                        maxStr = str;
                    }
                }
            }
            if(maxStr.length() == s.length()){
                break;
            }
            i++;
        }
        return maxStr;
    }

    private boolean isPalindrom(String str){
        boolean isPalindrom = true;
        for(int i=0,j=str.length()-1; i<str.length()/2;i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                isPalindrom = false;
                break;
            }
        }
        return isPalindrom;
    }
}
