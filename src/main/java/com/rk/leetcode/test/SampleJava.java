package com.rk.leetcode.test;

import java.util.regex.Pattern;

public class SampleJava {
    
    private static final String PASS_REGEX = "[[a-z]+[A-Z]+[0-9]+]{8,}";
    
    
    public static void main(String []args) {
        System.out.println(isValidPassword("aaAaeeee"));
       
    }
    
    public static boolean isValidPassword(String password) {
        return Pattern.matches(PASS_REGEX, password);
    }

    //"^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
}
