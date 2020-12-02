package com.xie.leetcode.findMin154;

public class FindMin1 {
//    [2,2,2,0,1]
//    [3,3,1,3]
//    [1,3,3]
//    [3,1,1]
    private int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] == nums[right]) {
                while (mid < right && nums[mid] == nums[right]) {
                    right--;
                }
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMin1 f = new FindMin1();
        System.out.println(f.findMin(new int[]{3, 3, 1, 3}));
        System.out.println(f.findMin(new int[]{2,2,2,0,1}));
        System.out.println(f.findMin(new int[]{1, 2}));
        System.out.println(f.findMin(new int[]{2, 1}));
        System.out.println(f.findMin(new int[]{1, 1}));
        System.out.println(f.findMin(new int[]{3,1,1}));
    }
}
