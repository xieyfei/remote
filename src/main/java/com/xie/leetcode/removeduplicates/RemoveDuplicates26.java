package com.xie.leetcode.removeduplicates;

public class RemoveDuplicates26 {

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int[] nums = {0,0,0,0,3};
        System.out.println(findNextDiffPos(nums, 0, 1, nums.length - 1));
//        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int rmSize = 0;
        for (int i = 0; i < nums.length - rmSize - 1; i++) {
            int pos = findNextDiffPos(nums, i, i + 1, nums.length - rmSize - 1);
            if (pos == i + 1) continue;
            int tmp = pos - i - 1;
            for (int j = i + 1; pos < nums.length - rmSize; j++, pos++) {
                nums[j] = nums[pos];
            }
            rmSize += tmp;
        }
        return nums.length - rmSize;
    }

    public static int findNextDiffPos(int[] nums, int cur, int start, int end) {
        while (true) {
            int mid = start + (end - start) / 2;
            if (nums[cur] >= nums[end]) {
                return end + 1;
            } else if (mid >= end) {
                return end;
            } else if (nums[cur] >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
    }
}
