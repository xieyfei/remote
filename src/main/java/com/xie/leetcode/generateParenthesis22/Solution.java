package com.xie.leetcode.generateParenthesis22;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.generateParenthesis(3));
        System.out.println(s.generateParenthesis(4));
    }

    private List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper("", n, 0, 0);
        return list;
    }

    private void helper(String str, int n, int left, int right) {
        if (left > n) {
            return;
        }
        if (str.length() == (n << 1)) {
            if (left == right) {
                list.add(str);
            }
            return;
        }
        if (left > right) {
            helper(str + ')', n, left, right + 1);
        }
        helper(str + '(', n, left + 1, right);
    }
}
