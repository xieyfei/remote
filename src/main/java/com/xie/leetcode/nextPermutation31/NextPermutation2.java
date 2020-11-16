package com.xie.leetcode.nextPermutation31;

import java.util.Arrays;

public class NextPermutation2 {

    public static void main(String[] args) {
        NextPermutation2 n = new NextPermutation2();
        int[] nums = {1,2};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 1) return;
        int i = len - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = len - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            change(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void change(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            change(nums, start, end);
            start++;
            end--;
        }
    }
}
