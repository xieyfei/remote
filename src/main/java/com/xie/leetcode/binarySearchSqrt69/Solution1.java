package com.xie.leetcode.binarySearchSqrt69;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int left = 1;
        int right = x - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
