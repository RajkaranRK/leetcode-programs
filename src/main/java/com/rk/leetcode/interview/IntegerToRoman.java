package com.rk.leetcode.interview;

public class IntegerToRoman {
    
    
    public static void main(String []args) {
        IntegerToRoman intToRoman = new IntegerToRoman();
        String roman = intToRoman.intToRoman(58);
        System.out.println(roman);
    }
    
    
    public String intToRoman(int num) {
        String roman = "";
        while(num > 0){
            if(num >= 1000){
                roman += 'M';
                num -= 1000;
            }else if(num < 1000 && num >=500){
                roman += 'D';
                num -= 500;
            }else if(num < 500 && num >= 100){
                roman += 'C';
                num -= 100;
            }else if(num < 100 && num >= 50){
                roman += 'L';
                num -= 50;
            }else if(num < 50 && num >=10){
                roman += 'X';
                num -= 10;
            }else if(num < 10 && num >=9) {
                roman += "IX";
                num -= 9;
            }else if(num < 9 && num >=5){
                roman += "V";
                num -= 5;
            }else if(num < 5  && num >=1){
                if(num == 4){
                    roman += "IV";
                    num -= 4;
                }else if(num >=1 && num <= 3) {
                    roman += "I";
                    num -= 1; 
                }
            }
        }
        return roman;
    }

}
