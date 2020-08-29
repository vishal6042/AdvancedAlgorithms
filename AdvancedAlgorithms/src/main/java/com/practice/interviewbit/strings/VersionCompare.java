package com.practice.interviewbit.strings;

import java.math.BigInteger;

public class VersionCompare {

    public static void main(String[] args) {
        VersionCompare vc = new VersionCompare();
        System.out.println(vc.compareVersion1("1.0.3", "1.0.4.1"));

    }

    public int compareVersion(String A, String B) {
        String a[] = A.split("\\.");
        String b[] = B.split("\\.");

        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (new BigInteger(a[i]).compareTo(new BigInteger(b[i])) > 0) {
                return 1;
            } else if (new BigInteger(a[i]).compareTo(new BigInteger(b[i])) < 0) {
                return -1;
            } else {
                i++;
                j++;
            }
        }
        while (i < a.length) {
            if (!new BigInteger(a[i]).equals(new BigInteger("0"))) {
                return 1;
            }
            i++;
        }
        while (j < b.length) {
            if (!new BigInteger(b[j]).equals(new BigInteger("0"))) {
                return -1;
            }
            j++;
        }
        return 0;
    }

    public int compareVersion1(String A, String B) {
        String a[] = A.split("\\.");
        String b[] = B.split("\\.");

        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[i]) > 0) {
                return 1;
            } else if (a[i].compareTo(b[i]) < 0) {
                return -1;
            } else {
                i++;
                j++;
            }
        }
        while (i < a.length) {
            if (!a[i].equals("0")) {
                return 1;
            }
            i++;
        }
        while (j < b.length) {
            if (!b[j].equals("0")) {
                return -1;
            }
            j++;
        }
        return 0;
    }
}
