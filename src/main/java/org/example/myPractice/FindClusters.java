package org.example.myPractice;

public class FindClusters {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 1, 1}
        };

        int countClusters = findClusters(matrix);
        System.out.println("矩阵中独立的 cluster 数量为: " + countClusters);
    }
    public static int findClusters(int[][] matrix) {
        /**
         * 要找出一个 m*n 矩阵中有多少个独立的 cluster，其中所有相邻的 1 组成一个 cluster，
         * 可以使用深度优先搜索（DFS）或广度优先搜索（BFS）来实现。以下是一个使用 DFS 的 Java 实现示例：
         * 在这个示例中，我们假设输入的矩阵是一个二维数组 matrix，其中元素的值为 0 或 1。
         * 我们使用一个 visited 数组来标记每个位置是否已经访问过。然后，我们遍历整个矩阵，
         * 对每个未访问过的 1 进行深度优先搜索（DFS）。每次找到一个未访问过的 1，就递归地标记所有与之相邻的 1，
         * 并增加 cluster 的计数器。最后返回计数器的值，即为矩阵中独立的 cluster 的数量。
         */
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];
        int count = 0;

        // 遍历整个矩阵，找到所有的 cluster
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    // 找到一个未访问过的 1，进行深度优先搜索
                    dfs(matrix, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }
    private static void dfs(int[][] matrix, boolean[][] visited, int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 标记当前位置已访问过
        visited[row][col] = true;

        // 定义相邻位置的偏移量
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 深度优先搜索相邻的未访问过的 1
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n
                    && matrix[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(matrix, visited, newRow, newCol);
            }
        }
    }
}
