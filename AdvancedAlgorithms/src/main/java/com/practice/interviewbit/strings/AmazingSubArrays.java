package com.practice.interviewbit.strings;

public class AmazingSubArrays {

    public static void main(String[] args) {
        AmazingSubArrays subArrays = new AmazingSubArrays();
        System.out.println(subArrays.solve("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
    }

    private static final int MOD = 10003;

    public int solve(String A) {
        int ans = 0;

        for (int i = 0; i < A.length(); i++) {
            if (isVowel(A.charAt(i))) {
                ans = (ans % MOD) + (A.length() - i) % MOD;
            }
        }
        return ans % MOD;
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'A'
                || c == 'e' || c == 'E'
                || c == 'o' || c == 'O'
                || c == 'i' || c == 'I'
                || c == 'u' || c == 'U');
    }
}
