import java.util.Scanner;

// https://www.luogu.com.cn/problem/P1506
public class Flood {
    static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt(), y = scanner.nextInt();
        char[][] map = new char[x][y];
        for (int i = 0; i < x; i++) {
            String line = scanner.next();
            for (int j = 0; j < y; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        scanner.close();

        // 四周开搜
        for (int i = 0; i < x; i++) {
            if (map[i][0] == '0')
                dfs(i, 0, map);
            if (map[i][y - 1] == '0')
                dfs(i, y - 1, map);
        }
        for (int j = 0; j < y; j++) {
            if (map[0][j] == '0')
                dfs(0, j, map);
            if (map[x - 1][j] == '0')
                dfs(x - 1, j, map);
        }

        // 统计剩余0
        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == '0')
                    count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int x, int y, char[][] map) {
        map[x][y] = '1';

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length && map[nextX][nextY] == '0')
                dfs(nextX, nextY, map);
        }
    }
}
