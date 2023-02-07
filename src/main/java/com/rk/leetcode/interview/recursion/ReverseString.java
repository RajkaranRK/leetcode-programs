package com.rk.leetcode.interview.recursion;

public class ReverseString {

    public static void main(String[] args) {
        String name = "Rajkaran";
        System.out.println(reverse(name));

        String name2 = "abba";
        System.out.println(isPalindrom(name2,0,name2.length() - 1));

        System.out.println(isPalindrom(name,0,name.length() - 1 ));
    }

    private static String reverse(String str){
        if(str.length() == 0){
            return "";
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    private static boolean isPalindrom(String str, int start,int end){
        if(start  > end){
            return true;
        }
        if(str.charAt(start) != str.charAt(end)){
            return false;
        }
        return isPalindrom(str,start+1,end -1);
    }
}
