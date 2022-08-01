package com.rk.leetcode.interview;

import java.util.Map;
import java.util.TreeMap;



/**
 * This method do the counting of the character and return the character with count  i.e. a<count> 
 * in decitionay order 
 * @author Rajkaran
 *
 */
public class CharCounter {

    public class Counter{
        int val;
        char key;
        Counter(char key, int val){
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Counter{" +
                    "val=" + val +
                    ", key=" + key +
                    '}';
        }
    }

    public static void main(String []args){
        CharCounter charCounter = new CharCounter();
        Map<Character,Integer> charMap = charCounter.countCharacter("aaaacccbbdddhheee");
        charMap.entrySet().stream().forEach(e -> System.out.print(e.getKey()+""+e.getValue()));
    }

    public Map<Character,Integer> countCharacter(String s){
        Map<Character,Integer> charMap = new TreeMap<>();
        for(int i=0;i<s.length(); i++){
            char ch = s.charAt(i);
            if(charMap.containsKey(ch)){
                charMap.put(ch,charMap.get(ch)+1);
            }else{
                charMap.put(ch,1);
            }
        }
        return charMap;
    }
}
