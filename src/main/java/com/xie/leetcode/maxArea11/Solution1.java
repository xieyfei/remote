package com.xie.leetcode.maxArea11;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(height));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int[] dp = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(Math.min(height[i], height[j]) * (i - j), dp[i]);
            }
        }
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
