package com.xie.leetcode.findMinArrowShots452;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots2 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int tmp = points[0][1];
        for (int[] point : points) {
            if (tmp < point[0]) {
                tmp = point[1];
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindMinArrowShots2 f = new FindMinArrowShots2();
        int[][] p = new int[4][];
        p[0] = new int[]{1, 2};
        p[1] = new int[]{3, 4};
        p[2] = new int[]{5, 6};
        p[3] = new int[]{7, 8};
        System.out.println(f.findMinArrowShots(p));
    }
}
