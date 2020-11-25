package com.xie.leetcode.sortString1370;


public class SortString2 {

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] bucket = new int[26];
        for (char c : chars) {
            bucket[c - 'a']++;
        }
        int idx = 0;
        char[] result = new char[chars.length];
        while (idx < result.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] > 0) {
                    result[idx++] = (char) (i + 'a');
                    bucket[i]--;
                }
            }
            for (int i = bucket.length - 1; i >= 0; i--) {
                if (bucket[i] > 0) {
                    result[idx++] = (char) (i + 'a');
                    bucket[i]--;
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        SortString2 s = new SortString2();
        System.out.println(s.sortString("aaaabbbbcccc"));
        System.out.println(s.sortString("rat"));
        System.out.println(s.sortString("leetcode"));
        System.out.println(s.sortString("ggggggg"));
        System.out.println(s.sortString("spo"));
        System.out.println(s.sortString("s"));
    }
}
