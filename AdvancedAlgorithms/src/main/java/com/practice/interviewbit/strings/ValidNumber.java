package com.practice.interviewbit.strings;

public class ValidNumber {
    public static void main(String[] args) {
        ValidNumber number = new ValidNumber();
//        System.out.println(number.isNumber("12342134"));
//        System.out.println(number.isNumber("1234e2134"));
//        System.out.println(number.isNumber("1234.2134"));
//        System.out.println(number.isNumber("-112342134"));
//        System.out.println(number.isNumber("    12   342134"));
//        System.out.println(number.isNumber("-e12342134"));
//        System.out.println(number.isNumber("1234e213.4"));
        System.out.println(number.isNumber("      "));

    }

    public int isNumber(final String A) {

        String b = A.trim();
        if (b.length() == 0) {
            return 0;
        }
        int i = 0;
        boolean isNeg = false;
        if (b.charAt(0) == '-') {
            i++;
            isNeg = true;
        }
        for (int j = i; j < b.length(); j++) {
            char c = b.charAt(j);
            if (!isValidChar(c)) {
                return 0;
            }
        }
        for (int j = i; j < b.length(); j++) {
            char c = b.charAt(j);
            if (isValidChar(c)) {
                if (c == 'e') {
                    if (j == 0) {
                        return 0;
                    }
                    if (isNeg && j == 1) {
                        return 0;
                    }
                    if (b.charAt(j - 1) == '.') {
                        return 0;
                    }
                    for (int k = j + 1; k < b.length(); k++) {
                        char d = b.charAt(k);
                        if (k != j + 1 && d == '-') {
                            return 0;
                        }
                        if (d == '.') {
                            return 0;
                        }
                    }
                    return 1;

                } else if (c == '.') {
                    if (j == b.length() - 1) {
                        return 0;
                    }
                    if (b.charAt(j + 1) == 'e') {
                        return 0;
                    }
                    return 1;

                } else if (c == '-') {
                    if (b.charAt(j - 1) == 'e') {
                        return 1;
                    }
                    return 0;
                }
            }
        }
        return 1;

    }

    private boolean isValidChar(char c) {
        return Character.isDigit(c) || c == 'e' || c == '.' || c == '-';
    }
}
