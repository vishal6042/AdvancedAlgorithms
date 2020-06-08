package com.practice.interviewbit.arrays;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 * <p>
 * Given a non-negative number represented as an array of digits,
 * <p>
 * add 1 to the number ( increment the number represented by the digits ).
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example:
 * <p>
 * If the vector has [1, 2, 3]
 * <p>
 * the returned vector should be [1, 2, 4]
 * <p>
 * as 123 + 1 = 124.
 * <p>
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 * For example, for this problem, following are some good questions to ask :
 * Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class AddOneToNumber {

    public static void main(String[] args) {
        AddOneToNumber addOneToNumber = new AddOneToNumber();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(9);
        ArrayList<Integer> ans = addOneToNumber.plusOne(arrayList);
        System.out.println(ans);
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> arrayList) {
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;
        int n = arrayList.size();
        int sum = 1;
        for (int i = n - 1; i >= 0; i--) {
            sum += arrayList.get(i) + carry;
            carry = 0;
            if (sum == 10) {
                carry = 1;
                ans.add(0, 0);
            } else {
                ans.add(0, sum);
            }
            sum = 0;

        }
        if (carry != 0) {
            ans.add(0, 1);
        }
        while (ans.get(0) == 0) {
            ans.remove(0);
        }
        return ans;

    }

    public ArrayList<Integer> plusOneOther(ArrayList<Integer> arrayList) {
        int carry = 0;

        while (arrayList.size() > 1 && arrayList.get(0) == 0) {
            arrayList.remove(0);
        }

        for (int i = arrayList.size() - 1; i >= 0; i--) {
            int val = arrayList.get(i);
            arrayList.remove(i);
            if (val == 9) {
                arrayList.add(i, 0);
                carry = 1;
            } else {
                arrayList.add(i, val + 1);
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            arrayList.add(0, 1);
        }
        return arrayList;

    }
}
