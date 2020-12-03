package com.xie.leetcode.binarySearchRotated33;

public class Solution3 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.search(new int[]{1,3}, 3));
        System.out.println(s.search(new int[]{5,1,3}, 3));
        System.out.println(s.search(new int[]{5,1,2,3,4}, 1));
    }
}
