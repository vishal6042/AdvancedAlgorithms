package com.practice.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class JustifiedText {

    public ArrayList<String> fullJustify(ArrayList<String> words, int length) {
        ArrayList<String> ans = new ArrayList<>();
        int len = 0;
        String line = "";
        int numWOrd = 0;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            len += word.length();
            if (len <= length) {
                line += word;
                line += " ";
                len++;
                numWOrd++;
            } else {
                len -= word.length();
                len--;
                int remaining = length - len;
                int distributed = 0;
                int remainder = 0;
                if (remaining > 0) {
                    if (numWOrd > 1) {
                        distributed = remaining / (numWOrd - 1);
                        remainder = remaining % (numWOrd - 1);
                    } else {
                        distributed = remaining;
                    }
                    line = modifyLine(line, distributed, remainder);
                } else {
                    line = line.trim();
                }
                ans.add(line);
                numWOrd = 0;
                len = 0;
                line = "";
                i--;
            }

        }
        if (!line.isEmpty()) {
            String word = line.trim();
            int n = (word.length());
            for (int j = 0; j < length - n; j++) {
                word += " ";
            }
            ans.add(word);
        }
        return ans;

    }

    private String modifyLine(String line, int distributed, int remainder) {
        StringBuilder ans = new StringBuilder();
        String lines[] = line.split(" ");
        if (lines.length == 1) {
            String word = lines[0];
            for (int j = 0; j < distributed; j++) {
                word += " ";
            }
            ans.append(word);
            return ans.toString();
        }
        for (int i = 0; i < lines.length - 1; i++) {
            String word = lines[i];
            for (int j = 0; j < distributed; j++) {
                word += " ";
            }
            if (remainder != 0) {
                word += " ";
                remainder--;
            }
            ans.append(word);
            ans.append(" ");
        }
        ans.append(lines[lines.length - 1]);
        return ans.toString();
    }

    public static void main(String[] args) {
        JustifiedText justifiedText = new JustifiedText();
        String arr[] = {"What", "must", "be", "shall", "be." };
        System.out.println(justifiedText.fullJustify(new ArrayList<String>(Arrays.asList(arr)), 12));
    }
}
