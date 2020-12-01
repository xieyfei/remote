package com.xie.leetcode.reorganizeString767;

import java.util.TreeSet;

public class ReorganizeString1 {

    private static class Key {
        int count;
        char c;

        public Key(int count, char c) {
            this.count = count;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Key{" +
                    "count=" + count +
                    ", c=" + c +
                    '}';
        }
    }

    public String reorganizeString(String S) {
        int max = (S.length() + 1) / 2;
        int[] countArr = new int[26];
        for (char c : S.toCharArray()) {
            int index = c - 'a';
            countArr[index]++;
            if (countArr[index] > max) return "";
        }
        TreeSet<Key> set = new TreeSet<>((k1, k2) -> k1.count == k2.count ? k1.c - k2.c : k2.count - k1.count);
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 0) {
                set.add(new Key(countArr[i], (char) (i + 'a')));
            }
        }
        Key lastKey = null;
        StringBuilder sb = new StringBuilder();
        while (!set.isEmpty()) {
            Key first = set.pollFirst();
            if (lastKey != null && first == lastKey && !set.isEmpty()) {
                Key second = set.pollFirst();
                sb.append(second.c);
                second.count--;
                lastKey = second;
                if (second.count > 0) {
                    set.add(second);
                }
            } else {
                sb.append(first.c);
                first.count--;
                lastKey = first;
            }
            if (first.count > 0) {
                set.add(first);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString1 r = new ReorganizeString1();
        System.out.println(r.reorganizeString("aaabcc"));
        System.out.println(r.reorganizeString("aab"));
        System.out.println(r.reorganizeString("aaab"));
    }
}
