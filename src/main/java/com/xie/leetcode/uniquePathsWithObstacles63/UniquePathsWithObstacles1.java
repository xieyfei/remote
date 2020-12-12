package com.xie.leetcode.uniquePathsWithObstacles63;

public class UniquePathsWithObstacles1 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length, col = obstacleGrid[0].length;
        if (obstacleGrid[row - 1][col - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i - 1][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < col; i++) {
            if (obstacleGrid[0][i - 1] == 0) {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int up = 0, left = 0;
                if (obstacleGrid[i - 1][j] == 0) {
                    up = dp[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] == 0) {
                    left = dp[i][j - 1];
                }
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles1 u = new UniquePathsWithObstacles1();
        System.out.println(u.uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}}));
    }
}
