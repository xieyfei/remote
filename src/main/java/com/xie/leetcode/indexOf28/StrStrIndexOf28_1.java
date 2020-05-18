package com.xie.leetcode.indexOf28;

public class StrStrIndexOf28_1 {

    public static void main(String[] args) {
        StrStrIndexOf28_1 s = new StrStrIndexOf28_1();
//        System.out.println(s.strStr("hello", "ll"));
        System.out.println(s.strStr("mississippi", "issipi"));
    }

    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        if (hay.length < need.length) return -1;
        if (hay.length == 0) return 0;
        int i = 0;
        while (i < hay.length) {
            int j = 0;
            for (; j < need.length && i < hay.length && hay[i] == need[j]; i++, j++);
            if (j == need.length) {
                return i - j;
            }
            i -= j - 1;
        }
        return -1;
    }
}
