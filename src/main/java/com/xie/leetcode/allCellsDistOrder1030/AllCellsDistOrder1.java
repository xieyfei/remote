package com.xie.leetcode.allCellsDistOrder1030;

import java.util.ArrayList;
import java.util.List;

public class AllCellsDistOrder1 {

//    |r1 - r2| + |c1 - c2|
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<>(R * C);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res.add(new int[]{i, j});
            }
        }
        res.sort((o1, o2) -> {
            int d1 = Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0);
            int d2 = Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0);
            return d1 - d2;
        });
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        AllCellsDistOrder1 a = new AllCellsDistOrder1();
//        int[][] ints = a.allCellsDistOrder(2, 3, 1, 2);
//        int[][] ints = a.allCellsDistOrder(2, 2, 0, 1);
        int[][] ints = a.allCellsDistOrder(1, 2, 0, 0);
        System.out.println("");
    }
}
