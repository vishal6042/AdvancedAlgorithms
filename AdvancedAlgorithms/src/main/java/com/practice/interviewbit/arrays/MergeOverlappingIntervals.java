package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example:
 * <p>
 * Given [1,3],[2,6],[8,10],[15,18],
 * <p>
 * return [1,6],[8,10],[15,18].
 * <p>
 * Make sure the returned intervals are sorted.
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(4, 100));
        intervals.add(new Interval(48, 94));
        intervals.add(new Interval(16, 21));
        intervals.add(new Interval(1, 32));
        MergeOverlappingIntervals inter = new MergeOverlappingIntervals();
        System.out.println(inter.merge(intervals));
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        intervals.sort(Comparator.comparingInt(o -> o.start));
        ArrayList<Interval> ans = new ArrayList<>();
        for (Interval interval : intervals) {
            if (ans.isEmpty() || ans.get(ans.size() - 1).end < interval.start) {
                ans.add(interval);
            } else {
                ans.get(ans.size() - 1).end = Math.max(ans.get(ans.size() - 1).end, interval.end);
            }
        }

        return ans;
    }
}

