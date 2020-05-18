package com.xie.leetcode.binarySearchRotated33;

public class Solution1 {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > nums[0]) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
