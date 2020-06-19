package com.practice.interviewbit.strings;

import java.util.ArrayList;

public class PrettyJson {
    public static void main(String[] args) {
        PrettyJson prettyJson = new PrettyJson();
        // prettyJson.prettyJSON("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]").forEach(System.out::println);
        String val = "A : \"{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}\"";
        prettyJson.prettyJSON(val).forEach(System.out::println);
    }

    public ArrayList<String> prettyJSON(String A) {
        int totalIden = 0;
        int i = 0;
        ArrayList<String> ans = new ArrayList<>();
        String line = "";

        for (int j = 0; j < A.length(); ) {
            if (A.charAt(j) == ' ') {
                j++;
                continue;
            }
            if (A.charAt(j) == '{' || A.charAt(j) == '[') {
                for (int k = 0; k < totalIden; k++) {
                    line += "\t";
                }
                line += A.charAt(j);
                totalIden++;
                j++;
                ans.add(line);
                line = "";
            } else if (A.charAt(j) == '}' || A.charAt(j) == ']') {
                totalIden--;
                for (int k = 0; k < totalIden; k++) {
                    line += "\t";
                }
                line += A.charAt(j);
                j++;
                if (j != A.length() && A.charAt(j) == ',') {
                    line += A.charAt(j);
                    j++;
                }
                ans.add(line);
                line = "";
            } else {
                for (int k = 0; k < totalIden; k++) {
                    line += "\t";
                }
                while (j < A.length()) {
                    if (A.charAt(j) == ',' || A.charAt(j) == '}' || A.charAt(j) == ']' ||
                            A.charAt(j) == '{' || A.charAt(j) == '[') {
                        break;
                    }
                    line += A.charAt(j);
                    j++;
                }
                if (j < A.length() && A.charAt(j) == ',') {
                    line += A.charAt(j);
                    j++;
                }
                ans.add(line);
                line = "";

            }
        }
        return ans;

    }
}
