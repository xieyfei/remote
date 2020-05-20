package com.xie.leetcode.binarySearchFindDuplicate287;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {1,3,4,2,2};
        System.out.println(s.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countLessThan(nums, mid) <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLessThan(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num <= mid) {
                count++;
            }
        }
        return count;
    }
}
