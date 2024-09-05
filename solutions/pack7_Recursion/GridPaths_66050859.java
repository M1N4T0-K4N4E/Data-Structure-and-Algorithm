package solutions.pack7_Recursion;

public class GridPaths_66050859 {

    public static int numberOfPaths(int grid [][]) {
        // check
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        
        return countPaths(grid, 0, 0);
    }

    private static int countPaths(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // Base when overflow or hit obstacle
        if (i >= m || j >= n || grid[i][j] == 1) {
            return 0;
        }

        // hit end
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // traverse via recursion
        int rightPaths = countPaths(grid, i, j + 1);
        int downPaths = countPaths(grid, i + 1, j);
        return rightPaths + downPaths;
    }
}
