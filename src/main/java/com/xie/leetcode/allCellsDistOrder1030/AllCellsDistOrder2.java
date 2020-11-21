package com.xie.leetcode.allCellsDistOrder1030;

import java.util.ArrayList;
import java.util.List;

public class AllCellsDistOrder2 {

//    |r1 - r2| + |c1 - c2|
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - r0 - 1) + Math.max(c0, C - c0 - 1);
        List<List<int[]>> bucket = new ArrayList<>(maxDist + 1);
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<>());
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                bucket.get(dist).add(new int[]{i, j});
            }
        }
        List<int[]> res = new ArrayList<>(R * C + 1);
        for (List<int[]> bu : bucket) {
            res.addAll(bu);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        AllCellsDistOrder2 a = new AllCellsDistOrder2();
        int[][] ints = a.allCellsDistOrder(2, 3, 1, 2);
//        int[][] ints = a.allCellsDistOrder(2, 2, 0, 1);
//        int[][] ints = a.allCellsDistOrder(1, 2, 0, 0);
        System.out.println("");
    }
}
