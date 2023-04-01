package com.rk.leetcode.interview;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class StringDividePerson {

    public static void main(String[] args) {
        String result = divide("abcdefgh",7);
        System.out.println(result);
    }

    public static String divide(String str,int p){
        Queue<StringPerson> queue = new LinkedBlockingQueue<>();
        queue.add(new StringPerson(str,1));
        String result = "";
        int pCount = 1;
        while(!queue.isEmpty()){
            StringPerson sp = queue.poll();
            if(sp.getP() == p){
                result = sp.getStr();
                break;
            }else{
                String s1 = sp.getStr().substring(0,sp.getStr().length()/2);
                if(!s1.equals("")){
                    pCount++;
                    queue.add(new StringPerson(s1, pCount));

                    String s2 = sp.getStr().substring(sp.getStr().length()/2);
                    pCount++;
                    queue.add(new StringPerson(s2,pCount));
                }
            }
        }
        return result;
    }

}

class StringPerson {


    private  String str;

    private int p;

    public StringPerson(String str, int p){
        this.str = str;
        this.p = p;
    }

    public String getStr(){
        return str;
    }

    public  int getP(){
        return p;
    }

    @Override
    public String toString() {
        return "StringPerson{" +
                "str='" + str + '\'' +
                ", p=" + p +
                '}';
    }
}
