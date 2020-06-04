package com.xie.leetcode.permute46;

import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {};
//        int[] nums = {1,2,3};
//        int[] nums = {1,2,3,4};
        System.out.println(s.permute(nums));
    }

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, new Integer[nums.length], 0, new HashSet<>());
        return res;
    }

    private void helper(int[] nums, Integer[] temp, int pos, Set<Integer> cur) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(Arrays.asList(temp)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(i)) {
                continue;
            }
            temp[pos] = nums[i];
            cur.add(i);
            helper(nums, temp, pos + 1, cur);
            cur.remove(i);
        }
    }
}
