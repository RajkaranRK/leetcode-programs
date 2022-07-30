package com.rk.leetcode.interview;


import com.rk.leetcode.ListNode;

public class AddNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = null;
        int currentCarry = 0;
        int prevCarry = 0;
        while(l1 != null || l2 != null){
            prevCarry = currentCarry; 
            int val_1 = l1 != null ? l1.val : 0;
            int val_2 = l2 != null ? l2.val : 0;
            int val = val_1 + val_2 + prevCarry;
            currentCarry = val / 10;
            val = val %10;  
            
            if(sumList == null){
                sumList = new ListNode(val,null);
            }else{
                populateListNode(sumList,val);
            }
            if(l1 != null && l2 != null){
                l1 = l1.next;
                l2 = l2.next;
            }else{
                if(l1 == null) {
                    l2 = l2.next;
                }else {
                    l1 = l1.next;
                }
            }
             
        }
        if(currentCarry != 0){
            populateListNode(sumList,currentCarry);
        }
        return sumList;
    }
    
    private void populateListNode(ListNode root,int val){
        for(;root.next != null; root = root.next);
        root.next = new ListNode(val, null);
    }
    
    
    public ListNode insert(int []arr) {
        ListNode root = new ListNode(arr[0], null);
        if(arr.length > 1) {
            for(int i =1; i<arr.length ; i++) {
                ListNode temp = null;
                for(temp = root ; temp.next!=null;temp = temp.next);
                temp.next = new ListNode(arr[i], null);
            }
        }
        return root;
    }
    
    
    public void printNode(ListNode root) {
        while(root != null) {
            System.out.print(root.val+"->");
            root = root.next;
        }
    }
    
    public static void main(String []args) {
        AddNumber addNumber = new AddNumber();
//        ListNode l1 = addNumber.insert(new int[] {9,9,9,9,9,9,9});
//        ListNode l2 = addNumber.insert(new int[] {9,9,9,9});
//        System.out.println("list 1");
//        addNumber.printNode(l1);
//        System.out.println("\n");
//        System.out.println("list 2");
//        addNumber.printNode(l2);
//        ListNode sumList =   addNumber.addTwoNumbers(l1,l2);
//        System.out.println("Sum list");
//        addNumber.printNode(sumList);
        
        ListNode l1 = null;
        ListNode l2 = addNumber.insert(new int[] {9,9,9,9});
        System.out.println("list 1");
        addNumber.printNode(l1);
        System.out.println("\n");
        System.out.println("list 2");
        addNumber.printNode(l2);
        ListNode sumList =   addNumber.addTwoNumbers2(l1,l2,0);
        System.out.println("Sum list");
        addNumber.printNode(sumList);
    }
    
    
    
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2,int carry) {
        if(l1 == null && l2 == null) {
            if(carry == 1) {
                return new ListNode(carry);
            }
            return null;
        }
        int v1 = 0;
        int v2 = 0;
        if(l1 != null) {
           v1 = l1.val;
        }
        if(l2 != null) {
            v2 = l2.val;
        }
        int sum = v1 + v2 + carry;
        carry = sum / 10;
        sum = sum % 10;
        if(l1 == null) {
            l2.val = sum;
            if(carry == 1) {
                l2.next = addTwoNumbers2(l1, l2.next, carry);    
            }
            return l2;
        }
        if(l2 == null) {
            l1.val = sum;
            if(carry == 1) {
                l1.next = addTwoNumbers2(l1.next, l2,carry);   
            }
            return l1;
        }
        l1.val = sum;
        l1.next = addTwoNumbers2(l1.next, l2.next,carry);
        return l1;
    }
}
