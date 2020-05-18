package com.xie.leetcode.binarySearchRotated33;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {3,1};
        System.out.println(s.search(nums, -1));
        System.out.println(s.search(nums, 0));
        System.out.println(s.search(nums, 1));
        System.out.println(s.search(nums, 2));
        System.out.println(s.search(nums, 3));
        System.out.println(s.search(nums, 4));
        System.out.println(s.search(nums, 5));
        System.out.println(s.search(nums, 6));
        System.out.println(s.search(nums, 7));
        System.out.println(s.search(nums, 8));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= nums[left]) {
                // 左边区间为有序区间
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                // 右边区间为有序区间
                // 为了同上面使用上边界，这里需要强制使用mid - 1
                // 只有一个元素的时候，不会进while循环
                // 只有两个元素的时候，mid取得是上天棚，所以mid - 1不会越界
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
