package com.xie.leetcode.allCellsDistOrder1030;


public class AllCellsDistOrder3 {

    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - r0 - 1) + Math.max(c0, C - c0 - 1);
        int[][] ret = new int[R * C][];
        int row = r0,  col = c0;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        AllCellsDistOrder3 a = new AllCellsDistOrder3();
        int[][] ints = a.allCellsDistOrder(2, 3, 1, 2);
//        int[][] ints = a.allCellsDistOrder(2, 2, 0, 1);
//        int[][] ints = a.allCellsDistOrder(1, 2, 0, 0);
        System.out.println("");
    }
}
