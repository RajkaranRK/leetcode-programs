package com.rk.leetcode.test;

public class CommonPrefix {

    public static void main(String []args){

        String words[] = new String[]{"flower","flow","flight"};
        String prefix = "";
        if(words.length > 0){
            prefix = commonPrefix(words,words[0],1);
        }
        System.out.println("Prefix="+prefix);

        System.out.println("*****************************");
        System.out.println("Finding Common prefix from another method");
        prefix = findCommonPrefix(words);
       System.out.println("Common Prefix : "+ prefix);
    }



    public static String findCommonPrefix(String []args){
        if(args.length == 0){
            return  "";
        }
        if(args.length == 1){
            return  args[0];
        }
        String prefix = args[0];
        for(int i = 1; i<args.length; i++){
            while(args[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length() - 1);
                if(prefix.equals("")){
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String commonPrefix(String []args, String commonPrefix, int index){
        if(args.length == index){
            return commonPrefix;
        }
        commonPrefix = findCommonPrefix(commonPrefix.toCharArray(),args[index].toCharArray());
        commonPrefix = commonPrefix(args,commonPrefix,index+1);
        return commonPrefix;
    }


    private static String findCommonPrefix(char arr1[], char[]arr2){
        int i =0;
        int j =0;
        String prefix = "";
        while(i <= j && i < arr1.length && j < arr2.length){
            if(arr1[i] != arr2[j]){
                break;
            }
            prefix += arr1[i];
            i++;
            j++;
        }
        return prefix;
    }
}
