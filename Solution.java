class Solution {
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 1;

        if (grid[i][j] == 2)
            return 0;

        grid[i][j] = 2;

        int peri = 0;
        for (int k = 0; k < 4; k++) {
            int nextX = i + dir[k][0];
            int nextY = j + dir[k][1];
            peri += dfs(grid, nextX, nextY);
        }
        return peri;
    }
}