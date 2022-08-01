package com.rk.leetcode.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String []args){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);


        list2.add(2);
        list2.add(3);
        list2.add(1);

        list1.stream().forEach(System.out::println);
        list2.stream().forEach(System.out::println);

        System.out.print(list1.equals(list2));
    }
}
