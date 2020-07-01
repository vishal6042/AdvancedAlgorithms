package com.practice.interviewbit.greedy;

import java.util.ArrayList;

public class SeatArrangement {
    public int seats(String A) {
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                pos.add(i);
            }
        }
        int totalJumps = 0;
        int mid = pos.size() / 2;
        for (int i = 0; i < pos.size(); i++) {
            int startPos = pos.get(i) % 10000003;
            int endPos = (pos.get(mid) - mid + i) % 10000003;
            totalJumps = (totalJumps % 10000003 + (Math.abs(endPos - startPos) % 10000003)) % 10000003;
        }
        return totalJumps % 10000003;
    }

    public static void main(String[] args) {
        System.out.println(
                new SeatArrangement().seats("....x..xx...x..")
        );
    }
}
