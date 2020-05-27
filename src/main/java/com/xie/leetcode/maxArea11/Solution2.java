package com.xie.leetcode.maxArea11;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(height));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
