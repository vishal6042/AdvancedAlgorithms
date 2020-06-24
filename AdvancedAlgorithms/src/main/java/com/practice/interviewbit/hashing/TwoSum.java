package com.practice.interviewbit.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(final int[] arr, int sum) {
        if (arr.length <= 1) {
            return new int[0];
        }
        int[] ans = new int[2];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        int minIndex2 = Integer.MAX_VALUE;
        int minIndex1 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int index1 = Integer.MAX_VALUE;
            int index2 = Integer.MAX_VALUE;
            if (i == minIndex2) {
                continue;
            }
            int val = arr[i];
            if (map.containsKey(sum - val)) {
                ArrayList<Integer> list = map.get(sum - val);
                Collections.sort(list);
                if (list.size() == 1 && i != list.get(0)) {
                    index1 = Math.min(i + 1, list.get(0) + 1);
                    index2 = Math.max(i + 1, list.get(0) + 1);
                } else if (list.size() > 1) {
                    int index = -1;
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) != i) {
                            index = list.get(j);
                            break;
                        }
                    }
                    index1 = Math.min(i + 1, index + 1);
                    index2 = Math.max(i + 1, index + 1);
                }

                if (index2 < minIndex2) {
                    minIndex2 = index2;
                    minIndex1 = index1;
                } else if (index2 == minIndex2) {
                    if (index1 < minIndex1) {
                        minIndex1 = index1;
                        minIndex2 = index2;
                    }
                }
            }
        }
        if (minIndex1 == Integer.MAX_VALUE && minIndex2 == Integer.MAX_VALUE) {
            return new int[0];
        }
        ans[0] = minIndex1;
        ans[1] = minIndex2;
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new TwoSum().twoSum(new int[]{-7, -6, 7, 10, -1, -9, -8, 7, -5, -4, -4, 1, 6, 5, 7, 1, 3, -2, 9, -8, -6, -9, -4, -5},
                -2);
        System.out.println(arr[0] + " " + arr[1]);
    }
}
