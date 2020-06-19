package com.practice.interviewbit.strings;

public class AddBinaryStrings {

    public static void main(String[] args) {
        AddBinaryStrings addBinaryStrings = new AddBinaryStrings();
        System.out.println(addBinaryStrings.addBinary("11111", "101"));
    }

    public String addBinary(String A, String B) {
        StringBuilder ans = new StringBuilder();
        int i = A.length() - 1;
        int j = B.length() - 1;
        if (i > j) {
            B = addZeros(B, i - j);
            j = i;
        } else {
            A = addZeros(A, j - i);
            i = j;
        }

        int carry = 0;
        while (i >= 0 && j >= 0) {
            char a = A.charAt(i);
            char b = B.charAt(j);
            if (a == '1' && b == '1') {
                if (carry == 0) {
                    ans.append("0");
                } else {
                    ans.append("1");
                }
                carry = 1;

            } else if (a == '1' || b == '1') {
                if (carry == 0) {
                    ans.append("1");
                    carry = 0;
                } else {
                    ans.append("0");
                    carry = 1;
                }
            } else {
                if (carry == 0) {
                    ans.append("0");
                } else {
                    ans.append("1");
                }
                carry = 0;
            }
            i--;
            j--;
        }
        if(carry == 1){
            ans.append("1");
        }
        return ans.reverse().toString();
    }

    private String addZeros(String a, int i) {
        while (i-- != 0) {
            a = "0" + a;
        }
        return a;
    }
}
