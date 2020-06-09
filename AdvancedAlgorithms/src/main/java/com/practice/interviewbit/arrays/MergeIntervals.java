package com.practice.interviewbit.arrays;

import java.util.ArrayList;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * <p>
 * Example 2:
 * <p>
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * Make sure the returned intervals are also sorted.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        Interval newInterval = new Interval(4, 9);
//        Interval newInterval = new Interval(10, 8);
        ArrayList<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1, 2));
//        intervals.add(new Interval(3, 6));
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        MergeIntervals inter = new MergeIntervals();
        System.out.println(inter.insert(intervals, newInterval));

    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        if (intervals.contains(newInterval)) {
            return intervals;
        }
        if (newInterval.start > newInterval.end) {
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        Interval tempInterval = new Interval();

        ArrayList<Interval> ans = new ArrayList<>();
        ArrayList<Interval> ans1 = new ArrayList<>();
        for (Interval interval : intervals) {
            if (newInterval.start > interval.start && newInterval.end < interval.end) {
                return intervals;
            }
            if (newInterval.start > interval.end) {
                ans.add(interval);
            } else if (newInterval.end < interval.start) {
                ans1.add(interval);
            } else if (newInterval.start > interval.start && newInterval.start < interval.end) {
                tempInterval.start = interval.start;
            } else if (newInterval.end > interval.start && newInterval.end < interval.end) {
                tempInterval.end = interval.end;
            }
        }
        if (tempInterval.start == 0) {
            tempInterval.start = newInterval.start;
        }
        if (tempInterval.end == 0) {
            tempInterval.end = newInterval.end;
        }
        ans.add(tempInterval);
        ans.addAll(ans1);
        return ans;
    }

}
