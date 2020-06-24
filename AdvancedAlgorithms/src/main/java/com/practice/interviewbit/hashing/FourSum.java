package com.practice.interviewbit.hashing;

import java.util.*;

public class FourSum {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> arr, int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (arr == null || arr.size() <= 3) {
            return ans;
        }
        Collections.sort(arr);
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int sumVal = arr.get(i) + arr.get(j);
                if (map.containsKey(sumVal)) {
                    map.get(sumVal).add(new Pair(i, j));
                } else {
                    ArrayList<Pair> pairs = new ArrayList<>();
                    pairs.add(new Pair(i, j));
                    map.put(arr.get(i) + arr.get(j), pairs);
                }

            }
        }

        // System.out.println(map);

        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int currSum = arr.get(i) + arr.get(j);
                if (map.containsKey(sum - currSum)) {
                    ArrayList<Pair> pair = map.get(sum - currSum);
                    for (int k = 0; k < pair.size(); k++) {


                        if (pair.get(k).first != i && pair.get(k).first != j
                                && pair.get(k).second != i && pair.get(k).second != j) {
                            // System.out.println(pair.first + " " + pair.second + " " + i + " " + j);
                            List<Integer> list = Arrays.asList(arr.get(i), arr.get(j), arr.get(pair.get(k).first), arr.get(pair.get(k).second));
                            Collections.sort(list);
                            if (!ans.contains(list)) {
                                ans.add(new ArrayList<>(list));
                            }
                        }
                    }
                }
            }
        }
        return ans;

    }

    private boolean isAvailable(ArrayList<ArrayList<Integer>> ans, List<Integer> list) {
        if (ans.size() == 0) {
            return false;
        }

        for (ArrayList<Integer> curr : ans) {
            if (isEqual(curr, list)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(ArrayList<Integer> curr, List<Integer> list) {
        int i = 0;
        int j = 0;

        while (i < curr.size() && j < list.size()) {
            if (!curr.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        new FourSum().fourSum(new ArrayList<Integer>(Arrays.asList(
                10, 20, 30, 40, 1, 2, 15, 35)), 91).forEach(System.out::println);
    }
}
