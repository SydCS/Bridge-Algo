import java.util.Scanner;

// https://www.acwing.com/problem/content/description/645/
public class Grid {
    static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int R = sc.nextInt(), C = sc.nextInt();
            int[][] map = new int[R][C];
            for (int i = 0; i < R; i++) {
                String s = sc.next();
                for (int j = 0; j < C; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            System.out.println("Case #" + t + ": ");

            int N = sc.nextInt();
            while (N-- > 0) {
                String s = sc.next();
                char op = s.charAt(0);
                if (op == 'Q') {
                    // 1的连通块
                    int count = 0;
                    boolean[][] visited = new boolean[R][C];
                    for (int i = 0; i < R; i++) {
                        for (int j = 0; j < C; j++) {
                            if (map[i][j] == 1 && !visited[i][j]) { // 不改变map
                                dfs(map, visited, i, j);
                                count++;
                            }
                        }
                    }
                    System.out.println(count);
                } else if (op == 'M') {
                    map[sc.nextInt()][sc.nextInt()] = sc.nextInt();
                }
            }
        }
        sc.close();
    }

    private static void dfs(int[][] map, boolean[][] visited, int i, int j) {
        // Flood Fill
        visited[i][j] = true;

        for (int[] dir : dirs) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < map.length && nj >= 0 && nj < map[0].length && map[ni][nj] == 1 && !visited[ni][nj]) {
                dfs(map, visited, ni, nj);
            }
        }
    }
}
