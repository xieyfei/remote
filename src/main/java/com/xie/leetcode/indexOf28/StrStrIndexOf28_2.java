package com.xie.leetcode.indexOf28;

import java.util.Arrays;

public class StrStrIndexOf28_2 {

    public static void main(String[] args) {
        StrStrIndexOf28_2 s = new StrStrIndexOf28_2();
//        System.out.println(s.strStr("hello", "ll"));
//        System.out.println(s.strStr("mississippi", "issipi"));
//        System.out.println(s.strStr("abcabcabcd", "abcabcd"));
//        System.out.println(s.strStr("abcabcabcd", "abcd"));
//        System.out.println(s.strStr("aabaaabaaac", "aabaaac"));
        System.out.println(s.strStr("ababcaababcaabc", "ababcaabc"));
//        System.out.println(Arrays.toString(s.getRollbackArr("ababcaabc".toCharArray())));
//        System.out.println(Arrays.toString(s.getRollbackArr("aabaaac".toCharArray())));
//        System.out.println(Arrays.toString(s.getRollbackArr("issipi".toCharArray())));
//        System.out.println(Arrays.toString(s.getRollbackArr("aaaacaab".toCharArray())));
//        System.out.println(Arrays.toString(s.getRollbackArr("abcabcabcd".toCharArray())));
    }

    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        if (need.length == 0) return 0;
        if (hay.length < need.length) return -1;
        int i = 0;
        int j = 0;
        int[] rollback = getRollbackArr(need);
        while (i < hay.length) {
            for (; j < need.length && i < hay.length && hay[i] == need[j]; i++, j++);
            if (j == need.length) {
                return i - j;
            }
            if (j == 0) {
                i += 1;
            } else {
                j = rollback[j - 1] + 1;
            }
        }
        return -1;
    }

    public int[] getRollbackArr(char[] need) {
        int[] rollback = new int[need.length];
        Arrays.fill(rollback, -1);
        int i = 0;
        int j = 1;
        int prei = i;
        while (i < need.length) {
            for (; j < need.length && i < need.length && need[i] == need[j]; i++, j++) {
                rollback[j] = i;
            }
            if (j == need.length || i == need.length) {
                break;
            }
            if (prei == i) {
                i = 0;
                j++;
            } else if (rollback[j - 1] > 0) {
                i = rollback[j - 1];
            } else {
                i = 0;
            }
            prei = i;
        }
        return rollback;
    }
//        aaaacaab
//        aaaab
//        aaaacaab
//         aaaab

//        abcdaaab
//        abcde
//            abcde

//        abcabcabcd
//        abcabcd

//        abacdaba
//        abcdabce

//           abcabcabcd
//        abcabcabcd
//           abcabcabcd

//     aabaaac
//      aabaaac
//       aabaaac
//  aabaaac
}
