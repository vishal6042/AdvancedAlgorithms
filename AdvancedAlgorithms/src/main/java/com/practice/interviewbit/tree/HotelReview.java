package com.practice.interviewbit.tree;

import java.util.*;

public class HotelReview {
    public ArrayList<Integer> solve(String goodWords, ArrayList<String> reviewList) {
        ArrayList<Integer> ans = new ArrayList<>();

        String[] words = goodWords.split("_");
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < reviewList.size(); i++) {
            map.put(reviewList.get(i), i);
        }

        Collections.sort(reviewList, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                int count1 = getCount(first, set);
                int count2 = getCount(second, set);

                return count2 - count1;
            }
        });

        System.out.println(reviewList);
        for (String word : reviewList) {
            ans.add(map.get(word));
        }
        return ans;
    }

    private int getCount(String first, HashSet<String> set) {
        int count = 0;
        String[] words = first.split("_");
        for (String word : words) {
            if (set.contains(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                new HotelReview().solve("cool_ice_wifi", new ArrayList<>(
                        Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")
                ))
        );
    }
}
