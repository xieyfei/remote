package com.xie.leetcode.reorganizeString767;

import java.util.TreeSet;

public class ReorganizeString2 {

    public String reorganizeString(String S) {
        int max = (S.length() + 1) / 2;
        int[] countArr = new int[26];
        for (char c : S.toCharArray()) {
            int index = c - 'a';
            countArr[index]++;
            if (countArr[index] > max) return "";
        }
        TreeSet<Character> set = new TreeSet<>((k1, k2) -> {
            int i1 = k1 - 'a';
            int i2 = k2 - 'a';
            return countArr[i1] == countArr[i2] ? k1 - k2 : countArr[i2] - countArr[i1];
        });
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                set.add((char) (i + 'a'));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (set.size() > 1) {
            Character first = set.pollFirst();
            Character second = set.pollFirst();
            int indexFir = first - 'a';
            int indexSec = second - 'a';
            sb.append(first);
            sb.append(second);
            countArr[indexFir]--;
            countArr[indexSec]--;
            if (countArr[indexFir] > 0) {
                set.add(first);
            }
            if (countArr[indexSec] > 0) {
                set.add(second);
            }
        }
        if (!set.isEmpty()) {
            sb.append(set.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString2 r = new ReorganizeString2();
        System.out.println(r.reorganizeString("aaabcc"));
        System.out.println(r.reorganizeString("aab"));
        System.out.println(r.reorganizeString("aaab"));
    }
}
