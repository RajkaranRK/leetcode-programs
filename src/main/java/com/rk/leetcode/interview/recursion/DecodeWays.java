package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    
    
    public static void main(String []args) {
        
        DecodeWays decode = new DecodeWays();
        List<String> list = new ArrayList<>();    
        String str = "111111111111111111111111111111111111111111111";
//        System.out.println(str.length());
//        int count = decode.numDecodings(str,"",str.length());
//        System.out.println(count);
        
        System.out.println(System.currentTimeMillis());
        int c = decode.numDecodings(str);
        System.out.println(System.currentTimeMillis());
        System.out.println(c);
        
    }
     
    
    
    public int numDecodings(String s,String b,int n) {
        if(b.length() == n) {
            return 1;
        }
        int v1 = 0;
        if(s.length() >=2 && s.charAt(0)!='0'&& Integer.parseInt(s.substring(0,2))<=26) {
            v1 = numDecodings(s.substring(2), s.substring(0,2)+b, n);
        }
        if(s.length() >=1 && s.charAt(0)!='0') {
            v1 = v1 + numDecodings(s.substring(1), s.substring(0,1)+b, n);
        }
        return v1;
    }
    
    
    
//    public void numDecodings(String s,String b,int n, List<String> list) {
//        if(b.length() == n) {
//            list.add(b);
//            return;
//        }
//        if(s.length() >=2 && s.charAt(0)!='0'&& Integer.parseInt(s.substring(0,2))<=26) {
//            numDecodings(s.substring(2), s.substring(0,2)+b, n,list);
//        }
//        if(s.length() >=1 && s.charAt(0)!='0') {
//            numDecodings(s.substring(1), s.substring(0,1)+b, n,list);
//        }
//    }
    
    
    
    public int numDecodings(String s) {
        int n=s.length();
        Integer[] mem=new Integer[n];
        return s.length()==0?0:numDecodings(0,s,mem);      
    }
    private int numDecodings(int p, String s, Integer[] mem) {
        int n=s.length();
        
        if(p==n) return 1;
        
        if(s.charAt(p)=='0') return 0;
        
        if(mem[p]!=null) return mem[p];
        
        int res=numDecodings(p+1,s,mem);
        
        if(p<n-1 && (s.charAt(p)=='1'|| s.charAt(p)=='2'&& s.charAt(p+1)<'7')) 
            res+=numDecodings(p+2,s,mem);
        
        return mem[p]=res;
    }
    
}
