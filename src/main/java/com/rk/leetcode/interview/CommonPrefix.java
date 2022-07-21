package com.rk.leetcode.interview;

public class CommonPrefix {

    public static void main(String []args){
        CommonPrefix commonPrefix = new CommonPrefix();
        String prefix = commonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println("Common Prefix "+prefix);
    }

    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        int minLen = 201;
        int index = -1;
        boolean isMatch = false;

        //find the minimum length of the string and it's index
        for(int i=0; i<strs.length; i++){

            if(minLen > strs[i].length()){
                index = i;
                minLen = strs[i].length();
            }
        }
        for(int i=0; i< minLen; i++){
            char ch = strs[index].charAt(i);
            for(int j=0; j< strs.length; j++){
                if(strs[j].charAt(i) != ch){
                    isMatch = false;
                    break;
                }else{
                    isMatch = true;
                }
            }
            if(isMatch){
                commonPrefix = commonPrefix+ch;
            }else{
                break;
            }
        }
        return commonPrefix;
    }
}
