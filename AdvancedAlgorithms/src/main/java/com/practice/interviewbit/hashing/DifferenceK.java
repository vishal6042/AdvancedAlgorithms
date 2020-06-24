package com.practice.interviewbit.hashing;

import java.util.*;

public class DifferenceK {
    public int diffPossible(final List<Integer> arr, int diff) {
        if (arr.size() <= 1) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if (map.containsKey(arr.get(i))) {
                map.get(arr.get(i)).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr.get(i), list);
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            int val = diff + arr.get(i);
            if (map.containsKey(val)) {
                List<Integer> list = map.get(val);
                for (Integer integer : list) {
                    if (i != integer) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new DifferenceK().diffPossible(
                new ArrayList<>(Arrays.asList(1, 5, 3)),
                2
        ));
    }
}
