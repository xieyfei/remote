package com.xie.leetcode.moveZeroes283;

import java.util.Arrays;

public class MoveZeroes2 {

//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                change(nums, left, right);
                ++left;
            }
            ++right;
        }
    }

    private void change(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        MoveZeroes2 m = new MoveZeroes2();
        int[] arr = {0, 1, 0, 3, 12};
        m.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
