import java.util.*;

// https://www.acwing.com/problem/content/description/2062/
// https://www.luogu.com.cn/problem/P6131
public class CowBeautyPageant {
    static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int N, M;
    static char[][] board;
    static List<List<Point>> points = new ArrayList<>(); // 3个点集

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // consume the rest of the line

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }

        // 找连通分量：DFS / BFS / 并查集
        int k = 0;
        points.add(new ArrayList<>());
        points.add(new ArrayList<>());
        points.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'X')
                    dfs(i, j, points.get(k++));
            }
        }

        // 枚举得需要涂色区域的最少数量
        // 走法1：两两枚举点集
        int minDist01 = 0x3f3f3f3f;
        for (Point p : points.get(0)) {
            for (Point q : points.get(1)) {
                minDist01 = Math.min(minDist01, Math.abs(p.x - q.x) + Math.abs(p.y - q.y)); // 两点集中各点间最小的Mahattan距离
            }
        }
        int minDist02 = 0x3f3f3f3f;
        for (Point p : points.get(0)) {
            for (Point q : points.get(2)) {
                minDist02 = Math.min(minDist02, Math.abs(p.x - q.x) + Math.abs(p.y - q.y));
            }
        }
        int minDist12 = 0x3f3f3f3f;
        for (Point p : points.get(1)) {
            for (Point q : points.get(2)) {
                minDist12 = Math.min(minDist12, Math.abs(p.x - q.x) + Math.abs(p.y - q.y));
            }
        }
        int minDistTotal1 = minDist01 - 1 + minDist02 - 1 + minDist12 - 1
                - (Math.max(minDist01, Math.max(minDist02, minDist12)) - 1);

        // 走法2：枚举所有空点
        int minDistTotal2 = 0x3f3f3f3f;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == '.') {
                    int tmp = 0;
                    for (int n = 0; n <= 2; n++) {
                        int minDist = 0x3f3f3f3f;
                        for (Point p : points.get(n)) {
                            minDist = Math.min(minDist, Math.abs(p.x - i) + Math.abs(p.y - j));
                        }
                        tmp += minDist - 1;
                    }
                    minDistTotal2 = Math.min(minDistTotal2, tmp);
                }
            }
        }
        System.out.println(Math.min(minDistTotal1, minDistTotal2 + 1));
        scanner.close();
    }

    private static void dfs(int i, int j, List<Point> points) {
        board[i][j] = 'o';
        points.add(new Point(i, j));

        for (int[] dir : dirs) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < M && board[nextI][nextJ] == 'X')
                dfs(nextI, nextJ, points);
        }
    }
}
