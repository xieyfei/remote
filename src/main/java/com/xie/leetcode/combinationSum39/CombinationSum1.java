package com.xie.leetcode.combinationSum39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        inner(new int[501], candidates, target, 0, candidates.length - 1, 0);
        return result;
    }

    private void inner(int[] nums, int[] candidates, int target, int lastStart, int lastEnd, int location) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            for (int n : nums) {
                if (n == 0) break;
                list.add(n);
            }
            result.add(list);
            return;
        }
        int end = -1;
        for (int i = lastEnd; i >= lastStart; i--) {
            if (candidates[i] <= target) {
                end = i;
                break;
            }
        }
        for (int i = lastStart; i <= end; i++) {
            nums[location] = candidates[i];
            inner(nums, candidates, target - candidates[i], i, end, location + 1);
            nums[location] = 0;
        }
    }
}
