package com.xie.leetcode.binarySearchGuessGame374;

public class Solution1 {

    private int p;

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.p = 6;
        System.out.println(s.guessNumber(10));
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int res = guess(mid);
            if (res >= 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int guess(int n) {
        return -Integer.compare(n, p);
    }
}
