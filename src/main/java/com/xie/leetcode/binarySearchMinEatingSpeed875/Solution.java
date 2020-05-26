package com.xie.leetcode.binarySearchMinEatingSpeed875;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {3,6,7,11};
//        System.out.println(s.countH(piles, 11));
//        System.out.println(s.countH(piles, 12));
//        System.out.println(s.countH(piles, 10));
//        System.out.println(s.countH(piles, 8));
//        System.out.println(s.countH(piles, 7));
//        System.out.println(s.countH(piles, 6));
//        System.out.println(s.countH(piles, 5));
//        System.out.println(s.countH(piles, 4));
        System.out.println(s.minEatingSpeed(piles, 8));
        System.out.println(s.minEatingSpeed(piles, 7));
    }

    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = 1;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (countH(piles, mid) > H) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countH(int[] piles, int k) {
        int count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += piles[i] / k;
            if (piles[i] % k > 0) {
                count++;
            }
        }
        return count;
    }
}
