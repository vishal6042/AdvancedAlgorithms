package com.practice.interviewbit.strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord low = new LengthOfLastWord();
        System.out.println(low.lengthOfLastWord("asjdvb alsdygv 234r2 uisgbv    "));
        System.out.println(low.lengthOfLastWord("asjdvb alsdygv 234r2 uQ23rdisgbv   ss"));
        System.out.println(low.lengthOfLastWord("aasf"));
        System.out.println(low.lengthOfLastWord("aasf szdfvs2334"));
    }

    public int lengthOfLastWord(final String A) {
        if (A == null || A.isEmpty()) {
            return 0;
        }
        int count = 0;
        int j = A.length() - 1;
        while (j >= 0 && A.charAt(j) == ' ') {
            j--;
        }
        for (int i = j; i >= 0; i--) {
            char c = A.charAt(i);
            if (c == ' ') {
                return count;
            } else {
                count++;
            }
        }
        return count;

    }
}
