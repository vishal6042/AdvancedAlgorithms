package com.practice.interviewbit.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/rotate-matrix/
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * You need to do this in place.
 * <p>
 * Note that if you end up using an additional array, you will only receive partial score.
 * <p>
 * Example:
 * <p>
 * If the array is
 * <p>
 * [
 * [1, 2],
 * [3, 4]
 * ]
 * Then the rotated array becomes:
 * <p>
 * [
 * [3, 1],
 * [4, 2]
 * ]
 */
public class RotateMatrix {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        ArrayList<Integer> two = new ArrayList<>();
        two.add(4);
        two.add(5);
        two.add(6);

        ArrayList<Integer> three = new ArrayList<>();
        three.add(7);
        three.add(8);
        three.add(9);

        a.add(one);
        a.add(two);
        a.add(three);
        System.out.println(a);
        new RotateMatrix().rotate(a);
        System.out.println(a);
    }

    public void rotate(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0) {
            return;
        }
        for (int i = 0; i < a.size() / 2; i++) {
            for (int j = i; j < a.size() - i - 1; j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(a.size() - 1 - j).get(i));
                a.get(a.size() - 1 - j).set(i, a.get(a.size() - 1 - i).get(a.size() - 1 - j));
                a.get(a.size() - 1 - i).set(a.size() - 1 - j, a.get(j).get(a.size() - 1 - i));
                a.get(j).set(a.size() - 1 - i, temp);
            }
        }
    }
}
