package com.practice.interviewbit.hashing;

import java.util.*;

public class SubStringConcatenation {
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int sizeWord = B.get(0).length();
        int noOfWord = B.size();
        int totalLengthOfString = noOfWord * sizeWord;
        if (totalLengthOfString > A.length()) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : B) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < A.length() - totalLengthOfString + 1; i++) {

            Map<String, Integer> tempMap = new HashMap<>(map);
            int j = i;
            int count = noOfWord;
            while (j < i + totalLengthOfString) {
                String word = A.substring(j, j + sizeWord);
                if (!tempMap.containsKey(word) || tempMap.get(word) == 0) {
                    break;
                } else {
                    tempMap.put(word, tempMap.get(word) - 1);
                    count--;
                }
                j = j + sizeWord;
            }
            if (count == 0) {
                res.add(i);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String S = "catbatatecatatebat";
        ArrayList<String> L =
                new ArrayList<>(Arrays.asList("cat", "ate", "bat"));
        new SubStringConcatenation().findSubstring(S, L).forEach(System.out::println);

    }

}
