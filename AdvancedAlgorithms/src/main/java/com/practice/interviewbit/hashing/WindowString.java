package com.practice.interviewbit.hashing;

public class WindowString {
    public String minWindow(String str, String patt) {
        int len1 = str.length();
        int len2 = patt.length();

        if (len2 > len1) {
            return "";
        }

        int[] hashPattern = new int[256];
        int[] hashString = new int[256];

        for (int i = 0; i < patt.length(); i++) {
            hashPattern[patt.charAt(i)]++;
        }

        int start = 0;
        int startIndex = -1;
        int count = 0;
        int minWindowLength = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            hashString[c]++;

            if (hashPattern[c] != 0 && hashPattern[c] >= hashString[c]) {
                count++;
            }

            if (count == len2) {
                char c1 = str.charAt(start);
                while (hashString[c1] > hashPattern[c1] || hashPattern[c1] == 0) {
                    if (hashString[c1] > hashPattern[c1]) {
                        hashString[c1]--;
                    }
                    start++;
                    c1 = str.charAt(start);
                }

                int len = i - start + 1;
                if (len < minWindowLength) {
                    minWindowLength = len;
                    startIndex = start;
                }
            }
        }
        if (startIndex == -1) {
            return "";
        }

        return str.substring(startIndex, startIndex + minWindowLength);
    }

    public static void main(String[] args) {
        System.out.println(new WindowString().minWindow("this is a test string", "tist"));
    }
}
