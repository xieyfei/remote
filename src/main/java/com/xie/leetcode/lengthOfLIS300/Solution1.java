package com.xie.leetcode.lengthOfLIS300;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {3,2,1};
        System.out.println(s.lengthOfLIS(nums));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max + 1;
    }
}
