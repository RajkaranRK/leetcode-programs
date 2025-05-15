package com.rk.leetcode.interview;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class EncodeDecodeString {


    public static void main(String[] args) {
        List<String> words = Arrays.asList(":neet","leet","#code#","4feet");
        log.info("Original words :{}",words);
        String encoded = encode(words);
        log.info("Encoded string :{}",encoded);
        List<String> decodedWords = decode(encoded);
        log.info("decoded words {}",decodedWords);
    }


    private static String encode(List<String> words){
        StringBuilder builder = new StringBuilder();
        for (String word: words){
            builder.append(word.length())
                    .append("#")
                    .append(word);
        }
        return builder.toString();
    }

    private static List<String> decode(String encoded){
        char[] arr = encoded.toCharArray();
        int i =0;
        List<String> list = new ArrayList<>();
        while(i<arr.length){
            String countStr = ""+arr[i++];
            while(arr[i] != '#'){
                countStr += arr[i++];
            }
            Integer count = Integer.parseInt(countStr);
            i++;
            list.add(encoded.substring(i,i+count));
            i+=count;
        }
        return list;
    }
}
