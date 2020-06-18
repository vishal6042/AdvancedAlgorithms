package com.practice.interviewbit.strings;

import java.util.ArrayList;
import java.util.Collections;

public class ValidIPAddress {

    public static void main(String[] args) {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        ArrayList<String> add = validIPAddress.restoreIpAddresses("25525511135");
        for (String address : add) {
            System.out.println(address);

        }
    }

    public ArrayList<String> restoreIpAddresses(String s) {
        if (s == null || s.length() <= 3 || s.length() > 12) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int n = s.length();
        String composed = s;
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    composed = composed.substring(0, k) + "." + composed.substring(k);
                    composed = composed.substring(0, j) + "." + composed.substring(j);
                    composed = composed.substring(0, i) + "." + composed.substring(i);
                    if (isValid(composed)) {
                        arrayList.add(composed);
                    }
                    composed = s;

                }
            }

        }
        Collections.sort(arrayList, (o1, o2) -> {
            String a1[] = o1.split("[.]");
            String a2[] = o2.split("[.]");

            int result = -1;
            for (int i = 0; i < 4 && result != 0; i++) {
                result = a1[i].compareTo(a2[i]);
            }
            return result;
        });

        return arrayList;
    }

    private boolean isValid(String composed) {
        String arr[] = composed.split("[.]");
        for (String val : arr) {
            int i = Integer.parseInt(val);
            if (val.length() > 3 || i < 0 || i > 255) {
                return false;
            }
            if (val.length() > 1 && i == 0) {
                return false;
            }
            if (val.length() > 1 && i != 0 && val.charAt(0) == '0') {
                return false;
            }

        }
        return true;
    }
}
