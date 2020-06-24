package com.practice.interviewbit.hashing;

import java.util.*;

public class Anagrams {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            char[] arr = A.get(i).toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);

            if (hashMap.containsKey(sortedString)) {
                hashMap.get(sortedString).add(i + 1);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i + 1);
                hashMap.put(sortedString, list);
            }
        }
        for (int i = 0; i < A.size(); i++) {
            char[] arr = A.get(i).toCharArray();
            Arrays.sort(arr);
            String sortedString = new String(arr);
            ArrayList<Integer> list = hashMap.get(sortedString);
            if (!ans.contains(list)) {
                ans.add(list);
            }
        }
        System.out.println(ans.size());
        return ans;
    }

    public static void main(String[] args) {
        new Anagrams().
                anagrams(new ArrayList<>(Arrays.asList("cat", "dog", "tac", "act", "god", "hell")))
                .forEach(System.out::println);
    }
}
