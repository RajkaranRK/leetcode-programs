package com.rk.leetcode.interview;

import java.util.Stack;

public class ParantesisValidate {


    public static void main(String[]args){
        ParantesisValidate validate = new ParantesisValidate();
        System.out.println(validate.isValid("({{)"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '[' || ch == '{' || ch == '('){
                stack.push(ch);
            }else{
                char open = stack.pop();
                if(!isClosed(open,ch)) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid && stack.isEmpty();
    }


    public boolean isClosed(char open,char closed){
        switch (open){
            case '(':
                return closed==')';
            case '{':
                return closed == '}';
            case '[':
                return closed == ']';
            default:
                return false;
        }
    }
}
