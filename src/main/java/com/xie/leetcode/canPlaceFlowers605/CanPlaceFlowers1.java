package com.xie.leetcode.canPlaceFlowers605;

import java.util.Calendar;

public class CanPlaceFlowers1 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int len = flowerbed.length;
        if (n > len / 2 + 1) return false;
        int i = 0;
        boolean even = false;
        for (; i < len - 1; i += 2) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0
                    && (i == 0 || flowerbed[i - 1] == 0
                    || i >= len - 2 || flowerbed[i + 2] == 0)) {
                if (--n <= 0) {
                    break;
                }
            } else if (!even && flowerbed[i + 1] == 1) {
                even = true;
            } else if (even && flowerbed[i] == 1) {
                even = false;
            }
        }
        if (i == len - 1 && flowerbed[len - 1] == 0 && !even) {
            n--;
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers1 c = new CanPlaceFlowers1();
        System.out.println(c.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(c.canPlaceFlowers(new int[]{0,0,1,0,1}, 1));
        System.out.println(c.canPlaceFlowers(new int[]{0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0}, 17));
    }
}
