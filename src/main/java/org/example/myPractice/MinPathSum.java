package org.example.myPractice;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        int minPath = minPathSum(grid);
        System.out.println("二维数组的最小路径和为: " + minPath);
    }

    public static int minPathSum(int[][] grid) {
        /**
         * minPathSum 方法接受一个二维数组 grid，表示路径上的数字。
         * 我们使用一个同样大小的二维数组 dp 来存储从起点 (0, 0) 到每个位置 (i, j) 的最小路径和。
         * 首先初始化起点 (0, 0)，然后分别初始化第一行和第一列的路径和。
         * 接着，使用动态规划的思想，计算每个位置 (i, j) 的最小路径和，即
         * dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])。
         * 最后，返回右下角 (m-1, n-1) 的最小路径和，即为所求。
         */
        int m = grid.length;
        int n = grid[0].length;

        // 创建一个与原数组相同大小的数组来存储最小路径和
        int[][] dp = new int[m][n];

        // 初始化起点
        dp[0][0] = grid[0][0];

        // 初始化第一行和第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 动态规划求解最小路径和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // 返回右下角的最小路径和
        return dp[m - 1][n - 1];
    }
}
