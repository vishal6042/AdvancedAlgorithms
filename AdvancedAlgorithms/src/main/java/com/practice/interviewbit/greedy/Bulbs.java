package com.practice.interviewbit.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {
    public int bulbs(ArrayList<Integer> A) {
        if (A.size() == 1) {
            return 1 - A.get(0);
        }

        int count = 0;
        int i = 0;
        while (i < A.size()) {
            if (A.get(i) == 1) {
                i++;
                continue;
            }
            if (A.get(i) == 0) {
                i++;
                count++;
                break;
            }
        }
        for (int j = i; j < A.size(); j++) {
            if (j > 0 && !A.get(j).equals(A.get(j - 1))) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                new Bulbs().bulbs(new ArrayList<>(
                        Arrays.asList(
                                1, 1, 0, 1
                        )
                ))
        );
    }
}
