package com.rk.leetcode.interview.leetcode_patterns.stack;


import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack;

    private Stack<Integer> minStack;

    public MinStack() {
       mainStack = new Stack<>();
       minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int popVal = mainStack.pop();
        if(minStack.peek().equals(popVal)){
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}