package com.xie.leetcode.divide29;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648, 1));
        System.out.println(s.divide(10, 3));
        System.out.println(s.divide(7, -3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return dividend;
        int side = -(1 << 31);
        if (dividend == side && divisor == -1) return (1 << 31) - 1;
        long usDd, usDs;
        boolean sDd, sDs;
        if (dividend > 0) {
            usDd = dividend;
            sDd = true;
        } else {
            usDd = dividend;
            usDd = -usDd;
            sDd = false;
        }
        if (divisor > 0) {
            usDs = divisor;
            sDs = true;
        } else {
            usDs = divisor;
            usDs = -usDs;
            sDs = false;
        }
        long i = 1;
        long sum = usDs;
        while (sum + sum <= usDd) {
            i += i;
            sum += sum;
        }
        while (sum <= usDd) {
            i++;
            sum += usDs;
        }
        i--;
        if ((sDd && sDs) || (!sDd && !sDs)) {
            return Math.toIntExact(i);
        } else {
            return Math.toIntExact(-i);
        }
    }
}
