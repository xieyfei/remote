package com.xie.leetcode.removeElement27;

import java.util.Arrays;

public class RemoveElement27_2 {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {3,2,2,3};
//        System.out.println(removeElement(nums, 2));
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            while (nums[start] != val && start++ < end);
            while (nums[end] == val && start < end--);
            if (start < end) {
                nums[start] = nums[end];
                end--;
            }
        }
        return start;
    }
}
