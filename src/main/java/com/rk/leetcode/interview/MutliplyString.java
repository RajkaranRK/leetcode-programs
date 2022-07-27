package com.rk.leetcode.interview;

public class MutliplyString {
    
    
    
    public static void main(String []args) {
        MutliplyString mulMutliplyString = new MutliplyString();
        System.out.print(mulMutliplyString.multiply("122", "12"));
    }
    
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        String result = "";
        if(num1.length() >= num2.length()){
            result = perform(num1,num2);
        }else{
            result = perform(num2,num1);
        }
        
        return result;
    }
    
    
    public String perform(String str1, String str2){
        String sum = "";
        for(int i=0; i< str2.length() ;i++) {
            sum = "";
            int num2 = str2.charAt(i) - '0';
            int carry = 0;
            String result = "";
            for(int j=i; j<str1.length();j++) {
                int num1 = str1.charAt(j) - '0';
                int multiply = num1 * num2 + carry;
                result =  result+multiply;
                if(sum.equals("")) {
                    sum = result;
                }else {
                    sum = addString(sum,result, i);
                }
            }
        }
        return sum;
    }
    
    public String addString(String str1, String str2,int index) {
        int counter = 0 ;
        int carry = 0 ;
        String sumStr = "";
        for(int i= str2.length()-1; i>=0; i--) {
            int num1 = str2.charAt(i) - '0';
            int num2 = 0;
            if(str1.length()-1 == i) {
                num2 = str1.charAt(i) - '0';
            }
            int sum = num1 + num2 + carry;
            carry = carry / 10;
            sum = sum % 10;
            counter++;
            sumStr = sumStr + sum;
        }
        return sumStr;
        
    }
}
