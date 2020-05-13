package com.xie.leetcode.removeduplicates;

import java.util.Arrays;

public class RemoveDuplicates26_2 {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = {0,0,0,0,3};
//        int[] nums = {1,1};
//        System.out.println(findNextDiffPos(nums, 0, 1, nums.length - 1));
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int rmSize = 0;
        for (int i = 0; i < nums.length - rmSize - 1; i++) {
            int pos = i + 1;
            while (pos < nums.length - rmSize && nums[i] == nums[pos]) {
                pos++;
            }
            if (pos == i + 1) continue;
            int tmp = pos - i - 1;
            for (int j = i + 1; pos < nums.length - rmSize; j++, pos++) {
                nums[j] = nums[pos];
            }
            rmSize += tmp;
        }
        return nums.length - rmSize;
    }
}
