package com.practice.interviewbit.hashing;

import java.util.*;

public class Equal {
    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public ArrayList<Integer> equal(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (arr.size() <= 3) {
            return ans;
        }

        HashMap<Integer, List<Pair>> map = new HashMap<>();
//        for (int i = 0; i < arr.size() - 1; i++) {
//            for (int j = i + 1; j < arr.size(); j++) {
//                int sumVal = arr.get(i) + arr.get(j);
//                if (map.containsKey(sumVal)) {
//                    map.get(sumVal).add(new Pair(i, j));
//                } else {
//                    ArrayList<Pair> pairs = new ArrayList<>();
//                    pairs.add(new Pair(i, j));
//                    map.put(arr.get(i) + arr.get(j), pairs);
//                }
//            }
//        }

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int sumVal = arr.get(i) + arr.get(j);
                if (map.containsKey(sumVal)) {
                    List<Pair> pairs = map.get(sumVal);
                    for (Pair pair : pairs) {
                        int x = pair.first;
                        int y = pair.second;
                        if (x < i && y != j && y != i) {
                            if (i < j && x < y) {
                                if (ans.size() == 0) {
                                    ans.add(x);
                                    ans.add(y);
                                    ans.add(i);
                                    ans.add(j);
                                } else {
                                    List<Integer> list = Arrays.asList(x, y, i, j);
                                    if (ans.get(0) > list.get(0)
                                            || (list.get(0).equals(ans.get(0)) && list.get(1) < ans.get(1))
                                            || (list.get(0).equals(ans.get(0)) && list.get(1).equals(ans.get(1)) && list.get(2) < ans.get(2))
                                            || (list.get(0).equals(ans.get(0)) && list.get(1).equals(ans.get(1)) && list.get(2).equals(ans.get(2)) && list.get(3) < ans.get(3))
                                    ) {
                                        ans.clear();
                                        ans.addAll(list);
                                    }

                                }
                            }

                        }

                    }
                } else {
                    ArrayList<Pair> pairs = new ArrayList<>();
                    pairs.add(new Pair(i, j));
                    map.put(arr.get(i) + arr.get(j), pairs);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Equal().equal(new ArrayList<>(Arrays.asList( 3, 4, 7, 1, 2, 9, 8 )))
        );
    }
}
