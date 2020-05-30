package com.xie.leetcode.letterCombinations17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 非递归解法2
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return list;
        }
        char[][] mapping = {"abc".toCharArray(), "def".toCharArray(), "ghi".toCharArray(), "jkl".toCharArray(),
                            "mno".toCharArray(), "pqrs".toCharArray(), "tuv".toCharArray(), "wxyz".toCharArray()};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            char[] chars = mapping[digits.charAt(i) - '2'];
            int size = list.size();
            for (int j = 0; j < size; j++) {
                String str = list.remove(0);
                for (char aChar : chars) {
                    list.add(str + aChar);
                }
            }
        }
        return list;
    }
}
