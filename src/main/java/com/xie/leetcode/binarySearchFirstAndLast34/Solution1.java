package com.xie.leetcode.binarySearchFirstAndLast34;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
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
            // 取大于等于target的第一个数
            // [left, mid]      [mid+1, right]
            // 不可能存在区间     可能存在区间
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
            // 当出现left = mid时，需要上中位数
            int mid = left + (right - left + 1) / 2;
            // 取小于等于的最后一个数
            // [left, mid+1]    [mid, right]
            // 可能存在区间       不可能存在区间
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
