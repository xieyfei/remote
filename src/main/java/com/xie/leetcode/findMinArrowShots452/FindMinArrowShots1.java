package com.xie.leetcode.findMinArrowShots452;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots1 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int count = 0;
        int[] tmp = null;
        for (int[] point : points) {
            if (tmp != null && tmp[1] >= point[0]) {
                tmp[0] = point[0];
                tmp[1] = Math.min(tmp[1], point[1]);
            } else {
                ++count;
                tmp = point;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindMinArrowShots1 f = new FindMinArrowShots1();
        int[][] p = new int[4][];
        p[0] = new int[]{1, 2};
        p[1] = new int[]{3, 4};
        p[2] = new int[]{5, 6};
        p[3] = new int[]{7, 8};
        System.out.println(f.findMinArrowShots(p));
    }
}
