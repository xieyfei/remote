package com.xie.leetcode.matrixScore861;

public class MatrixScore1 {

    private int max = -1;
    public int matrixScore(int[][] A) {
        inner(A, 0, 0);
        return max;
    }

    private void inner(int[][] arr, int row, int col) {
        if (row >= arr.length || col >= arr[0].length) {
            return;
        }
        max = Math.max(max, sum(arr));
        inner(arr, row + 1, col);
        inner(arr, row, col + 1);
        reverseRow(arr, row);
        max = Math.max(max, sum(arr));
        inner(arr, row + 1, col);
        inner(arr, row, col + 1);
        reverseCol(arr, col);
        max = Math.max(max, sum(arr));
        inner(arr, row + 1, col);
        inner(arr, row, col + 1);
        reverseRow(arr, row);
        max = Math.max(max, sum(arr));
        inner(arr, row + 1, col);
        inner(arr, row, col + 1);
        reverseCol(arr, col);
    }

    private void reverseRow(int[][] arr, int row) {
        for (int i = 0; i < arr[0].length; i++) {
            arr[row][i] = 1 - arr[row][i];
        }
    }

    private void reverseCol(int[][] arr, int col) {
        for (int i = 0; i < arr.length; i++) {
            arr[i][col] = 1 - arr[i][col];
        }
    }

    private int sum(int[][] arr) {
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int sign = 1;
            for (int j = arr[i].length - 1; j >= 0; j--, sign *= 2) {
                sum += arr[i][j] * sign;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MatrixScore1 m = new MatrixScore1();
        long start = System.currentTimeMillis();
//        System.out.println(m.matrixScore(new int[][]{{0}, {1}}));
        System.out.println(m.matrixScore(new int[][]{{0,0,0},{0,1,0},{0,1,0},{0,1,1},{0,0,0},{1,1,0},{1,0,1},{0,1,0},{0,0,1}}));
        System.out.println(System.currentTimeMillis() - start);
    }
}
