package com.practice.interviewbit.hashing;

import java.util.*;

public class PointsOnStraightLine {


    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object ob) {
            if (ob instanceof Point) {
                Point p1 = (Point) ob;
                return this.x == p1.x && this.y == p1.y;
            }
            return false;
        }

        public int hashCode() {
            return (this.x + "-" + this.y).hashCode();
        }
    }

    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {

        if (x.size() < 2) {
            return x.size();
        }
        int maxPoint = 0;
        int samePoints = 0;
        int verticalPoints = 0;
        int horizontalPoints = 0;
        int currMax = 0;
        HashSet<Point> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < x.size(); i++) {
            Point p = new Point(x.get(i), y.get(i));
            if (!set.contains(p)) {
                samePoints = verticalPoints = currMax = horizontalPoints = 0;
                map = new HashMap<>();
                for (int j = i + 1; j < x.size(); j++) {
                    Point p1 = new Point(x.get(j), y.get(j));
                    if (p1.equals(p)) {
                        samePoints++;
                    } else if (x.get(i).equals(x.get(j))) {
                        verticalPoints++;
                    } else {
                        String slope = getSlope(p, p1);
                        if (map.containsKey(slope)) {
                            map.put(slope, map.get(slope) + 1);
                        } else {
                            map.put(slope, 1);
                        }
                        currMax = Math.max(currMax, map.get(slope));
                    }
                    //currMax = Math.max(currMax, horizontalPoints);
                    currMax = Math.max(currMax, verticalPoints);
                }
                maxPoint = Math.max(maxPoint, currMax + samePoints + 1);
                set.add(p);
            }

        }
        return maxPoint;
    }

    public String getSlope(Point p1, Point p2) {
        if (p1.x == p2.x) return "-INF";

        if (p1.y == p2.y) return "0";

        long xdiff = (long) p1.x - (long) p2.x;
        long ydiff = (long) p1.y - (long) p2.y;

        long g = gcd(Math.abs(xdiff), Math.abs(ydiff));

        //handling sign as -2/-3 is same as 2/3
        String sign = ((ydiff < 0 && xdiff < 0) || (ydiff > 0 && xdiff > 0)) ? "" : "-";

        return sign + (Math.abs(ydiff) / g) + "/" + (Math.abs(xdiff) / g);
    }

    public long gcd(long a, long b) {
        if (a < b) return gcd(b, a);

        if (b == 0) return a;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(4, 8, -4));
        ArrayList<Integer> y = new ArrayList<>(Arrays.asList(-4, -4, -4));

        System.out.println(new PointsOnStraightLine().maxPoints(x, y));
    }
}
