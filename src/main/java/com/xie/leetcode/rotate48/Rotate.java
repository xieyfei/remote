package com.xie.leetcode.rotate48;

public class Rotate {
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//    [
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
//    0,0 -> 0,3 -> 3,3 -> 3,0
//    0,1 -> 1,3 -> 3,2 -> 2,0
//    0,2 -> 2,3 -> 3,1 -> 1,0

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int len = matrix[i].length;
            int y = len - i - 1;
            for (int j = i; j < y; j++) {
                change(matrix, i, j, y, len - j - 1);
            }
        }
    }

    private void change(int[][] matrix, int i, int j, int y, int z) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[z][i];
        matrix[z][i] = matrix[y][z];
        matrix[y][z] = matrix[j][y];
        matrix[j][y] = tmp;
    }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int[][] m = new int[4][];
        m[0] = new int[]{ 5, 1, 9,11};
        m[1] = new int[]{2, 4, 8,10};
        m[2] = new int[]{13, 3, 6, 7};
        m[3] = new int[]{15,14,12,16};
        r.rotate(m);
    }
}
