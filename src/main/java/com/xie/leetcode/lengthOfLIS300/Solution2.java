package com.xie.leetcode.lengthOfLIS300;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {3,2,1};
        System.out.println(s.lengthOfLIS(nums));
    }

    /**
     * 贪心+二分
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        int[] tail = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = findGe(tail, len, nums[i]);
            tail[j] = nums[i];
            if (j == len) {
                len++;
            }
        }
        return len;
    }

    private int findGe(int[] tail, int len, int k) {
        int left = 0;
        int right = len;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tail[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
