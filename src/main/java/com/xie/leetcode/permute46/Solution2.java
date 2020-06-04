package com.xie.leetcode.permute46;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[] nums = {};
        int[] nums = {1,2,3};
//        int[] nums = {1,2,3,4};
        System.out.println(s.permute(nums));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private Integer[] temp;
    private boolean[] flags;
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        temp = new Integer[nums.length];
        flags = new boolean[nums.length];
        helper(nums, 0);
        return res;
    }

    private void helper(int[] nums, int pos) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(Arrays.asList(temp)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flags[i]) {
                continue;
            }
            temp[pos] = nums[i];
            flags[i] = true;
            helper(nums, pos + 1);
            flags[i] = false;
        }
    }
}
