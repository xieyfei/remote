package com.xie.leetcode.splitIntoFibonacci842;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitIntoFibonacci1 {

    public List<Integer> splitIntoFibonacci(String S) {
        int size1 = S.startsWith("0") ? 1 : 10;
        int up = S.length() / 2;
        for (int len1 = 1; len1 <= size1 && len1 <= up; len1++) {
            long t1 = Long.parseLong(S.substring(0, len1));
            if (t1 > Integer.MAX_VALUE) {
                break;
            }
            int size2 = S.substring(len1).startsWith("0") ? 1 : 10;
            long i1 = t1;
            for (int len2 = 1, max = Math.max(len1, len2); len2 <= size2 && len1 + len2 + max <= S.length(); len2++, i1 = t1, max = Math.max(len1, len2)) {
                List<Integer> ret = new ArrayList<>();
                long i2 = Long.parseLong(S.substring(len1, len1 + len2));
                if (i2 > Integer.MAX_VALUE) {
                    break;
                }
                ret.add(Math.toIntExact(i1));
                ret.add(Math.toIntExact(i2));
                int start = len1 + len2;
                while (start < S.length()) {
                    long i3 = i1 + i2;
                    if (i3 > Integer.MAX_VALUE) {
                        break;
                    }
                    String s3 = String.valueOf(i3);
                    if (!S.substring(start).startsWith(s3)) {
                        break;
                    }
                    ret.add(Math.toIntExact(i3));
                    i1 = i2;
                    i2 = i3;
                    start += s3.length();
                }
                if (start == S.length() && ret.size() >= 3) return ret;
            }
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        SplitIntoFibonacci1 s = new SplitIntoFibonacci1();
//        System.out.println(s.splitIntoFibonacci("011235"));
//        System.out.println(s.splitIntoFibonacci("123456579"));
        System.out.println(s.splitIntoFibonacci("11235813"));
        System.out.println(s.splitIntoFibonacci("112358130"));
        System.out.println(s.splitIntoFibonacci("0123"));
        System.out.println(s.splitIntoFibonacci("1101111"));
    }
}
