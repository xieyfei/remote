package com.xie.leetcode.binarySearchRotated81;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {1, 1};
        System.out.println(s.search(nums, 0));
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[left]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] == target) {
                    return true;
                } else {
                    left++;
                }
            }
        }
        return nums[left] == target;
    }
}
