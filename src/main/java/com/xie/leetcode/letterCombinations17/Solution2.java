package com.xie.leetcode.letterCombinations17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 非递归解法
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.letterCombinations("23"));
    }

    char[][] mapping = {"abc".toCharArray(), "def".toCharArray(), "ghi".toCharArray(), "jkl".toCharArray(),
            "mno".toCharArray(), "pqrs".toCharArray(), "tuv".toCharArray(), "wxyz".toCharArray()};

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits == null || digits.isEmpty()) {
            return list;
        }
        int length = digits.length();
        List<String> queue = new ArrayList<>();
        queue.add("");
        int pos = 0;
        int count = 0;
        int level = queue.size();
        while (!queue.isEmpty()) {
            char[] chars = mapping[digits.charAt(pos) - '2'];
            String sb = queue.remove(0);
            for (char ch : chars) {
                String tmp = sb + ch;
                if (pos == length - 1) {
                    list.add(tmp);
                } else {
                    queue.add(tmp);
                }
            }
            count++;
            if (count == level) {
                pos++;
                count = 0;
                level = queue.size();
            }
        }
        return list;
    }
}
