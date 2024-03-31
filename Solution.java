class Solution {
    int m, n;
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;

        int oldColor = image[sr][sc];

        if (oldColor != newColor)
            dfs(image, sr, sc, newColor, oldColor);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        image[sr][sc] = newColor;

        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oldColor) {
                dfs(image, nr, nc, newColor, oldColor);
            }
        }
    }
}