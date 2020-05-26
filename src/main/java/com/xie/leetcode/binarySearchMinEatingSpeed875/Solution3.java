package com.xie.leetcode.binarySearchMinEatingSpeed875;

public class Solution3 {

    public static void main(String[] args) {
        Solution3 s = new Solution3();
//        int[] piles = {3,6,7,11};
        int[] piles = {312884470};
//        System.out.println(s.countH(piles, 11));
//        System.out.println(s.countH(piles, 12));
//        System.out.println(s.countH(piles, 10));
//        System.out.println(s.countH(piles, 8));
//        System.out.println(s.countH(piles, 7));
//        System.out.println(s.countH(piles, 6));
//        System.out.println(s.countH(piles, 5));
//        System.out.println(s.countH(piles, 4));
//        System.out.println(s.minEatingSpeed(piles, 8));
//        System.out.println(s.minEatingSpeed(piles, 7));
        System.out.println(s.minEatingSpeed(piles, 968709470));

    }

    public int minEatingSpeed(int[] piles, int H) {
        int right = 1;
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
            right = Math.max(right, piles[i]);
        }
        int left = Math.max(sum / H, 1);
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
        for (int pile : piles) {
            count += (pile + k - 1) / k;
        }
        return count;
    }
}
