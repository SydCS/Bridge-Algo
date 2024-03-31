import java.util.Scanner;

// https://www.acwing.com/problem/content/689/
public class Minesweeper {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = scanner.next().toCharArray();
            }

            int[][] state = new int[N][N]; // 周围有几个雷
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') {
                        state[i][j] = -1;
                    } else {
                        for (int[] dir : dirs) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == '*') {
                                state[i][j]++;
                            }
                        }
                    }
                }
            }

            // 0的连通块
            int click = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (state[i][j] == 0) {
                        dfs(state, i, j);
                        click++;
                    }
                }
            }

            // 周围没有0的
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (state[i][j] >= 1) {
                        click++;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + click);
        }
        scanner.close();
    }

    private static void dfs(int[][] map, int i, int j) {
        // Flood Fill
        map[i][j] = -2;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < map.length && nj >= 0 && nj < map[0].length) {
                if (map[ni][nj] == 0) {
                    dfs(map, ni, nj);
                } else if (map[ni][nj] >= 1) {  // 边界
                    map[ni][nj] = -2;
                }
            }
        }
    }
}
