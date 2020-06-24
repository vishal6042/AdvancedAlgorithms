package com.practice.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSum {
    public ArrayList<Integer> lszero(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr == null) {
            return ans;
        }
        if (arr.size() == 1 && arr.get(0) != 0) {
            return ans;
        }

        Map<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLength = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            if (arr.get(i) == 0 && maxLength == 0) {
                maxLength = 1;
                startIndex = endIndex = i;
            }
            if (sum == 0) {
                maxLength = i + 1;
                startIndex = 0;
                endIndex = i;
            }
            if (map.containsKey(sum)) {
                int length = i - map.get(sum);
                if (length > maxLength) {
                    maxLength = length;
                    startIndex = map.get(sum) + 1;
                    endIndex = i;
                }
            } else {
                map.put(sum, i);
            }
        }
        if (maxLength >= 1) {
            for (int i = startIndex; i <= endIndex; i++) {
                ans.add(arr.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LargestContinuousSum()
                .lszero(new ArrayList<>(Arrays.asList(-19, 8, 2, -8, 19, 5, -2, -23 ))));
    }

}
