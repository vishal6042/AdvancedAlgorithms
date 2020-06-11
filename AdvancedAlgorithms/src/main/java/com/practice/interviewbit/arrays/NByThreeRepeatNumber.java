package com.practice.interviewbit.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/n3-repeat-number/
 * <p>
 * You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.
 * <p>
 * If so, return the integer. If not, return -1.
 * <p>
 * If there are multiple solutions, return any one.
 * <p>
 * Example :
 * <p>
 * Input : [1 2 3 1 1]
 * Output : 1
 * 1 occurs 3 times which is more than 5/3 times.
 */
public class NByThreeRepeatNumber {

    public static void main(String[] args) {
        NByThreeRepeatNumber number = new NByThreeRepeatNumber();
        System.out.println(number.repeatedNumber(Arrays.asList(1, 2, 3, 6)));
    }

    public int repeatedNumber(final List<Integer> a) {
        if (a == null || a.size() < 3) {
            return -1;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer no : a) {
            if (countMap.containsKey(no)) {
                countMap.put(no, countMap.get(no) + 1);
            } else {
                countMap.put(no, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > a.size() / 3) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
