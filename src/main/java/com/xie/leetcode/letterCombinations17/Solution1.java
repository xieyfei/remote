package com.xie.leetcode.letterCombinations17;

import java.util.LinkedList;
import java.util.List;

/**
 * 递归解法
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.letterCombinations("233456789"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits == null || digits.isEmpty()) {
            return list;
        }
        char[] chs = new char[digits.length()];
        char[][] mapping = {"abc".toCharArray(), "def".toCharArray(), "ghi".toCharArray(), "jkl".toCharArray(),
                            "mno".toCharArray(), "pqrs".toCharArray(), "tuv".toCharArray(), "wxyz".toCharArray()};
        helper(list, chs, 0, digits.toCharArray(), mapping);
        return list;
    }

    public void helper(List<String> list, char[] res, int pos, char[] target, char[][] mapping) {
        if (pos == target.length) {
            list.add(new String(res));
            return;
        }
        char[] chars = mapping[target[pos] - '2'];
        for (int i = 0; i < chars.length; i++) {
            res[pos] = chars[i];
            helper(list, res, pos + 1, target, mapping);
        }
    }
}
