package com.xie.leetcode.binarySearchRotatedMin154;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
//        int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {2,3,4,5,1,2};
//        int[] nums = {2,1};
        System.out.println(s.findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                if (nums[left] < nums[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return nums[left];
    }
}
