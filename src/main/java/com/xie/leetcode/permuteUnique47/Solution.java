package com.xie.leetcode.permuteUnique47;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {1,1,2};
        int[] nums = {1,1,2,1};
        System.out.println(s.permuteUnique(nums));
    }

    private List<List<Integer>> list = new ArrayList<>();
    private Integer[] res;
    private boolean[] flag;
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums != null && nums.length > 0) {
            res = new Integer[nums.length];
            flag = new boolean[nums.length];
            helper(nums, 0);
        }
        return list;
    }

    private void helper(int[] nums, int pos) {
        if (pos == nums.length) {
            list.add(new ArrayList<>(Arrays.asList(res)));
            return;
        }
        Set<Integer> set = new HashSet<>((int)(nums.length / 0.75) + 1);
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] || set.contains(nums[i])) {
                continue;
            } else {
                set.add(nums[i]);
                res[pos] = nums[i];
                flag[i] = true;
                helper(nums, pos + 1);
                flag[i] = false;
            }
        }
    }
}
