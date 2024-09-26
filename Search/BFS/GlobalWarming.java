import java.util.*;

// https://www.luogu.com.cn/problem/P8662 很多种做法
public class GlobalWarming {
    static int N;
    static char[][] map;
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = scanner.next().toCharArray();
        }
        scanner.close();

        int island = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '#') {
                    dfs(i, j);
                    island++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'l' && isAdjacentToWater(i, j)) {
                    map[i][j] = 'w';
                }
            }
        }

        int islandAfterFlood = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'l') {
                    dfsAfterFlood(i, j);
                    islandAfterFlood++;
                }
            }
        }

        System.out.println(island - islandAfterFlood);

        // // 一通BFS
        // int count = 0;
        // for (int i = 1; i <= N; i++) {
        // for (int j = 1; j <= N; j++) {
        // if (map[i][j] == '#') {
        // if (bfs(i, j))
        // count++;
        // }
        // }
        // }
        // System.out.println(count);
    }

    private static boolean bfs(int i, int j) {
        int total = 0; // 连通块中岛屿个数
        int fringe = 0; // 连通块中，边缘岛屿个数
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        boolean[][] visited = new boolean[N + 2][N + 2];
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            map[cur[0]][cur[1]] = 'o';
            total++;

            boolean isFringe = false;
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                    if (map[x][y] == '#') {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    } else if (map[x][y] == '.') {
                        isFringe = true;
                    }
                }
            }
            if (isFringe)
                fringe++;
        }
        return total == fringe; // 会被淹没
    }

    private static boolean isAdjacentToWater(int i, int j) {
        // 检查像素上下左右是否有海洋
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < N && y >= 0 && y < N && map[x][y] == '.') 
                return true;
        }
        return false;
    }

    private static void dfs(int i, int j) {
        map[i][j] = 'l';

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 1 && x <= N && y >= 1 && y <= N && map[x][y] == '#') {
                dfs(x, y);
            }
        }
    }

    private static void dfsAfterFlood(int i, int j) {
        map[i][j] = '.';

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 1 && x <= N && y >= 1 && y <= N && map[x][y] != '.') {
                dfsAfterFlood(x, y);
            }
        }
    }
}
