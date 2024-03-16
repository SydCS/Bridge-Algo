import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1162
public class Color {
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        // 四周开搜
        for (int i = 0; i < n; i++) {
            if (map[i][0] == 0)
                dfs(i, 0, map);
            if (map[i][n - 1] == 0)
                dfs(i, n - 1, map);
        }
        for (int j = 0; j < n; j++) {
            if (map[0][j] == 0)
                dfs(0, j, map);
            if (map[n - 1][j] == 0)
                dfs(n - 1, j, map);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch (map[i][j]) {
                    case -1:
                        System.out.print(0 + " ");
                        break;
                    case 0:
                        System.out.print(2 + " ");
                        break;
                    default:
                        System.out.print(1 + " ");
                        break;
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    public static void dfs(int x, int y, int[][] map) {
        map[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length && map[nextX][nextY] == 0)
                dfs(nextX, nextY, map);
        }
    }
}
