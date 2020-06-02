package com.xie.leetcode.divide29;

public class Solution2 {

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.divide(-2147483648, 1));
        System.out.println(s.divide(10, 3));
        System.out.println(s.divide(7, -3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == -(1 << 31)) return (1 << 31) - 1;
            return -dividend;
        }
        long usDd = dividend, usDs = divisor;
        boolean sign = false;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            sign = true;
        }
        usDd = usDd > 0 ? usDd : -usDd;
        usDs = usDs > 0 ? usDs : -usDs;
        long i = div(usDd, usDs);
        if (sign) {
            return Math.toIntExact(i);
        } else {
            return Math.toIntExact(-i);
        }
    }

    private long div(long usDd, long usDs) {
        if (usDd < usDs) return 0;
        long i = 1;
        long sum = usDs;
        while (sum + sum <= usDd) {
            i += i;
            sum += sum;
        }
        return i + div(usDd - sum, usDs);
    }
}
