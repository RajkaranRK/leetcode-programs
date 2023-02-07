package com.rk.leetcode;

import java.util.*;

public class LeetcodeProgramsApplicationTests {

	void contextLoads() {
	}

	public static void main(String[] args) {
		LeetcodeProgramsApplicationTests tests = new LeetcodeProgramsApplicationTests();
		int len = tests.lengthOfLongestSubstring("abcabcbb");
		System.out.println(len);
		tests.reverse(Integer.MAX_VALUE);
	}

	public int lengthOfLongestSubstring(String s) {
		char arr[] = s.toCharArray();
		Set<Character> charSet = new HashSet<>();
		int max = 0;
		int i = 0;
		int j = 0;
		while(i < arr.length){
			if(!charSet.contains(arr[i])){
				charSet.add(arr[i]);
				if(charSet.size() > max){
					max = charSet.size();
				}
				i++;
			}else{
				charSet.remove(j);
				j++;
			}
		}
		return max;
	}
	public int reverse(int x){
		return 0;
	}


	public void find3Sum(int []arr){
		List<List<Integer>> lists = new ArrayList<>();
		int target = 9;
		for(int i=0; i < arr.length;i++) {
			int[] resultArray = findTwo(arr, arr[i], target - arr[i], i + 1, arr.length);
			if (resultArray != null) {
				lists.add(Arrays.asList(resultArray[0], resultArray[1], resultArray[2]));
			}
		}
		System.out.println(lists);
	}


	public int[] findTwo(int arr[], int first, int target, int start, int end){
		Set<Integer> numSet = new HashSet<>();
		for(int i=start; i < end; i++ ){
			int sum = target - arr[i];
			if(numSet.contains(sum)){
				return new int[]{first,sum, arr[i]};
			}else{
				numSet.add(arr[i]);
			}
		}
		return null;
	}
}