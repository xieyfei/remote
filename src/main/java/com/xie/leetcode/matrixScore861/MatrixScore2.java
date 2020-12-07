package com.xie.leetcode.matrixScore861;

public class MatrixScore2 {

    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                reverseRow(A, i);
            }
        }
        for (int i = 1; i < A[0].length; i++) {
            if (needReverse(A, i)) {
                reverseCol(A, i);
            }
        }
        return sum(A);
    }

    private boolean needReverse(int[][] arr, int col) {
        int countZ = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][col] == 0) {
                countZ++;
            }
        }
        return countZ > arr.length - countZ;
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
        MatrixScore2 m = new MatrixScore2();
        long start = System.currentTimeMillis();
//        System.out.println(m.matrixScore(new int[][]{{0}, {1}}));
        int[][] arr = new int[][]{{0,0,0},{0,1,0},{0,1,0},{0,1,1},{0,0,0},{1,1,0},{1,0,1},{0,1,0},{0,0,1}};
        System.out.println(m.matrixScore(arr));
        System.out.println(System.currentTimeMillis() - start);
    }
}
