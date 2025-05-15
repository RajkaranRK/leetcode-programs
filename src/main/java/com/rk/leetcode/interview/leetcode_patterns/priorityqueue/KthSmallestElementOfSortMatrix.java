package com.rk.leetcode.interview.leetcode_patterns.priorityqueue;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

@Slf4j
public class KthSmallestElementOfSortMatrix {

    public static void main(String[] args) {
        int [][]matrix = {
                {1,2},
                {1,3}
        };
        int k = 2;
        log.info("{}th smallest element of matrix is :{}",k,kthSmallest(matrix,k));
    }


    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b-a);

        int l = 0;
        int n = 0;
        int m = 0;
        for(n =0;n<matrix.length; n++){
            if(l==k){
                m =  m >= matrix.length ? 0 : m;
                break;
            }
            for(m=0; m<matrix.length; m++){
                if(l == k){
                    break;
                }
                maxHeap.offer(matrix[n][m]);
                l++;
            }
        }
        maxHeap.stream().forEach(System.out::println);
        log.info("i :{}, j:{}",n,m);
        for(int i = n; i<matrix.length; i++){
            for(int j = m; j<matrix.length; j++){
                if(matrix[i][j] <= maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(matrix[i][j]);
                }
            }
        }
        return maxHeap.peek();
    }
}
