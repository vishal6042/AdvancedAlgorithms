package com.practice.interviewbit.hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNumbers {
    public int colorful(int n) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> listofDigits = new ArrayList<>();

        while (n > 0) {
            int temp = n % 10;
            listofDigits.add(temp);
            if (set.contains(temp)) {
                return 0;
            }
            set.add(temp);
            n = n / 10;
        }

        for (int i = 0; i < listofDigits.size(); i++) {
            int mul = listofDigits.get(i);
            for (int j = i + 1; j < listofDigits.size(); j++) {
                mul *= listofDigits.get(j);
                if (set.contains(mul)) {
                    return 0;
                }
                set.add(mul);
            }
        }
        return 1;
    }


    private void findSubSequence(String n, ArrayList<String> set, String s, int val) {
        if(val == n.length()) {
            set.add(s);

        } else {
            findSubSequence(n, set, s + n.charAt(val), val + 1);
            findSubSequence(n, set, s, val + 1);
        }
    }

    public static void main(String[] args) {
        //System.out.println(new ColorfulNumbers().colorful(263));

        ArrayList<String> subsequences = new ArrayList<>();
        new ColorfulNumbers().findSubSequence("123", subsequences, "", 0);
        System.out.println(subsequences);
    }
}
