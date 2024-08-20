package solutions.pack7_Recursion;

public class GridPaths_66050859 {

    public static int numberOfPaths(int grid [][]) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            return countPaths(grid, 0, 0, dp);
    }

    private static int countPaths(int[][] grid, int i, int j, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        // Base
        if (i >= m || j >= n || grid[i][j] == 1) {
            return 0;
        }

        // end
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int rightPaths = countPaths(grid, i, j + 1, dp);
        int downPaths = countPaths(grid, i + 1, j, dp);
        dp[i][j] = rightPaths + downPaths;
        return dp[i][j];
    }
}
