package com.xie.leetcode.spiralOrder54;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder1 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols;
        List<Integer> ret = new ArrayList<>(total);
        int row = 0, col = 0, index = 0;
        for (int i = 0; i < total; i++) {
            ret.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + direct[index][0], nextCol = col + direct[index][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                index = (index + 1) % 4;
            }
            row = row + direct[index][0];
            col = col + direct[index][1];
        }
        return ret;
    }

    public static void main(String[] args) {
        SpiralOrder1 s = new SpiralOrder1();
//        int[][] matrix = new int[3][];
//        matrix[0] = new int[]{1, 2, 3, 4};
//        matrix[1] = new int[]{5, 6, 7, 8};
//        matrix[2] = new int[]{9,10,11,12};
//        int[][] matrix = new int[2][];
//        matrix[0] = new int[]{3};
//        matrix[1] = new int[]{2};
        int[][] matrix = new int[1][];
        matrix[0] = new int[]{6,9,7};
        System.out.println(s.spiralOrder(matrix));
    }
}
