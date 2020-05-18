package com.xie.leetcode.searchInsert35;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {1,3,5,6};
        System.out.println(s.searchInsert(nums, 5));
//        System.out.println(s.searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
