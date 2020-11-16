package com.xie.leetcode.nextPermutation31;

import java.util.Arrays;

public class NextPermutation1 {

    public static void main(String[] args) {
        NextPermutation1 n = new NextPermutation1();
        int[] nums = {1,2};
        n.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (nums == null || len == 1) return;
        int lastNe = len - 2;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[len - 1]) {
                insert(nums, len - 1, i);
                return;
            } else if (nums[i] > nums[len - 1]) {
                lastNe = i;
                break;
            }
        }
        int from = 0;
        while (true) {
            int idx = findLastReverse(nums, lastNe);
            if (idx > 0) {
                int minIdx = findMinIdxAndGreatThan(nums, idx, len, nums[idx - 1]);
                if (minIdx == -1) {
                    lastNe = idx - 1;
                    continue;
                }
                change(nums, idx - 1, minIdx);
                from = idx;
            }
            break;
        }
        Arrays.sort(nums, from, len);
    }

    private void insert(int[] nums, int from, int to) {
        int tmp = nums[from];
        for (int i = from; i > to; i--) {
            nums[i] = nums[i - 1];
        }
        nums[to] = tmp;
    }

    private void change(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    private int findLastReverse(int[] nums, int lastNe) {
        for (int i = lastNe; i > 0; i--) {
            if (nums[i - 1] < nums[i] && nums[i] >= nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    private int findMinIdxAndGreatThan(int[] nums, int from, int to, int value) {
        int minIdx = from;
        boolean has = false;
        for (int i = from; i < to; i++) {
            if (nums[i] > value) {
                has = true;
                if (nums[i] < nums[minIdx]) {
                    minIdx = i;
                }
            }
        }
        return has ? minIdx : -1;
    }
}
