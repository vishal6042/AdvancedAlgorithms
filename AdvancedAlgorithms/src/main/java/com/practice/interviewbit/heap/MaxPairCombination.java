package com.practice.interviewbit.heap;

import java.util.*;

class Entry<K, V> {
    private K first;
    private V second;

    public Entry(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public V getSecond() {
        return second;
    }

    public K getFirst() {
        return first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?, ?> entry = (Entry<?, ?>) o;
        return first.equals(entry.first) &&
                second.equals(entry.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

public class MaxPairCombination {
    public ArrayList<Integer> solve(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(a);
        Collections.sort(b);
        int n = a.size();
        PriorityQueue<Entry<Integer, Entry<Integer, Integer>>> priorityQueue =
                new PriorityQueue<>(new Comparator<Entry<Integer, Entry<Integer, Integer>>>() {
                    @Override
                    public int compare(Entry<Integer, Entry<Integer, Integer>> o1, Entry<Integer, Entry<Integer, Integer>> o2) {
                        return o2.getFirst() - o1.getFirst();
                    }
                });
        HashSet<Entry<Integer, Integer>> set = new HashSet<>();

        priorityQueue.add(new Entry<>(
                (a.get(a.size() - 1) + b.get(a.size() - 1)),
                new Entry<>(n - 1, n - 1)
        ));
        set.add(new Entry<>(n - 1, n - 1));

        for (int x = 0; x < n; x++) {

            Entry<Integer, Entry<Integer, Integer>> pq = priorityQueue.peek();
            priorityQueue.poll();
            ans.add(pq.getFirst());

            int i = pq.getSecond().getFirst();
            int j = pq.getSecond().getSecond();
            int newSum;
            Entry<Integer, Integer> entry;
            if (i != 0) {
                newSum = a.get(i - 1) + b.get(j);
                entry = new Entry<>(i - 1, j);
                if (!set.contains(entry)) {
                    set.add(entry);
                    priorityQueue.add(new Entry<>(newSum, entry));
                }
            }
            if (j != 0) {
                newSum = a.get(i) + b.get(j - 1);
                entry = new Entry<>(i, j - 1);
                if (!set.contains(entry)) {
                    set.add(entry);
                    priorityQueue.add(new Entry<>(newSum, entry));
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 4));
        new MaxPairCombination().solve(a, b).forEach(System.out::println);
    }
}
