package com.practice.interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
 * <p>
 * Given an array of real numbers greater than zero in form of strings.
 * Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
 * Return 1 for true or 0 for false.
 * <p>
 * Example:
 * <p>
 * Given [0.6, 0.7, 0.8, 1.2, 0.4] ,
 * <p>
 * You should return 1
 * <p>
 * as
 * <p>
 * 0.6+0.7+0.4=1.7
 * <p>
 * 1<1.7<2
 * <p>
 * Hence, the output is 1.
 * <p>
 * O(n) solution is expected.
 * <p>
 * Note: You can assume the numbers in strings don’t overflow the primitive data type and there are no leading zeroes in numbers. Extra memory usage is allowed.
 */
public class TripletInRangeOneTwo {

    public static void main(String[] args) {

        TripletInRangeOneTwo triplet = new TripletInRangeOneTwo();
        System.out.println(triplet.solve(new String[]{"0.503094", "0.648924", "0.999298"}));
    }

    /**
     * https://stackoverflow.com/questions/19557505/triplet-whose-sum-in-range-1-2
     * <p>
     * The trick is to figure out a way to categorize the possible solutions and come up with a linear-time constant-space solution for each.
     * <p>
     * Consider the three ranges X = (0,2/3), Y = [2/3,1], Z = (1,2). At most one value can come from Z (if two values came from Z, then the sum would exceed 1+1=2). Similarly, at least one value must come from X. Suppose there were 3 values a <= b <= c so that 1 <= a+b+c <= 2 . Then, consider what possible classes of solutions are feasible:
     * <p>
     * A) `a \in X, b \in X, C \in X`
     * B) `a \in X, b \in X, C \in Y`
     * C) `a \in X, b \in X, C \in Z`
     * D) `a \in X, b \in Y, C \in Y`
     * E) `a \in X, b \in Y, C \in Z`
     * So how can we test each case?
     * <p>
     * Case A is incredibly easy to test: the sum is guaranteed to be below 2, so we just need to test the largest sum (largest 3 elements in X) exceeds 1.
     * <p>
     * Case C is incredibly easy to test: since the sum is guaranteed to be above 1, we only need to check if the sum is below 2. So in order to do that, we just need to test the smallest 2 values in X and the smallest value in Z
     * <p>
     * Cases D and E are similar to C (since the sum must be at least 4/3 > 1, choose the smallest possible values in each class).
     * <p>
     * Case B is the only tricky case. 0 < a+b < 4/3 and 2/3 <= c <= 1. To handle case B, we consider these intervals : X1 = (0, 1/2), X2 = [1/2 2/3), Y = [2/3, 1].
     * <p>
     * This results in following three valid cases :
     * <p>
     * B1. a in X1, b in X2, c in Y
     * <p>
     * B2. a in X1, b in X1, c in Y
     * <p>
     * B3. a in X2, b in X2, c in Y
     * <p>
     * Case B1 & B3 : Sum of three numbers is always greater than 1 so we take minimum values and check if it is smaller than 2 or not.
     * <p>
     * Case B2 : Sum of three numbers is always less than 2, so we take maximum sum and check if is greater than 1 or not.
     * <p>
     * So to summarize, the tests are:
     * <p>
     * |X| >= 3 and Xmax(1) + Xmax(2) + Xmax(3) >= 1
     * |X| >= 2, |Z| >= 1, and Xmin(1)+Xmin(2)+Zmin(1) <= 2
     * |X| >= 1, |Y| >= 2, and Xmin(1)+Ymin(1)+Ymin(2) <= 2
     * |X| >= 1, |Y| >= 1, |Z| >= 1, and Xmin(1)+Ymin(1)+Zmin(1) <= 2
     * |X| >= 2, |Y| >= 1, and Xmax(1) + Xmax(2) + Ymin(1) < 2
     * |X| >= 2, |Y| >= 1, and Xmin(1) + Xmin(2) + Ymax(1) > 1)
     * Each test can be performed in linear time and constant space (you only need to find Xmax(1), Xmax(2), Xmax(3), Xmin(1), Xmin(2), Ymin(1), Ymin(2), Ymax(1), Zmin(1), all of which can be found in one pass even if the data is not sorted)
     *
     * @param A
     * @return
     */
    public int solve(String[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        List<Double> first = new ArrayList<>();
        List<Double> second = new ArrayList<>();
        List<Double> third = new ArrayList<>();

        double pivot = (double) 2 / 3;
        for (int i = 0; i < A.length; i++) {
            double no = Double.parseDouble(A[i]);
            if (no >= 0 && no < pivot) {
                first.add(no);
            } else if (no >= pivot && no < 1) {
                second.add(no);
            } else {
                third.add(no);
            }
        }

        double firstMax, firstMax2, firstMax3;
        double firstMin, firstMin2;
        double secondMax;
        double secondMin, secondMin2;
        double thirdMin;

        firstMax = firstMax2 = firstMax3 = secondMax = Double.MIN_VALUE;
        firstMin = firstMin2 = secondMin = secondMin2 = thirdMin = Double.MAX_VALUE;

        for (Double no : first) {
            if (no > firstMax) {
                firstMax3 = firstMax2;
                firstMax2 = firstMax;
                firstMax = no;
            } else if (no > firstMax2 && no < firstMax) {
                firstMax3 = firstMax2;
                firstMax2 = no;
            } else if (no > firstMax3 && no < firstMax2) {
                firstMax3 = no;
            }

            if (no < firstMin) {
                firstMin2 = firstMin;
                firstMin = no;
            } else if (no < firstMin2 && no > firstMin) {
                firstMin2 = no;
            }
        }

        for (Double no : second) {
            if (no > secondMax) {
                secondMax = no;
            }
            if (no < secondMin) {
                secondMin2 = secondMin;
                secondMin = no;
            } else if (no < secondMin2 && no > secondMin) {
                secondMin2 = no;
            }
        }

        for (Double no : third) {
            if (no < thirdMin) {
                thirdMin = no;
            }
        }

        if (first.size() >= 3 && (firstMax + firstMax2 + firstMax3) >= 1) {
            return 1;
        }
        if (first.size() >= 2 && third.size() >= 1) {
            if (firstMin + firstMin2 + thirdMin <= 2) {
                return 1;
            }
        }
        if (first.size() >= 1 && second.size() >= 2) {
            if (firstMin + secondMin + secondMin2 <= 2) {
                return 1;
            }
        }
        if (first.size() >= 1 && second.size() >= 1 && third.size() >= 1) {
            if (firstMin + secondMin + thirdMin <= 2) {
                return 1;
            }
        }
        if (first.size() >= 2 && second.size() >= 1) {
            if (firstMax + firstMax2 + secondMin > 1 && firstMax + firstMax2 + secondMin < 2) {
                return 1;
            }
        }
        if (first.size() >= 2 && second.size() >= 1) {
            if (firstMin + firstMin2 + secondMax > 1 && firstMin + firstMin2 + secondMax < 2) {
                return 1;
            }
        }
        return 0;


    }
}
