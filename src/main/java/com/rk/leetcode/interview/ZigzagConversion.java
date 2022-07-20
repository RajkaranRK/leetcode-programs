package com.rk.leetcode.interview;

public class ZigzagConversion {

    public static void main(String []args){
        ZigzagConversion conversion = new ZigzagConversion();
        String convertedStr = conversion.convert("PAYPALISHIRING",5);
        System.out.println("Converted String "+ convertedStr);
    }

    public String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i=0; i<numRows; i++){
            sb[i] = new StringBuffer();
        }
        int i = 0;
        int len = s.length();
        while(i<len){
            for(int k=0; k < numRows && i < len; k++,i++){
                sb[k].append(s.charAt(i));
            }
            for(int k=numRows-2; k>=1 && i < len; k--,i++){
                sb[k].append(s.charAt(i));
            }
        }
        for(int l=1; l<numRows; l++){
            sb[0].append(sb[l].toString());
        }
        return sb[0].toString();
    }
}
