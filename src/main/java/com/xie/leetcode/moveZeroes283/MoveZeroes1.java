package com.xie.leetcode.moveZeroes283;

import java.util.Arrays;

public class MoveZeroes1 {

//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = Math.max(j, i + 1);
                for (; j < nums.length && nums[j] == 0; j++);
                if (j >= nums.length) {
                    break;
                }
                change(nums, i, j);
            }
        }
    }

    private void change(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        MoveZeroes1 m = new MoveZeroes1();
        int[] arr = {0, 1, 0, 3, 12};
        m.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
