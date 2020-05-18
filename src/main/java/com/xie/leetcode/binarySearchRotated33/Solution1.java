package com.xie.leetcode.binarySearchRotated33;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {3,1};
//        System.out.println(s.search(nums, -1));
//        System.out.println(s.search(nums, 0));
        System.out.println(s.search(nums, 1));
//        System.out.println(s.search(nums, 2));
        System.out.println(s.search(nums, 3));
//        System.out.println(s.search(nums, 4));
//        System.out.println(s.search(nums, 5));
//        System.out.println(s.search(nums, 6));
//        System.out.println(s.search(nums, 7));
//        System.out.println(s.search(nums, 8));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] > target) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target || nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                int mid = left + (right - left + 1) / 2;
                if (nums[mid] > target || nums[mid] < nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
