package com.practice.interviewbit.arrays;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final List<Integer> A) {

        HashSet<Integer> set = new HashSet<>(A);

        int maxLength = 0;
        for (int i = 0; i < A.size(); i++) {

            int len = 0;
            int elem = A.get(i);

            if (!set.contains(elem - 1)) {
                int j = A.get(i);
                while (set.contains(j)) {
                    j++;
                    len++;
                }
            }
            if (len > maxLength) {
                maxLength = len;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestConsecutiveSequence().longestConsecutive(
                        new ArrayList<>(Arrays.asList(-6, -4, -5, -2, -3))
                )
        );
    }
}
