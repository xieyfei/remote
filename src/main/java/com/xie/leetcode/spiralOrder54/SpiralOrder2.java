package com.xie.leetcode.spiralOrder54;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder2 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        List<Integer> ret = new ArrayList<>(rows * cols);
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                ret.add(matrix[top][col]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                ret.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    ret.add(matrix[bottom][col]);
                }
                for (int row = bottom; row > top; row--) {
                    ret.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ret;
    }

    public static void main(String[] args) {
        SpiralOrder2 s = new SpiralOrder2();
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
