package com.rk.leetcode.interview;

public class MutliplyString {
    
    
    
    public static void main(String []args) {
        MutliplyString mulMutliplyString = new MutliplyString();
        String result = mulMutliplyString.multiply("498828660196", "840477629533");
        System.out.print(result);
    }
   
    
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        if(num1.equals("1")) {
            return num2;
        }
        if(num2.equals("1")) {
            return num1;
        }
        int m = num1.length();
        int n = num2.length();
        int arr[] = new int[m+n];
        
        for(int i= m-1; i>=0;i--) {
            for(int j = n - 1; j>=0; j--) {
                int product = (num1.charAt(i)- '0') * (num2.charAt(j)-'0');
                product = product + arr[i+j+1];
                arr[i+j+1] = product % 10;
                arr[i+j] = arr[i+j]+product / 10;
            }
        }
        
        StringBuilder builer = new StringBuilder();
        boolean flag = true;
        for(int i=0;i<arr.length;i++) {
            if(flag && arr[i] == 0){
                continue;
            }
            flag = false;
            builer.append(arr[i]);
        }
        return builer.toString();
    }
    
}
