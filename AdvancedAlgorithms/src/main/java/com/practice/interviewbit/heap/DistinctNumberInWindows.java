package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumberInWindows {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        ArrayList<Integer> ans = new ArrayList<>();
        if (B == 1) {
            for (int i = 0; i < A.size(); i++) {
                ans.add(1);
            }
            return ans;

        }
        if (B > A.size()) {
            return ans;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < A.size()) {
            if ((right - left) < B) {
                map.put(A.get(right), map.getOrDefault(A.get(right), 0) + 1);
                right++;
            } else if ((right - left) == B) {
                left++;
                ans.add(map.size());
                if (map.containsKey(A.get(left - 1))) {
                    if (map.get(A.get(left - 1)) > 1) {
                        map.put(A.get(left - 1), map.get(A.get(left - 1)) - 1);
                    } else {
                        map.remove(A.get(left - 1));
                    }
                }
            }
            if (right == A.size()) {
                ans.add(map.size());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new DistinctNumberInWindows().dNums(
                new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3)
        );
    }
}
