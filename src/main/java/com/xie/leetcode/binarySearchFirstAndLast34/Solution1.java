package com.xie.leetcode.binarySearchFirstAndLast34;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {5,7,7,8,8,8,10};
        System.out.println(Arrays.toString(s.searchRange(nums, 8)));
        System.out.println(Arrays.toString(s.searchRange(nums, 6)));
        System.out.println(Arrays.toString(s.searchRange(nums, 5)));
        System.out.println(Arrays.toString(s.searchRange(nums, 10)));
        System.out.println(Arrays.toString(s.searchRange(nums, 11)));
        System.out.println(Arrays.toString(s.searchRange(new int[]{}, 0)));
    }

    public int[] searchRange(int[] nums, int target) {
        int first = searchFirst(nums, target);
        int last = searchLast(nums, target);
        return new int[]{first, last};
    }

    public int searchFirst(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public int searchLast(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
