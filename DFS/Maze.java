import java.util.*;

// https://acm.hdu.edu.cn/showproblem.php?pid=1010
public class Maze {
    static char[][] maze;
    static int n, m, t;
    static int endX, endY;
    static boolean reach = false;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            t = scanner.nextInt();
            if (n == 0 && m == 0 && t == 0)
                break;

            maze = new char[n][m];
            int startX = 0, startY = 0, unreachable = 0;
            for (int i = 0; i < n; i++) {
                String line = scanner.next();
                for (int j = 0; j < m; j++) {
                    maze[i][j] = line.charAt(j);
                    if (maze[i][j] == 'S') {
                        startX = i;
                        startY = j;
                    } else if (maze[i][j] == 'D') {
                        endX = i;
                        endY = j;
                    } else if (maze[i][j] == 'X') {
                        unreachable++;
                    }
                }
            }

            if (n * m - unreachable <= t) { // 剪枝
                System.out.println("No");
                continue;
            }
            if ((t - Math.abs(endX - startX) - Math.abs(endY - startY)) % 2 == 1) { // 奇偶剪枝
                System.out.println("No");
                continue;
            }

            reach = false;
            maze[startX][startY] = 'X';
            dfs(startX, startY, 0);
            System.out.println(reach ? "YES" : "NO");
        }
        scanner.close();
    }

    public static void dfs(int x, int y, int step) {
        if (x == endX && y == endY && step == t) {
            reach = true;
            return;
        }

        if (Math.abs(x - endX) + Math.abs(y - endY) > t - step) { // 剪枝
            return;
        }

        maze[x][y] = 'X';
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && maze[nextX][nextY] != 'X') {
                dfs(nextX, nextY, step + 1);
            }
        }
        maze[x][y] = '*';
    }
}
