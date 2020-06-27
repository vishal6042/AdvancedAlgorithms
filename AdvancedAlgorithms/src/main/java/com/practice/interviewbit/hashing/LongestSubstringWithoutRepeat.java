package com.practice.interviewbit.hashing;

import java.util.Arrays;

public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String arr) {
        int res = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int start = 0;

        for (int curr = 0; curr < arr.length(); curr++) {
            start = Math.max(start, hash[arr.charAt(curr)] + 1);
            res = Math.max(res, curr - start + 1);
            hash[arr.charAt(curr)] = curr;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("geeksforgeeks"));
    }
}
